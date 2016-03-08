import com.twitter.finagle.Http
import com.twitter.util.Await
import io.finch._

object Main extends App {

  val hello: Endpoint[String] = get("hello") {
    Ok("Hello World!!")
  }
  val time: Endpoint[Time] = post("time" :: body.as[Locale]) { l: Locale =>
    Ok(Time(l, currentTime(new java.util.Locale(l.language, l.country))))
  }
  val endpoints = (hello :+: time).toService

  def currentTime(l: java.util.Locale) = java.util.Calendar.getInstance(l).getTime.toString

  case class Locale(language: String, country: String)

  case class Time(locale: Locale, time: String)

  Await.ready(Http.serve(":8080", endpoints))
}
