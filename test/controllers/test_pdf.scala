import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

class TestPdf extends Specification {
  "/pdf returns BadRequest if required data is missing" in {
    running( FakeApplication() ) {
        val Some(result) = routeAndCall(
          FakeRequest(
            POST, "/pdf",
            FakeHeaders(),
            MultipartFormData(
              Map() ,
              Seq(),
              Seq(),
              Seq()
            )
          ))
        status(result)          must be equalTo(BAD_REQUEST)
        contentType(result)     must beSome("text/xml")
        contentAsString(result) must contain("<error>something went wrong</error>")
      }
  }

  "/pdf returns a PDF if required data is present" in {
    running( FakeApplication() ) {
        val Some(result) = routeAndCall(
          FakeRequest(
            POST, "/pdf",
            FakeHeaders(),
            MultipartFormData(
              Map(
                "data" -> Seq("<xml></xml>"),
                "xslfo" -> Seq("<xml></xml>")
              ),
              Seq(),
              Seq(),
              Seq()
            )
          ))
        status(result)          must be equalTo(OK)
        contentType(result)     must beSome("application/pdf")
      }
  }
}
