import AssemblyKeys._

assemblySettings


name := "recommender"

version := "0.8.1"

scalaVersion := "2.10.6"


libraryDependencies ++= Seq(
  "io.prediction"    %% "core"          % pioVersion.value % "provided",

  "org.apache.spark" %% "spark-core"    % "1.3.0" % "provided",

  "org.apache.spark" %% "spark-mllib"   % "1.3.0" % "provided"
  )

//for load data
libraryDependencies += "io.prediction" % "client" % "0.8.3"


//logging - only available in 2.11 but predictionIO wants 2.10
//libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"
//libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.2"

//parse json
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.4.3"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.5" % "test"


