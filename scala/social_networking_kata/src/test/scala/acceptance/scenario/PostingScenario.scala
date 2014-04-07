package acceptance.scenario

import acceptance.infrastructure.AcceptanceSpec

class PostingScenario extends AcceptanceSpec {

	info("In order to share my ideas with the world")
	info("As a user")
	info("I would like to post my messages")
	info("And make them available so other users could read them")

	feature("Posting and reading messages") {

		scenario("User posts messages") {

			Given("Alice posts messages")
				application receives(TWO_SECONDS_AGO, "Alice -> Hello, my name is Alice")
				application receives(NOW, "Alice -> It's a lovely day today")

			When("Bob reads Alice's messages")
				application receives bobReadsMessageFromAlice

			Then("Alice's messages are displayed in reverse-chronological order")
				application start()
				application displays("Alice - It's a lovely day today (just now)",
						             "Alice - Hello, my name is Alice (2 seconds ago)")
		}
	}

	val bobReadsMessageFromAlice = "Alice"

}
