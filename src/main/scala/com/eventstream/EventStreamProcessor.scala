package com.eventstream

import akka.actor.{ActorSystem, Props}

/**
 * Created by prayagupd
 * on 2/6/16.
 */

object EventStreamProcessor extends App {

  val system = ActorSystem("EventStream")
  val packageArrivedListener = system.actorOf(Props[PackageArrivedListener], name = "packageArrivedListener")

  packageArrivedListener ! PackageArrived(100)
  packageArrivedListener ! "PackageCanceled"
}
