package shiny.spice

object ListWork {

  case class User(name: String, age: Int)

  // a list of users
  val users = List(User("Matsuoka-san", 24), User("Makino-san", 16))

  // split collection in two by predicate
  val (minors, adults) = users partition (user => user.age < 18)

  // calc. squares of numbers divisible by 3 in range from 1 to 100
  val num = (1 to 100) filter (i => i % 3 == 0) map (i => i * i)

  // print result
  num foreach(i => println(i))

  // you can replace single appearance of parameter with _
  num foreach(println _)

  // inferred type: String
  val name = "John"

  // inferred type: Map[String, Map[String, List[Int]]]
  var marks = Map(name ->
    Map("Geography" -> List(5, 6, 5),
      "Biology" -> List(1, 2, 1)))

  // explicit parameter and return type needed
  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)

}



// String interpolation is much easier in Scala than in Java
object FancyStrings {

  def greet(name:String) {

    val message = "、こにちわ！"
    println(s"$name$message")

  }

  def easy() {
    return println(s"Scala is ${"very " * 3}easy.")
  }

}



object SuperTester {

  val capitals = Map("Japan" -> "Tokyo", "France" -> "Paris", "Honduras" -> "Tegucigalpa")

  def isItBigEnough(x: Int) = if (x > 2) "It's Big!" else "Too Small!"

  def showMeTheCapital(x: String) : String = {

    def show(y: Option[String]) = y match {
      case Some(s) => s
      case None => "?"
    }

    show(capitals.get(x))
  }

}



object SkillsAssessor {

  def assess(examinee: Person) {

    examinee match {

      case Person("Kujime-san", _) => println("Awesome skills!")

      case Person(_, 1) => println("Not so awesome")

      case Person(name, level) =>
        println(s"$name - skills have not been verified")

    }
  }

  case class Person(name: String, level: Int)
}



trait Peelable {

  def canPeel(): Boolean = {
    true
  }
}



trait Crunchable {

  def canCrunch(): Boolean = {
    this match {
      case _: Peelable => false
      case _ => true
    }
  }
}



abstract class Fruit(val daysOld: Int, val isRipe: Boolean = false) {
  val age: Int = daysOld
  val ripe: Boolean = isRipe
  val badMessage = "Ewwww!"
  lazy val message = "Tasty!"

  def taste(): String = {
    if (ripe) message else badMessage
  }
}



case class Orange(override val daysOld: Int, override val isRipe: Boolean)
    extends Fruit(daysOld, isRipe)
    with Peelable
    with Crunchable {

  override lazy val message = "Orange: おいしいですよ！"

}



case class Pear(override val daysOld: Int, override val isRipe: Boolean)
    extends Fruit(daysOld, isRipe)
    with Crunchable {

  override lazy val message = "Pear: おいしいですよ！"

}
