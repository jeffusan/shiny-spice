package shiny.spice

import scalaj.http.Http
import play.api.libs.json._
import com.github.nscala_time.time.Imports._

class WeatherRetriever() {

  val url = "http://api.openweathermap.org/data/2.5/history/city"

  val cities = List(
    ("1848354","Asia/Tokyo")) //,
//    ("4887158","America/Chicago"),
//    ("4887398","America/Chicago"),
//    ("5028509","America/Chicago"),
//    ("4128894","America/Chicago"))

  def retrieveWeather(cities: List[(String,String)]) {
    val city = cities.head

    for(i <- 167 to 1 by -1) {

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

      println("Json: => {}", json.toString)

      if(cities.tail.size > 0) {
        retrieveWeather(cities.tail)
      }
    }
  }

  def unixTime(zone:String, minus:Int) : String = {
    return ((DateTime.now(DateTimeZone.forID(zone)).minusHours(minus).getMillis() / 1000).toInt).toString
  }
}
