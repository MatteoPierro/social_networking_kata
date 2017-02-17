package com.socialnetwork;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class InMemorySocialNetworkTest {

    @Test
    public void
    publish_and_retrieve_message() throws Exception {
        InMemorySocialNetwork socialNetwork = new InMemorySocialNetwork();

        socialNetwork.publish("Alice", "a message");
        List<String> messages = socialNetwork.timelineFor("Alice");

        assertEquals(1, messages.size());
        assertEquals("a message", messages.get(0));
    }

    @Test
    public void
    publish_and_retrieve_message_for_multiple_timelines() throws Exception {
        InMemorySocialNetwork socialNetwork = new InMemorySocialNetwork();

        socialNetwork.publish("Alice", "a message");
        List<String> aliceMessages = socialNetwork.timelineFor("Alice");

        socialNetwork.publish("Bob", "another message");
        List<String> bobMessages = socialNetwork.timelineFor("Bob");

        assertEquals(1, aliceMessages.size());
        assertEquals("a message", aliceMessages.get(0));
        assertEquals(1, bobMessages.size());
        assertEquals("another message", bobMessages.get(0));
    }
}