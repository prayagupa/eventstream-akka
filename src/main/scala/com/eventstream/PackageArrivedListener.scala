package com.eventstream

import java.util.Date

import akka.actor.Actor
import akka.actor.Actor.Receive

/**
 * Created by prayagupd
 * on 2/6/16.
 */

class PackageArrivedListener extends Actor {

  override def receive: Receive = {
    case PackageArrived(weight) => {
      println("Shipping package")
      PackageShipped(new Date())
      println(s"Package received with weight $weight")
    }
    case _ => println("Unknown event")
  }

}
