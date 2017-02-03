package com.socialnetwork;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SocialNetworkShould {

    @Mock private SocialNetwork socialNetwork;

    @Test
    public void publish_messages_to_user_timeline() throws Exception {
        SocialNetworkCommandLine commandLine = new SocialNetworkCommandLine(socialNetwork);

        commandLine.execute("Alice -> I love the weather today");
        commandLine.execute("Bob -> Damn! We lost!");
        commandLine.execute("Bob -> Good game though.");

        verify(socialNetwork).publish("Alice", "I love the weather today");
        verify(socialNetwork).publish("Bob", "Damn! We lost!");
        verify(socialNetwork).publish("Bob", "Good game though.");
    }
}
