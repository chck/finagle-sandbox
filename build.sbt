name := "finagle-sandbox"

version := "1.0"

scalaVersion := "2.11.7"

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
  "com.github.finagle" %% "finch-core" % "0.11.0-SNAPSHOT" changing()
)
