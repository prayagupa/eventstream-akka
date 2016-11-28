package com.eventstream
import java.util.Date

/**
 * Created by prayagupd
 * on 2/6/16.
 */

trait BusinessEvent

case class PackageArrived(weight: Int) extends BusinessEvent
case class PackageShipped(shippedDate: Date) extends BusinessEvent
