object week2_3 {
  //  currying sum
  def sum(f: Int => Int): (Int, Int) => Int = {
    //    returns a locally defined function
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)

    sumF
  }

  def sumInt = sum((x: Int) => x)

  sumInt(1, 10) // 55
  sum((x: Int) => x)(1, 10) // 55 <- equivalent to sumInt

  def cube(x: Int) = x * x * x

  (sum(cube)) (1, 10) == sum(cube)(1, 10)

  //  function with multiple parameter list
  //  def(a1)...(an) = E is equivalent to
  //  def(a1)...(an-1) = { def g(an) = E; g } -> like sumF above it returns a function (g) that parameter is arg n (a, b)
  def sumShortHand(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sumShortHand(f)(a + 1, b)

  sumShortHand(cube)(1, 10) // 3025
}
