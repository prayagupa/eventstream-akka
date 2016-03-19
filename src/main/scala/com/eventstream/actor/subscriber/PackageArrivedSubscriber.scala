package com.eventstream.subscriber

import akka.actor.Actor
import com.eventstream.actor.PackageArrivedEvent

/**
 * Created by prayagupd
 * on 2/7/16.
 */

class PackageArrivedSubscriber extends Actor {

  override def preStart =
    context.system.eventStream.subscribe(self, classOf[PackageArrivedEvent])

  def receive = {
    case packageToShip: PackageArrivedEvent => {
      println(s"${self.path.name} - receiving a new package: $packageToShip")
    }
  }
}
