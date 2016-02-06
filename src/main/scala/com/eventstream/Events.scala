package com.eventstream
import java.util.Date

/**
 * Created by prayagupd
 * on 2/6/16.
 */

trait Event
trait MessageLog

case class PackageArrived(weight: Int) extends Event
case class PackageShipped(shippedDate: Date) extends MessageLog
