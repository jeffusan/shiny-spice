name := "Shiny Spice"

version := "0.0.1"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq (
  "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test",
  "org.scalaj" % "scalaj-http_2.11" % "1.1.0",
  "org.postgresql" % "postgresql" % "9.3-1102-jdbc41",
  "com.typesafe.play" %% "play-json" % "2.4.0-M2",
  "com.github.nscala-time" %% "nscala-time" % "1.6.0"
)
