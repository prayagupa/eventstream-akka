package com.eventstream.publisher

import akka.actor._
import com.eventstream.actor.PackageArrivedEvent

/**
 * Created by prayagupd
 * on 2/7/16.
 */

class PackageArrivedPublisher extends Actor {
  def receive = {
    case packageToShip: PackageArrivedEvent => {
      println(s"Publishing a new package - $packageToShip")
      context.system.eventStream.publish(packageToShip)
    }
  }
}
