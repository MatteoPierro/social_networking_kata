package com.socialnetwork;

import java.util.Collections;
import java.util.List;

public class InMemorySocialNetwork implements SocialNetwork {


    @Override
    public void publish(String user, String message) {

    }

    @Override
    public List<String> timelineFor(String user) {
        return Collections.singletonList("a message");
    }
}
