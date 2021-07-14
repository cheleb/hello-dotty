val latestScala3Version = "3.0.0"
val latestScala3NightlyVersion = "3.0.1-RC1-bin-20210528-56abade-NIGHTLY"

inThisBuild(
  Seq(
    scalacOptions ++= Seq("-Yexplicit-nulls", "-Xfatal-warnings"),
    scalafmtOnCompile := true
  )
)

lazy val root = (project in file("."))
  .settings(
    name := "hello-dotty",
    version := "0.1"
  )
  .aggregate(core, zio)

lazy val core = (project in file("core"))
  .settings(
    scalaVersion := latestScala3Version,
//    scalacOptions += "-language:experimental.erasedDefinitions",
    scalafmtOnCompile := true
  )

lazy val zio = (project in file("zio"))
  .settings(
    scalaVersion := "3.0.1",
    libraryDependencies ++= Seq("zio", "zio-test", "zio-test-sbt").map("dev.zio" %% _ % "1.0.9"),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
//    libraryDependencies += "org.scalameta" %% "scalameta" % "4.4.14"
  )
