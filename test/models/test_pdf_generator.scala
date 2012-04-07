package test.models
import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._
import models._
import java.io.File

class TestPdfGenerator extends Specification {
  "takes two parameters" in {
    val f = File.createTempFile("foo", "bar")
    val pg = new PdfGenerator(f,f)
    pg must not beNull
  }

  "has a generate method" in {
    val f = File.createTempFile("foo", "bar")
    val pg = new PdfGenerator(f,f)
    pg.generate(f) must not beNull
  }
}
