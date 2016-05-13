package ES

import akka.actor.ActorSystem
import akka.testkit.{TestActors, ImplicitSender, TestKit}
import org.scalatest.{Matchers, BeforeAndAfterAll, WordSpecLike}

/**
 * http://doc.akka.io/docs/akka/snapshot/scala/testing.html
 * Created by prayagupd
 * on 3/19/16.
 */

class PackageReleasePersistentActorIntegrationSpecextends() extends TestKit(ActorSystem("MySpec"))
with ImplicitSender
with WordSpecLike
with Matchers
with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  "An Echo actor" must {

    "send back messages unchanged" in {
      val echo = system.actorOf(TestActors.echoActorProps)
      echo ! "releaseme"
      expectMsg("releaseme")
    }

  }
}
