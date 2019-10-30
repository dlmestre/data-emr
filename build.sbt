import sbt.Resolver

name := "data-parser"

version := "0.1"

scalaVersion := "2.11.12"

resolvers += Resolver.sonatypeRepo("releases")

lazy val dependencies = new {
  val sparkV = "2.1.0"
  
  val sparkCore = "org.apache.spark" %% "spark-core" % sparkV
  val sparkSql = "org.apache.spark" %% "spark-sql" % sparkV
  
}

libraryDependencies += "com.beust" % "jcommander" % "1.58"
libraryDependencies += "joda-time" % "joda-time" % "2.9.4"
libraryDependencies += "org.joda" % "joda-convert" % "1.8"
libraryDependencies += "junit" % "junit" % "4.10" % Test
libraryDependencies ++= Seq(
  dependencies.sparkCore,
  dependencies.sparkSql
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
