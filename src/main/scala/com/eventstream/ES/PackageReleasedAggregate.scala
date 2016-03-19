package com.eventstream.ES

/**
 * Created by prayagupd
 * on 3/12/16.
 */

case class PackageReleasedAggregate(history: List[PackageReleasedEvent] = Nil) {

  def apply(event: PackageReleasedEvent): PackageReleasedAggregate =
    copy(event :: history)

  def size: Int =
    history.length

  override def toString: String =
    history.reverse.toString()
}