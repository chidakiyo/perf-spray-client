import java.io.File
import scala.concurrent.duration.DurationInt
import akka.actor.ActorSystem
import akka.actor.Props
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import spray.can.Http

object Boot extends App {
  implicit val system = ActorSystem("on-spray-can")
  val service = system.actorOf(Props[MyServiceActor], "clouddeck-service")
  implicit val timeout = Timeout(100.seconds)
  IO(Http) ? Http.Bind(service, interface = "0.0.0.0", port = AppConfig.PORT)
}

object AppConfig {
  val PORT = 80
}