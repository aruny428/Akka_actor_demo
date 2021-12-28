import akka.actor.Actor

class receiver2 extends Actor{

  def receive={
    case msg : String =>
      println(s"got $msg from caller ")
  }
}
