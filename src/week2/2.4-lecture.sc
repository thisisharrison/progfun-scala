import math.abs
import scala.annotation.tailrec

object week2_4 {
  val tolerance = 0.0001

  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    @tailrec
    def iterate(guess: Double): Double = {
      println("current guess: " + guess)
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }

    iterate(firstGuess)
  }

  //  close to 2. fixedPoint is f(x) = x
  //  f(2) = 1 + 2/2 = 2
  fixedPoint(x => 1 + x / 2)(1) //1.999755859375

  //  sqrt(x) = y
  //  y * y = x can be manipulated to
  //  y = x / y
  //  fixedPoint(y => x / y), if x/y is same as y, would mean y * y = x
  def sqrt(x: Double) = fixedPoint(y => x / y)(1.0)
  //  sqrt(2) -> current guess oscillate between 1 and 2 and does not terminate

  //  apply average damping: prevent estimation from varying too much
  //  average successive values
  def betterSqrt(x: Double) = fixedPoint(y => (x / y + y) / 2)(1.0)

  betterSqrt(2) // 1.4142135623746899
  betterSqrt(16) // 4.000000000000051

  //  apply average damp to fixedPoint
  //  a function that takes a function and *returns a function*
  //  returned function can be used in fixedPoint(f)(guess)
  def averageDamp(f: Double => Double)(x: Double) = (f(x) + x) / 2

  def bestSqrt(x: Double) = fixedPoint(averageDamp(y => x / y))(1.0)

  bestSqrt(16) // 4.000000000000051

  //  another way of writing
  def anotherAvgDamp(f: Double => Double): Double => Double = {
    def avgDamp(x: Double) = (f(x) + x) / 2

    avgDamp
  }

  def anotherSqrt(x: Double) = fixedPoint(anotherAvgDamp(y => x / y))(1.0)

  anotherSqrt(16) // 4.000000000000051
}
