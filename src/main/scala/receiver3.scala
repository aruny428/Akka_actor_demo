import akka.actor.Actor

class receiver3 extends Actor {

  def receive ={
    case msg =>
      println(s"got this from a router, message is $msg ")
  }
}
