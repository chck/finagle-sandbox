import com.twitter.finagle.Http
import com.twitter.util.Await
import io.finch._

object Main {
  val endpoint: Endpoint[String] = get("hello") {
    Ok("Hello World!!")
  }

  def main(args: Array[String]): Unit = {
    Await.ready(Http.serve(":8080", endpoint.toService))
  }
}
