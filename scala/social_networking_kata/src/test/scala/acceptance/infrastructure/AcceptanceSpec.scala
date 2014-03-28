package acceptance.infrastructure

import org.scalatest._
import org.scalatest.mock.MockitoSugar

abstract class AcceptanceSpec extends FeatureSpec
								 with MockitoSugar
								 with GivenWhenThen
								 with SocialNetworkingDSL {

}
