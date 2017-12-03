sbtPlugin := true

//crossScalaVersions := Seq("2.10.7", "2.12.4")
//scalaVersion := "2.10.7"
scalaVersion := "2.12.4"

name := "SbtJSLibby"

organization := "scalavision"

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.21")

enablePlugins(ScalaJSPlugin)


