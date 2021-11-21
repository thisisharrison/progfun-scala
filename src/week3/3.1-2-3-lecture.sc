object week3_1 {
  val oneHalf = new Rational(1, 2)
  oneHalf.numer
  oneHalf.denom

  val oneForth = new Rational(1, 4)
  oneHalf + oneForth // 6/8 -> gcd applied 3/4

  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  x - y - z // -79/42
  //  precedence of an operator is determined by its first character
  //  without (), even the infix operator * is defined by Rational, it would still take higher priority than +
  (x + y) * z // 66/42 -> gcd applied 11/7
  x + y * z // 59/42
  x / z // 2/9

  x < y // true
  x max z // 3/2

  //  methods with parameter can be used like infix operators
  x / z // 2/9

  //  guard illegal Rational
  //  val strange = new Rational(1, 0) // java.lang.IllegalArgumentException: requirement failed: denominator must be nonzero
  //  strange.add(strange)

  //  assert: used to check the code of the function itself
  //  assert(1 > 2, "Uhh Ohh") // java.lang.AssertionError: assertion failed: Uhh Ohh

  new Rational(2) // 2/1 <- using secondary constructor

  class Rational(x: Int, y: Int) {
    //    secondary constructor
    def this(x: Int) = this(x, 1)

    //    guard illegal Rational
    //    require is predefined function: (condition, optional message string), IllegalArgumentException is thrown
    require(y != 0, "denominator must be nonzero")

    //    private members as it's strictly for implementation purpose, not for clients
    //    can only access them from inside the Rational class
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    private val g = gcd(x, y)

    //    if numer and denom are not called often, then we can x / gcd(x, y), amortize the additional cost of gcd here by:
    //    def numer = x / gcd(x, y)
    //    also possible to turn numer and denom to vals, so they are computed only once. useful if they are called often
    //    val numer = x / gcd(x, y)
    def numer = x / g

    def denom = y / g

    //    Rational package methods
    def +(r: Rational) =
      new Rational((r.denom * numer + r.numer * denom), (denom * r.denom))

    //    prefix operator - is different from infix -
    //    convention in scala is to call it unary_
    def unary_- : Rational =
      new Rational(-numer, denom)

    def -(r: Rational) =
    //      new Rational((r.denom * numer - r.numer * denom), (denom * r.denom)) // <- not DRY
      this + -r

    def *(r: Rational) =
      new Rational(r.numer * numer, r.denom * denom)

    def /(r: Rational) =
    //      new Rational(r.denom * numer, r.numer * denom) // <- not DRY
      this * new Rational(r.denom, r.numer)

    def ==(r: Rational) =
      r.denom * numer == denom * r.numer

    //    calling numer is abbreviation of this.numer
    def <(r: Rational) = numer * r.denom < r.numer * denom

    //    `this` represents the object on which the current method is executed
    def max(r: Rational) = if (this < r) r else this

    override def toString(): String =
      numer + "/" + denom
  }
}

