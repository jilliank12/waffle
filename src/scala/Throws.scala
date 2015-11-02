package scala

/**
 * Created by Jilliankim on 11/3/15.
 */
import util.Random
object Throws extends App {

  def run(args: Array[String]) = displayResults(simulateThrows())

  private def simulateThrows(): Array[Int] = {
    val r = new Random
    val count = new Array[Int](11)
    def throwDice = count(r.nextInt(6) + r.nextInt(6)) += 1
    1 to 200 foreach(n=> throwDice)
    count
  }

  private def displayResults(counts: Array[Int]) = {
    0 until counts.length foreach(i => println(i + 2 + ": " + "X" * counts(i)))
  }


}
