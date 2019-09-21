val dottyVersion = "0.19.0-RC1"

lazy val root = (project in file(".")).
  settings(
    name := "dotty-simple",
    version := "0.1",

//    scalacOptions ++= Seq("-Ykind-projector", "-language:existentials,higherKinds,implicitConversions"),

    scalaVersion := dottyVersion,

    libraryDependencies +=  ("org.typelevel" %% "cats-core" % "2.0.0").withDottyCompat(scalaVersion.value),

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  )
