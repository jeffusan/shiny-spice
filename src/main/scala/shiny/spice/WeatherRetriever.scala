package shiny.spice

import java.io.FileWriter
import org.joda.time.DateTime.now
import org.joda.time.DateTimeZone.forID
import play.api.libs.json._
import scalaj.http.Http
import java.io.File


// some test values
//    ("1848354","Asia/Tokyo"),
//    ("4887158","America/Chicago"),
//    ("4887398","America/Chicago"),
//    ("5028509","America/Chicago"),
//    ("4128894","America/Chicago")
// List(("1848354","Asia/Tokyo"),("4887158","America/Chicago"),("4887398","America/Chicago"),("5028509","America/Chicago"),("4128894","America/Chicago"))

object WeatherRetriever {

  val url = "http://api.openweathermap.org/data/2.5/history/city"

  def unixTime(zone:String, minus:Int) : String = {
    return ((now(forID(zone)).minusHours(minus).getMillis() / 1000).toInt).toString
  }

  def retrieveWeather(cities: List[(String,String)]) {
    val city = cities.head

    for(i <- 167 to 1 by -1) { // 167 is the number of hours in a week minus 1

      val weather =
        Http(url).timeout(
          connTimeoutMs = 5000,
          readTimeoutMs = 15000)
          .params(
          List(
            ("id", city._1),
            ("type", "hour"),
            ("start", unixTime(city._2, i)),
            ("cnt", "1"))).asString

      val json:JsValue = Json.parse(weather.body)

      val results = (json \ "list").asOpt[List[JsValue]]

      results match {
        case s:Some[List[JsValue]] =>
          val r:List[JsValue] = s.get
          if(r.size > 0) {
            println("some: " + r(0).toString)
            process(json)
          }
        case None =>
          println("No response")
      }

      if(cities.tail.size > 0) {
        retrieveWeather(cities.tail)
      }
    }
  }

  def process(results:JsValue) {

    def withFileWriter(file: File)(op: FileWriter => Unit) {
      val writer = new FileWriter(file, true)
      try {
        op(writer)
      } finally {
        writer.close()
      }
    }

    val partial = withFileWriter(new File("output.sql"))_

    partial(writer => writer.write("insert into weather(data) values ('" + results.toString() + "');\n"))

  }

}
