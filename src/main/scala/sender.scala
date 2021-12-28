import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.Await
import scala.concurrent.duration._

object sender extends App {
val ActSys = ActorSystem("SimpleActor")
  val receiverActor = ActSys.actorOf(Props(new caller("Something")))
  implicit val timeout = Timeout(5.seconds)
  receiverActor ! 10
  receiverActor ! 7
  val result = receiverActor ? "Try This"

  val msg = Await.result(result, timeout.duration)
   println(s"got This msg : $msg")

}
