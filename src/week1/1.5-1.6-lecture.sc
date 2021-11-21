// 1.5 Newton's Method
// if sqrt x
//  estimation y
//  repeatedly improve y by finding mean of y and x/y
object session {
  def sqrt(x: Double) = {
    def abs(x: Double) = if (x >= 0) x else -x

    def square(x: Double) = x * x

    def isGoodEnough(guess: Double, x: Double): Boolean = {
      val tolerance = 0.001
      //      abs(square(guess) - x) < tolerance - not great for small number and big number
      abs(square(guess) - x) / x < tolerance
    }

    def improve(guess: Double, x: Double) = (guess + x / guess) / 2

    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)

    sqrtIter(1, x)
  }

  sqrt(4)
  sqrt(1e-6)
  sqrt(1e60)
}
