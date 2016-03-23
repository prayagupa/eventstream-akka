package com.eventstream.ES

/**
 * Created by prayagupd
 * on 3/12/16.
 */

case class ReleasedPackages_State(history: List[PackageReleasedEvent] = Nil) {

  def apply(event: PackageReleasedEvent): ReleasedPackages_State =
    copy(event :: history)

  def size: Int =
    history.length

  override def toString: String =
    history.reverse.toString()
}