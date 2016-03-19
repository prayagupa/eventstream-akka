package com.eventstream.ES

/**
 * Created by prayagupd
 * on 3/12/16.
 */

sealed trait Command
case class PackageReleaseCommand(idWhichIsData: String) extends Command

sealed trait Event
case class PackageReleasedEvent(index: Int, id: String) extends Event
