import akka.actor.{Actor,ActorSystem,Props}

class caller(string: String) extends Actor{

  val receiver2Actor = ActorSystem().actorOf(Props[receiver2])

  def receive = {
    case i: Int =>
      i match {
        case 1 => println("Its Monday")
        case 2 => println("Its Tuesday")
        case 3 => println("Its Wednesday")
        case 4 => println("Its Thursday")
        case 5 => println("Its Friday")
        case 6 => println("Its Saturday")
        case 7 =>
          receiver2Actor ! 6
          println("Its Sunday")
        case _ => println("Not a valid weekday ")
      }
      println(s"received $i , with $string")
    case msg =>
      sender() ! "invalid massage !!"
      println(s"received $msg , Not valid !")
  }
}
