name := "woopraScalaAPI"

version := "0.1"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
//TDD
  "org.scalatest" % "scalatest_2.11" % "2.2.5" % "test"
)

//logging
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.2"

//parse json
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.4.3"