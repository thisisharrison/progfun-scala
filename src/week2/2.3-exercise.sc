object week2_exercise {
//  1. product
  def product(f: Int => Int)(a: Int, b: Int): Int = {
      if (a > b) 1
      else f(a) * product(f)(a + 1, b)
  }
//  1 * 2 * 3 * 4 * 5
  product(x => x)(1, 5) // 120
  product(x => x * x)(3, 4) // 144

//  2. factorial in terms of product
  def factorial (n: Int) = product(x => x)(1, n)
  factorial(5) // 120

//  3. generalize sum and product (equivalent to map reduce!)
  def accumulator(op: (Int, Int) => Int, init: Int, f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) init
    else op(f(a), accumulator(op, init, f)(a + 1, b))
  }
  def sum(a: Int, b: Int) = a + b
  def multiply(a: Int, b: Int) = a * b

  def sumInt(a: Int, b: Int) = accumulator(sum, 0, x => x)(a, b)
  def productInt(a: Int, b: Int) = accumulator(multiply, 1, x => x)(a, b)

  sumInt(1, 10) // 55
  productInt(1, 5) // 120
}
