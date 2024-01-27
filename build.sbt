name := "lab01"

version := "1.0"

scalaVersion := "2.11.12"

libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.2.11"

val sparkVersion = "2.4.7"
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % Provided,
  "org.apache.spark" %% "spark-sql" % sparkVersion % Provided
)
