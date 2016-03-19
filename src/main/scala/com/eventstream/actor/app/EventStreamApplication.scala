package com.eventstream.actor.app

/**
 * Created by prayagupd
 * on 2/7/16.
 */

import akka.actor._
import com.eventstream.actor.PackageArrivedEvent
import com.eventstream.publisher.PackageArrivedPublisher
import com.eventstream.subscriber.PackageArrivedSubscriber

object EventStreamApplication extends App {

  implicit val system = ActorSystem("event-stream")

  val packageId = "package001"

  val packagePublisher = system.actorOf(Props[PackageArrivedPublisher], name = "package-publisher")

  val packageSubscriber1 = system.actorOf(Props[PackageArrivedSubscriber], name = "PackageArrivedSubscriber1")
  val packageSubscriber2 = system.actorOf(Props[PackageArrivedSubscriber], name = "PackageArrivedSubscriber2")

  packagePublisher ! PackageArrivedEvent(packageId = "package001", items = List("shirts -2", "pants -1"))

  system.eventStream.unsubscribe(packageSubscriber2, classOf[PackageArrivedEvent])

  //subs-2 shouldn't listen to it
  packagePublisher ! PackageArrivedEvent(packageId = "package002", items = List("underwear"))

  //Thread.sleep(1000)
}
