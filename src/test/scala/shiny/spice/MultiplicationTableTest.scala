package shiny.spice

import org.scalatest._

class MtmSpec extends FlatSpec {

  "A string" should "be returned when this method is called" in {
    val myString = mt.mtm()
    assert(myString != "")
  }

  "The string length" should "be longer than a length of 1" in {
    val myString = mt.mtm()
    assert(myString.length() > 1)
  }

}
