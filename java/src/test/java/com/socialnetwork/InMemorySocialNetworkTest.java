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
}