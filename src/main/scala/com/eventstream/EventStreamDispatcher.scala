package com.eventstream

import akka.actor.{ActorSystem, Props}
import com.eventstream.BusinessEvent
/**
 * Created by prayagupd
 * on 2/6/16.
 */

object EventStreamDispatcher {

  val system = ActorSystem("EventStream")
  val shippingActor = system.actorOf(Props[ShippingActor], name = "ShippingActor")

  def dispatchEvent(): Unit = {

    shippingActor ! readEventFromStream(PackageArrived.getClass)
    shippingActor ! readEventFromStream(PackageArrived.getClass)
    shippingActor ! "PackageCanceled"
  }

  def readEventFromStream(clazz: Class[_]): BusinessEvent = {
    PackageArrived(100)
  }
}
