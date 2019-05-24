val dottyVersion = "0.14.0-RC1"

lazy val root = (project in file(".")).
  settings(
    name := "dotty-simple",
    version := "0.1",

    scalaVersion := dottyVersion,

    libraryDependencies +=  ("org.typelevel" %% "cats-core" % "1.6.0").withDottyCompat(scalaVersion.value),

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  )
