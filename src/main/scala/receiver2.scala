import akka.actor.{Actor, Props}
import akka.routing.{ActorRefRoutee, RoundRobinRoutingLogic, Router}

class receiver2 extends Actor{

  val Actsys = context.system
  private val SenderRouter: Router = {
    val Receiver3Routee = for( a <- 1 to 10) yield
      ActorRefRoutee(Actsys.actorOf(Props[receiver3]))
    Router(RoundRobinRoutingLogic(), Receiver3Routee)
  }
  def receive={
    case msg : Int =>
      SenderRouter.route(msg,sender())
      println(s"got $msg from caller ")
    case anotherMsg =>
      println("got something else")
  }
}
