package com.socialnetwork;

import java.util.List;

public interface SocialNetwork {
    void publish(String user, String message);

    List<String> timelineFor(String user);
}
