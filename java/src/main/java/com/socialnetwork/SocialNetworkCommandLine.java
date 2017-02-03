package com.socialnetwork;

public class SocialNetworkCommandLine {
    private SocialNetwork socialNetwork;

    public SocialNetworkCommandLine(SocialNetwork socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    public void execute(String command) {
        if(!command.contains("->")) {
            socialNetwork.timelineFor("Alice");
            return;
        }

        String[] parts = command.split(" -> ");
        String username = parts[0];
        String message = parts[1];
        socialNetwork.publish(username, message);
    }
}
