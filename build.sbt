val latestScala3Version = "3.0.0-RC3"

inThisBuild(
  Seq(
     scalacOptions ++= Seq("-Yexplicit-nulls", "-Xfatal-warnings"),
  )
)


lazy val root = (project in file(".")).
  settings(
    name := "hello-dotty",
    version := "0.1"
  ).aggregate(core, zio)

lazy val core = (project in file("core"))
.settings(
   scalaVersion := latestScala3Version
)


lazy val zio = (project in file("zio"))
.settings(
   scalaVersion := "3.0.0-RC2",
   libraryDependencies +=  ("dev.zio" %% "zio" % "1.0.6"),//.withDottyCompat(scalaVersion.value),
)
