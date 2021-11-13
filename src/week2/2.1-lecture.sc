import scala.annotation.tailrec

object week2_1 {
//  Euclid's Greatest Common Divisor
//  a tail recursion function
  @tailrec
  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  gcd(14, 7) // 7
  gcd(100, 10) // 10
  gcd(23, 13) // 1

//  not a tail recursion function
//  @tailrec // -> uncommenting this will cause an error
  def factorial(n: Int): Int =
    if (n == 0) 1 else factorial(n - 1) * n

  factorial(5) // 1 * 2 * 3 * 4 * 5 = 120
  factorial(10) // 3628800


  def tailFactorial(n: Int): Int = {
    @tailrec
    def loop(acc: Int, cur: Int): Int =
      if (cur == 0) acc
      // tail recursion should call itself as its last action
      else loop(acc * cur, cur - 1)
    loop(1, n)
  }

  tailFactorial(5) // loop(1, 5) -> loop(5, 4), loop(20, 3)...
  tailFactorial(10)
}
