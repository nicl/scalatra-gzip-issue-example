package net.room271.gzip

import org.scalatra._
import scala.concurrent.Future
import org.scalatra.json.JacksonJsonSupport
import org.json4s.Formats
import org.json4s.DefaultFormats

class ExampleServlet extends ExampleGzipIssueStack with FutureSupport with GZipSupport with JacksonJsonSupport {

  protected implicit def executor = concurrent.ExecutionContext.Implicits.global
  protected implicit val jsonFormats: Formats = DefaultFormats

  before() {
    contentType = formats("json")
  }

  get("/") {
    Future {
      case class Example(a: Int)
      Example(1)
    }
  }
  
}
