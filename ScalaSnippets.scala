import java.util.NoSuchElementException

object ScalaSnippets extends App {
  val simpleParse = Map(1 -> "one", 2 -> "two", 3 -> "three")


  def findOptionExample(): Unit = {
    val numbers: List[Int] = 1 :: 3 :: 5 :: 7 :: Nil
    val result: Option[Int] = numbers.find(_ > 4)
    result match {
      case Some(numberFound) => print(s"$numberFound is greater than 4")
      case None => print("There aren't any numbers > 4")
    }
    // Prints "5 is greater than 4"
  }

  def getMapExample(): Unit = {
    val first: Option[String] = simpleParse.get(1) // Some("one")
    val fourth: Option[String] = simpleParse.get(4) // None

    try {
      val result1 = first.get // result1 == "one"
      val result4 = fourth.get // throws NoSuchElementException
    } catch {
      case e: NoSuchElementException => print("No such element exception")
    }
  }

  def defaultExample(): Unit = {
    val result: String = simpleParse.get(-2).getOrElse("unknown")
  }
  
  def ifOrElseWork(): Unit = {
    val result = simpleParse.get(-2).getOrElse {
      // do some task, like logging parse failure
      "unknown"
    }
  }
}