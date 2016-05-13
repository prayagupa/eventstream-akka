package com.eventstream.ES

/**
 * https://github.com/ironfish/akka-persistence-mongo-samples/blob/master/mongo-cqrs-es-app/src/main/scala/com/github/ironfish/akka/persistence/cqrses/sample/Employee.scala
 * Created by prayagupd
 * on 2/10/16.
 */

import akka.actor._
import akka.persistence._

class PackageReleasePersistentActor extends PersistentActor {
  override def persistenceId = "packageReleasedActor"

  // state is a list of persisted event data contained in PackageState.
  var internalState = ReleasedPackages_State()

  // persists events asynchronously and the event handler is executed for successfully persisted events.
  // Successfully persisted events are internally sent back to the persistent actor as individual messages that trigger event
  // handler executions.
  val receiveCommand: Receive = {
    case PackageReleaseCommand(packageId, items) =>

      persist(processCommand(packageId, items)) { persistedEvent =>
        updateActorState(persistedEvent)
        publishToTheWorld(persistedEvent)
      }

    case "snapshotIt"  => saveSnapshot(internalState)
    case "displayActorState" => println(internalState)
  }

  def processCommand(packageId: String, items: Array[String]): PackageReleasedEvent = {
    //side effect
    //update collection
    PackageReleasedEvent(packageId, items)
  }

  // receiveRecover method defines how state is updated during recovery
  // by handling PackageReleasedEvent and SnapshotOffer messages
  val receiveRecover: Receive = {
    case event: PackageReleasedEvent => {
      println("receiveRecover")
      updateActorState(event)
    }
    case SnapshotOffer(_, snapshot: ReleasedPackages_State) => internalState = snapshot
  }

  def updateActorState(releasedEvent: PackageReleasedEvent): Unit =
    internalState = internalState.apply(releasedEvent)

  def sequenceId =
    internalState.size

  def publishToTheWorld(event: Event): Unit = {
    context.system.eventStream.publish(event)
  }
}
