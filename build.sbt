name := "EventStreamAkka"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.1"

libraryDependencies += "com.typesafe.akka" %% "akka-persistence" % "2.4.1"

libraryDependencies += "com.github.ironfish" %% "akka-persistence-mongo"  % "1.0.0-SNAPSHOT" % "compile"

//libraryDependencies += "com.github.ironfish" %% "akka-persistence-mongo-casbah"  % "0.7.6" % "compile"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.6" % "test"

libraryDependencies += "com.typesafe.akka" % "akka-testkit_2.11" % "2.4.1"

//   "de.flapdoodle.embed"     % "de.flapdoodle.embed.mongo"        % Common.EmbeddedMongoVersion    % "test",

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
