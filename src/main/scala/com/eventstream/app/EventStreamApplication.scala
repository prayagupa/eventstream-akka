package com.eventstream.app

/**
 * Created by prayagupd
 * on 2/7/16.
 */

import akka.actor._
import com.eventstream.PackageArrivedEvent
import com.eventstream.publisher.PackageArrivedPublisher
import com.eventstream.subscriber.PackageArrivedSubscriber

object EventStreamApplication extends App {

  implicit val system = ActorSystem("event-stream")

  val packageId = "package001"

  val packagePublisher = system.actorOf(Props[PackageArrivedPublisher], name = "package-publisher")

  val subscriber1 = system.actorOf(Props[PackageArrivedSubscriber], name = "subscriber-1")
  val subscriber2 = system.actorOf(Props[PackageArrivedSubscriber], name = "subscriber-2")

  packagePublisher ! PackageArrivedEvent(packageId = "package001", items = List("shirts", "pants"))

  system.eventStream.unsubscribe(subscriber2, classOf[PackageArrivedEvent])

  packagePublisher ! PackageArrivedEvent(packageId = "package002", items = List("underwear"))
}
