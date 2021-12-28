import akka.actor.{Actor,ActorSystem,Props}
object sender extends App {
val ActSys = ActorSystem("SimpleActor")
  val receiverActor = ActSys.actorOf(Props(new caller("Something")))

  receiverActor ! 10
  receiverActor ! 7
  receiverActor ! "Try This"
}
