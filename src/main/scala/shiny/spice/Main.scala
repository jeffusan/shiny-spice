package shiny.spice

object otherthings extends App {

  val filesHere = (new java.io.File(".")).listFiles

  for (file <- filesHere)
    println(file)

  for (i <- 1 to 4)
    println("Iteration: " + filesHere(i))

  for (i <- 1 until 4)
    println("Shorter Iteration: " + filesHere(i))

  for (file <- filesHere if file.getName.endsWith(".sbt"))
    println("Only sbt: " + file)

  def sbtFiles =
    for {
      file <- filesHere
      if file.getName.endsWith(".sbt")
    } yield file

  for (file <- sbtFiles)
    println("Only sbt 2: " + file)

}
