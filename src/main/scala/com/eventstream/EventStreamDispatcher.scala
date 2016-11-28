package com.eventstream

import akka.actor.{ActorSystem, Props}
import com.eventstream.BusinessEvent
/**
 * Created by prayagupd
 * on 2/6/16.
 */

object EventStreamDispatcher {

  val system = ActorSystem("EventStream")
  val packageArrivedActor = system.actorOf(Props[PackageArrivedActor], name = "packageArrivedConsumer")

  def dispatchEvent(): Unit = {

    packageArrivedActor ! readEventFromStream(PackageArrived.getClass)
    packageArrivedActor ! "PackageCanceled"
  }

  def readEventFromStream(clazz: Class[_]): BusinessEvent = {
    PackageArrived(100)
  }
}
