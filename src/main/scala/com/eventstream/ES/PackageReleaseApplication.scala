package com.eventstream.ES

import akka.actor.{Props, ActorSystem}

/**
 * Created by prayagupd
 * on 3/17/16.
 */

object PackageReleaseApplication {

  def main(args: Array[String]) {
    start()
  }

  def start(): Unit = {
    implicit val system = ActorSystem("event-stream")

    val packageReleasedActor = system.actorOf(Props[PackageReleasePersistentActor], "packageReleasedActor")

    packageReleasedActor ! PackageReleaseCommand("PCKG001", Array("shirts","pants"))
    packageReleasedActor ! PackageReleaseCommand("PCKG002", Array("tees,underwear"))

    packageReleasedActor ! "snapshotIt"

    packageReleasedActor ! PackageReleaseCommand("PCKG003", Array("coat"))
    packageReleasedActor ! "displayActorState"

    Thread.sleep(1000)

    system.terminate()
  }

  def restart(): Unit = {
    implicit val system = ActorSystem("event-stream")

    val packageReleasedActor = system.actorOf(Props[PackageReleasePersistentActor], "packageReleasedActor")

    packageReleasedActor ! PackageReleaseCommand("PCKG00-AFTER-RESTART", Array("pants"))

    packageReleasedActor ! "displayActorState"

    Thread.sleep(1000)

    system.terminate()
  }

}
