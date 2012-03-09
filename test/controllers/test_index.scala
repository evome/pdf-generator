package test.controllers
import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

class IndexSpec extends Specification {
  "respond to the index Action" in {
    val result = controllers.Application.index()(FakeRequest())

    status(result) must equalTo(OK)
    contentType(result) must beSome("text/html")
    charset(result) must beSome("utf-8")
    contentAsString(result) must contain("evome")
  }
}
