import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "PdfGenerator"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
      "postgresql" % "postgresql" % "8.4-702.jdbc4",
      "org.apache.xmlgraphics" % "fop" % "1.0",
      "org.scalatest" %% "scalatest" % "1.7.1" % "test"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add your own project settings here      
    )
}
