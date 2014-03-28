package acceptance.scenario

import acceptance.AcceptanceSpec
import org.mockito.Mockito
import org.mockito.Mockito._
import com.codurance.socialnetworking.SocialNetworking
import com.codurance.socialnetworking.user_interface.{UserCommands, Console}
import scala.collection.mutable
import com.codurance.socialnetworking.command.CommandFactory
import com.codurance.socialnetworking.domain.Users

class PostingScenario extends AcceptanceSpec {

	info("In order to share my ideas with the world")
	info("As a user")
	info("I would like to post my messages")
	info("And make them available so other users could read them")

	feature("Posting and reading messages") {

		scenario("User posts messages") {
			val application = fixture

			Given("Alice posts messages")
				application receives(FIRST_POST_COMMAND_FROM_ALICE,
									 SECOND_POST_COMMAND_FROM_ALICE)

			When("Bob reads Alice's messages")
				application receives bobReadsMessageFromAlice
				application start

			Then("Alice's messages are displayed in reverse-chronological order")
				application displays(SECOND_MESSAGE_FROM_ALICE, FIRST_MESSAGE_FROM_ALICE)
		}
	}

	val FIRST_MESSAGE_FROM_ALICE = "Hello, my name is Alice"
	val SECOND_MESSAGE_FROM_ALICE = "It's a lovely day today"
	val FIRST_POST_COMMAND_FROM_ALICE = "Alice -> " + FIRST_MESSAGE_FROM_ALICE
	val SECOND_POST_COMMAND_FROM_ALICE = "Alice -> " + SECOND_MESSAGE_FROM_ALICE
	val bobReadsMessageFromAlice = "Alice"

	def fixture = new {

		val QUIT = "quit"
		val console = mock[Console]
		val userCommands = new UserCommands(new CommandFactory(new Users))
		val socialNetworking = new SocialNetworking(console, userCommands)
		var consoleCommands: mutable.MutableList[String] = mutable.MutableList()
		var expectedMessages: mutable.MutableList[String] = mutable.MutableList()

		def receives(userCommands: String*) = {
			consoleCommands ++= userCommands
		}

		def start() = {
			consoleCommands += "quit"
			Mockito.when(console.readline()).thenReturn(consoleCommands.head, consoleCommands.tail:_*)
			socialNetworking start
		}

		def displays(messages: String*) = {
			expectedMessages ++= messages
			expectedMessages foreach(m => verify(console).write(m))
		}
	}



}
