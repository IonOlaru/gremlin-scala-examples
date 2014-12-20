name := "gremlin-scala-examples"

version := "1.0.0-SNAPSHOT"

organization := "com.michaelpollmeier"

scalaVersion := "2.10.4" //2.11 doesn't work because neo4j transitively depends on 2.10..

scalacOptions ++= Seq(
  //"-Xlog-implicits"
  //"-Ydebug"
)

net.virtualvoid.sbt.graph.Plugin.graphSettings

// incOptions := incOptions.value.withNameHashing(true)

libraryDependencies <++= scalaVersion { scalaVersion =>
  val gremlinVersion = "3.0.0.M6"
  Seq(
    "com.michaelpollmeier" %% "gremlin-scala" % "3.0.0.M6a" exclude("org.slf4j", "slf4j-log4j12"),
    "com.tinkerpop" % "neo4j-gremlin" % gremlinVersion
  )
}

resolvers ++= Seq(
  "Local Maven Repository" at Path.userHome.asFile.toURI.toURL + "/.m2/repository"
)
