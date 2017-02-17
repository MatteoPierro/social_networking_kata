package com.socialnetwork.UAT;

import com.socialnetwork.SocialNetworkCommandLine;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PublishAndRetrievesMessage {

    @Test
    @Ignore
    public void
    scenario() throws Exception {
        SocialNetworkCommandLine commandLine = new SocialNetworkCommandLine();
        commandLine.execute("Alice -> I love the weather today");
        String messages = commandLine.execute("Alice");

        assertTrue(messages.contains("I love the weather today"));
    }
}
