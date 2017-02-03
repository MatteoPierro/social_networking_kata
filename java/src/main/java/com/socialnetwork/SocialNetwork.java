package com.socialnetwork;

public interface SocialNetwork {
    void publish(String user, String message);

    void timelineFor(String user);
}
