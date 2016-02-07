package com.eventstream

import akka.actor.{ActorSystem, Props}
import com.eventstream.Event
/**
 * Created by prayagupd
 * on 2/6/16.
 */

object EventStreamProcessor {

  def process(): Unit = {
    val system = ActorSystem("EventStream")
    val packageArrivedListener = system.actorOf(Props[PackageArrivedListener], name = "packageArrivedListener")

    packageArrivedListener ! readEventFromStream(PackageArrived.getClass)
    packageArrivedListener ! "PackageCanceled"
  }

  def readEventFromStream(clazz: Class[_]): Event = {
    PackageArrived(100)
  }
}
