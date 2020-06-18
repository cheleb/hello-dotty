val dottyVersion = "0.25.0-RC2"

lazy val root = (project in file(".")).
  settings(
    name := "dotty-simple",
    version := "0.1",
     scalacOptions ++= Seq("-Yexplicit-nulls", "-Yerased-terms", "-Xfatal-warnings"),
//    scalacOptions ++= Seq("-Ykind-projector", "-language:existentials,higherKinds,implicitConversions"),

//    scalafmtOnCompile := true,
    libraryDependencies +=  ("org.typelevel" %% "cats-core" % "2.1.1").withDottyCompat(scalaVersion.value),
    scalaVersion := dottyVersion

  )
