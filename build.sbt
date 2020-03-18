val dottyVersion = "0.23.0-RC1"

lazy val root = (project in file(".")).
  settings(
    name := "dotty-simple",
    version := "0.1",
     scalacOptions ++= Seq("-Yexplicit-nulls", "-Yerased-terms", "-Xfatal-warnings"),
//    scalacOptions ++= Seq("-Ykind-projector", "-language:existentials,higherKinds,implicitConversions"),

    scalaVersion := dottyVersion,
    //scalafmtOnCompile := true,
    libraryDependencies +=  ("org.typelevel" %% "cats-core" % "2.1.0").withDottyCompat(scalaVersion.value),

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  )
