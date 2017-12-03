# sbtJSLibby

Collection of often used libraries for ScalaJS collected in a plugin for easy setup of projects.

You have to build the project from source, jitpack does not support sbt plugin projects (if you know about similar service that does, please show me)

```
# clone the source repo, then
sbt publishLocal
```
Add it to project/plugins.sbt
```scala
addSbtPlugin("scalavision" % "sbtlibby" % "0.1-SNAPSHOT")
```

In your build.sbt file just add the common libraries you want to use:
```scala
enablePlugins(SbtJSLibby)
```

```scala
// Your spesific libraries
libraryDependencies ++= Seq(
 // Some library definitions
 // Then add the library composititions from this plugins
) ++ utilDeps.value ++ metaDeps.value // etc.
```
