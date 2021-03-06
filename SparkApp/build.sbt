name := "SparkApp"

version := "0.1"

scalaVersion := "2.11.8"

val sparkVersion = "2.2.0"

libraryDependencies ++= Seq("org.apache.spark" %% "spark-core" % sparkVersion % "provided")
libraryDependencies ++= Seq("org.apache.spark" % "spark-sql_2.11" % sparkVersion % "provided")