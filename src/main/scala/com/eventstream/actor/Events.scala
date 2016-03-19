package com.eventstream.actor

import java.util.Date

/**
 * Created by prayagupd
 * on 2/6/16.
 */

trait Event
trait MessageLog

case class PackageArrivedEvent(packageId: String, items: List[String]) extends Event
case class PackageShipped(shippedDate: Date) extends MessageLog
