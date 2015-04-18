import akka.actor.Actor
import spray.routing._
import spray.http._
import spray.http.MediaTypes._
import spray.routing.Directive.pimpApply
import spray.routing.directives.CachingDirectives._
import spray.json._
import DefaultJsonProtocol._

class MyServiceActor extends Actor with MainService {
  def actorRefFactory = context
  def receive = runRoute(myRoute)
}

trait MainService extends HttpService {
  val myRoute = {
    path("") {
      get {
        respondWithMediaType(`application/json`) {
          complete {
            """親譲おやゆずりの無鉄砲むてっぽうで小供の時から損ばかりしている。小学校に居る時分学校の二階から飛び降りて一週間ほど腰こしを抜ぬかした事がある。なぜそんな無闇むやみをしたと聞く人があるかも知れぬ。別段深い理由でもない。新築の二階から首を出していたら、同級生の一人が冗談じょうだんに、いくら威張いばっても、そこから飛び降りる事は出来まい。弱虫やーい。と囃はやしたからである。小使こづかいに負ぶさって帰って来た時、おやじが大きな眼めをして二階ぐらいから飛び降りて腰を抜かす奴やつがあるかと云いったから、この次は抜かさずに飛んで見せますと答えた。"""
          }
        }
      }
    }
  }
}