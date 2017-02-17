package com.socialnetwork.UAT;

import com.socialnetwork.SocialNetworkCommandLine;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PublishAndRetrievesMessage {

    @Test
    public void
    scenario() throws Exception {
        SocialNetworkCommandLine commandLine = new SocialNetworkCommandLine();
        commandLine.execute("Alice -> I love the weather today");
        String messages = commandLine.execute("Alice");

        assertTrue(messages.contains("I love the weather today"));
    }
}
