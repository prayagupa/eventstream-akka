package com.eventstream.ES

import akka.actor.{Props, ActorSystem}

/**
 * Created by prayagupd
 * on 3/17/16.
 */

object PackageReleaseApplication {

  def main(args: Array[String]) {
    implicit val system = ActorSystem("event-stream")

    val packageReleasedActor = system.actorOf(Props[PackageReleasePersistentActor], "packageReleasedActor")

    packageReleasedActor ! PackageReleaseCommand("shirts,pants")
    packageReleasedActor ! PackageReleaseCommand("shirts,underwear")

    packageReleasedActor ! "snapshotIt"

    packageReleasedActor ! PackageReleaseCommand("coat")
    packageReleasedActor ! "displayCommands"

    Thread.sleep(1000)

    system.terminate()
  }

}
