package com.socialnetwork;

import java.util.*;

public class InMemorySocialNetwork implements SocialNetwork {
    private Map<String, List<String>> messages = new HashMap<>();

    @Override
    public void publish(String user, String message) {
        List<String> userMessages = messages.getOrDefault(user, new ArrayList<>());
        userMessages.add(message);
        messages.put(user, userMessages);
    }

    @Override
    public List<String> timelineFor(String user) {
        return messages.getOrDefault(user, new ArrayList<>());
    }
}
