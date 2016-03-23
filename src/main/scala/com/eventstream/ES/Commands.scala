package com.eventstream.ES

/**
 * Created by prayagupd
 * on 3/12/16.
 */

sealed trait Command
case class PackageReleaseCommand(packageId: String, items: Array[String]) extends Command

sealed trait Event
case class PackageReleasedEvent(packageId: String, items: Array[String]) extends Event
