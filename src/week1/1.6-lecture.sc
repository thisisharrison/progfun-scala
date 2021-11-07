// 1.5 Newton's Method (Refactor)
// Using Blocks, x is visible in all the functions
object session {
  def sqrt(x: Double) = {
    def abs(x: Double) = if (x >= 0) x else -x

    def square(x: Double) = x * x

    def isGoodEnough(guess: Double): Boolean =
      abs(square(guess) - x) / x < 0.001

    def improve(guess: Double) = (guess + x / guess) / 2

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    sqrtIter(1)
  }
  sqrt(4)
  sqrt(1e-6)
  sqrt(1e60)
}
