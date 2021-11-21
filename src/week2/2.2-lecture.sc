import scala.annotation.tailrec

object week2_2 {
  //  sum of integers between a and b
  def sumInt(a: Int, b: Int): Int = if (a > b) 0 else a + sumInt(a + 1, b)

  sumInt(1, 10) // 55

  //  sum of cubes between a and b
  def cube(x: Int): Int = x * x * x

  def sumCube(a: Int, b: Int): Int = if (a > b) 0 else cube(a) + sumCube(a + 1, b)

  sumCube(1, 10) // 3025

  //  sum of factorials between a and b
  def fact(x: Int): Int = if (x <= 2) 1 else fact(x - 1) + x

  def sumFact(a: Int, b: Int): Int = if (a > b) 0 else fact(a) + sumFact(a + 1, b)

  sumFact(1, 5) // 27

  //  higher order function to take care of the three
  def sum(f: Int => Int, a: Int, b: Int): Int = if (a > b) 0 else f(a) + sum(f, a + 1, b)

  //  sumInt
  def term(x: Int): Int = x

  sum(term, 1, 10) // 55
  sum(cube, 1, 10) // 3025
  sum(fact, 1, 5) // 27

  //  use anonymous functions
  sum((x: Int) => x, 1, 10) // 55
  sum((x: Int) => x * x * x, 1, 10) // 3025

  //  use tail recursion
  def tailSum(f: Int => Int, a: Int, b: Int) = {
    @tailrec
    def loop(acc: Int, cur: Int): Int = {
      //      increment cur until greater than b, return acc
      if (cur > b) acc
      //      tail call loop with acc + f(cur) and increment cur
      else loop(acc + f(cur), cur + 1)
    }
    //    starts at 0 for sums
    loop(0, a)
  }

  tailSum((x: Int) => x, 1, 10) // 55
  tailSum((x: Int) => x * x * x, 1, 10) // 3025
  tailSum(fact, 1, 5) // 27
}
