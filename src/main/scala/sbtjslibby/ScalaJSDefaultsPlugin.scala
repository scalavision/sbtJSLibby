package sbtjslibby

import sbt.Keys._
import sbt._
import sbt.plugins.JvmPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

object ScalaJSDefaultsPlugin
  extends AutoPlugin {

//  import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
  import autoImport._

  lazy val scalaJsDomVersion = "0.9.3"
  lazy val scalaTagsVersion = "0.6.7"
  lazy val scalaRxVersion = "0.3.2"
  lazy val scalaJsJQueryVersion = "0.9.2"
  lazy val rxLibVersion = "0.1-SNAPSHOT"
  lazy val uPickleVersion = "0.4.4"
  lazy val uTestVersion = "0.5.4"

  lazy val scalaJsDefaults = Seq(
    jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv,
    jsEnv in Test := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv,
    scalaJSStage in Global := FastOptStage,
    scalaJSUseMainModuleInitializer := true,
    emitSourceMaps := true,
    relativeSourceMaps := true,
    scalacOptions in Test ++= Seq("-Yrangepos"),
    skip in packageJSDependencies := false,
    jsDependencies += "org.webjars" % "jquery" % "2.1.4" / "2.1.4/jquery.js",
    testFrameworks += new TestFramework("utest.runner.Framework")
  )
  
  override lazy val projectSettings = Seq(
    scalaJSDefaults := scalaJsDefaults,
    scalaJsDom := "org.scala-js" %%% "scalajs-dom" % scalaJsDomVersion,
    scalaTags := "com.lihaoyi" %%% "scalatags" % scalaTagsVersion,
    scalaRx := "com.lihaoyi" %%% "scalarx" % scalaRxVersion,
    scalaJsJQuery := "be.doeraene" %%% "scalajs-jquery" % scalaJsJQueryVersion,
    rxLib := "com.scalavision" %%% "rxlib" % rxLibVersion,
    uPickle := "com.lihaoyi" %%% "upickle" % uPickleVersion,
    uTest := "com.lihaoyi" %%% "utest" % uTestVersion % "test",
    scalaJSDefaultDeps := Seq(
      scalaJsDom.value, scalaTags.value, scalaRx.value, scalaJsJQuery.value, rxLib.value, uPickle.value, uTest.value
    ),
    scalaWebRxDependencies := Seq(
      scalaJsDom.value, scalaTags.value, scalaRx.value, scalaJsJQuery.value, uPickle.value, uTest.value
    )
  )

  override def trigger = allRequirements
  //override def requires = JvmPlugin
  override def requires = ScalaJSPlugin

  object autoImport {
    val scalaJSDefaults = settingKey[Seq[Setting[_]]]("A setting that is automatically imported to the build")
    val scalaJSDefaultDeps = settingKey[Seq[ModuleID]]("A task that is automatically imported to the build")
    val scalaJsDom = settingKey[ModuleID]("scalajs dom api")
    val scalaTags = settingKey[ModuleID]("scalatags dependency")
    val scalaRx = settingKey[ModuleID]("scalaRx dependency")
    val scalaJsJQuery = settingKey[ModuleID]("scalaJS JQuery dependency")
    val rxLib = settingKey[ModuleID]("scalaJS homegrown rxLib")
    val uPickle = settingKey[ModuleID]("scalaJS uPickle dependency")
    val uTest = settingKey[ModuleID]("scalaJS uTest dependency")
    val scalaWebRxDependencies = settingKey[Seq[ModuleID]]("Dependencies for the webRx Project specifically")
  }

}
