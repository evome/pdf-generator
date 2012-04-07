package models

//Java
import java.io.File
import java.io.OutputStream

//JAXP
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory
import javax.xml.transform.Source
import javax.xml.transform.Result
import javax.xml.transform.stream.StreamSource
import javax.xml.transform.sax.SAXResult

//FOP
import org.apache.fop.apps.FOUserAgent
import org.apache.fop.apps.Fop
import org.apache.fop.apps.FopFactory
//import org.apache.fop.apps.MimeConstants
import org.apache.xmlgraphics.util.MimeConstants

case class PdfGenerator(xmlfile: File, xsltfile: File) {
  def generate(pdffile:File) = {
    val fopFactory  = FopFactory.newInstance()
    val foUserAgent = fopFactory.newFOUserAgent()
    var out = new java.io.BufferedOutputStream(new java.io.FileOutputStream(pdffile))

    //   # Construct fop with desired output format
    val fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out)

    // # Setup XSLT
    val factory = TransformerFactory.newInstance()
    val transformer = factory.newTransformer(new StreamSource(xsltfile))

    //# Set the value of a <param> in the stylesheet
    transformer.setParameter("versionParam", "2.0")

    //# Setup input for XSLT transformation
    val src = new StreamSource(xmlfile)

    //# Resulting SAX events (the generated FO) must be piped through to FOP
    var res = new SAXResult(fop.getDefaultHandler())

    //# Start XSLT transformation and FOP processing
    transformer.transform(src, res)
    out.close()

    this
  }
}
