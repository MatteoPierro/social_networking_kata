package com.socialnetwork;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class InMemorySocialNetworkTest {

    private static final String ALICE = "Alice";
    private static final String ALICE_MESSAGE = "a message";
    private static final String BOB = "Bob";
    private static final String BOB_MESSAGE = "another message";

    @Test
    public void
    publish_and_retrieve_message_for_multiple_timelines() throws Exception {
        SocialNetwork socialNetwork = new InMemorySocialNetwork();

        socialNetwork.publish(ALICE, ALICE_MESSAGE);
        socialNetwork.publish(BOB, BOB_MESSAGE);

        assertThatContainsOnly(ALICE_MESSAGE, socialNetwork.timelineFor(ALICE));
        assertThatContainsOnly(BOB_MESSAGE, socialNetwork.timelineFor(BOB));
    }

    private static void assertThatContainsOnly(String message, List<String> messages) {
        assertEquals(1, messages.size());
        assertEquals(message, messages.get(0));
    }
}