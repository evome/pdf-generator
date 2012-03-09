package controllers

import play.api._
import play.api.mvc._
//Java
import java.io.File
import java.io.OutputStream

import models.PdfGenerator

object Pdf extends Controller {
  def create = Action(parse.multipartFormData) { request =>
    var xmlfile  = File.createTempFile("data", ".xml")
    var xsltfile = File.createTempFile("xsl", ".fo")
    val pdffile  = File.createTempFile("result", ".pdf")

    request.body.file("data").map(  _.ref.moveTo(xmlfile, true)  ).getOrElse(BadRequest)
    request.body.file("xslfo").map( _.ref.moveTo(xsltfile, true) ).getOrElse(BadRequest)

    if(xmlfile.length == 0 || xsltfile.length == 0) {
      BadRequest(<error>something went wrong</error>)
    }
    else {
      val pdf = new PdfGenerator(xmlfile, xsltfile)
      pdf.generate(pdffile)

      xmlfile.delete()
      xsltfile.delete()

      Ok.sendFile(pdffile)
    }
  }
}
