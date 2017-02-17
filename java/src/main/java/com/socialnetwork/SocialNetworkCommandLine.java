package com.socialnetwork;

import java.util.List;
import java.util.stream.Collectors;

public class SocialNetworkCommandLine {
    private SocialNetwork socialNetwork;

    public SocialNetworkCommandLine(SocialNetwork socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    public SocialNetworkCommandLine() {
        this.socialNetwork = new InMemorySocialNetwork();
    }

    public String execute(String command) {
        if(!command.contains("->")) {
            List<String> messages = socialNetwork.timelineFor("Alice");
            return messages.stream().collect(Collectors.joining(""));
        }

        String[] parts = command.split(" -> ");
        String username = parts[0];
        String message = parts[1];
        socialNetwork.publish(username, message);
        return "";
    }
}
