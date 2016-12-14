package com.eventstream

import java.util.Date

import akka.actor.Actor
import akka.actor.Actor.Receive

/**
 * Created by prayagupd
 * on 2/6/16.
 */

class ShippingActor extends Actor {

  var shippedState = 0

  override def receive: Receive = {
    case PackageArrived(weight) => {
      shippedState = shippedState + 1
      println(s"$shippedState packages received.")

      println(" | Shipping package")
      PackageShipped(new Date())
      println(s" | Package shipped with weight $weight")
    }
    case _ => println("Unknown event")
  }

}
