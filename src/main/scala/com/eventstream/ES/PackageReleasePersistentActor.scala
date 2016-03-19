package com.eventstream.ES

/**
 * Created by prayagupd
 * on 2/10/16.
 */

import akka.actor._
import akka.persistence._

class PackageReleasePersistentActor extends PersistentActor {
  override def persistenceId = "packageReleasedActor"

  // state is a list of persisted event data contained in PackageState.
  var aggregate = PackageReleasedAggregate()

  // persists events asynchronously and the event handler is executed for successfully persisted events. Successfully
  // persisted events are internally sent back to the persistent actor as individual messages that trigger event
  // handler executions.
  val receiveCommand: Receive = {
    case PackageReleaseCommand(packageId) =>
      persist(PackageReleasedEvent(historySize, s"$packageId")) (update)

      persist(PackageReleasedEvent(historySize+1, s"$packageId")) { persistedEvent =>
        update(persistedEvent)
        publish(persistedEvent)
      }
    case "snapshotIt"  => saveSnapshot(aggregate)
    case "displayCommands" => println(aggregate)
  }

  // receiveRecover method defines how state is updated during recovery
  // by handling PackageReleasedEvent and SnapshotOffer messages
  val receiveRecover: Receive = {
    case event: PackageReleasedEvent                          => update(event)
    case SnapshotOffer(_, snapshot: PackageReleasedAggregate) => aggregate = snapshot
  }

  def update(event: PackageReleasedEvent): Unit =
    aggregate = aggregate.apply(event)

  def historySize =
    aggregate.size

  def publish(event: Event): Unit = {
    context.system.eventStream.publish(event)
  }
}
