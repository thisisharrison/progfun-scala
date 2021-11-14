object week3_1 {
  val oneHalf = new Rational(1, 2)
  oneHalf.numer
  oneHalf.denom

  val oneForth = new Rational(1, 4)
  oneHalf.add(oneForth) // 6/8

  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  x.sub(y).sub(z) // -79/42
  x.add(y).mul(z) // 66/42
  x.div(z) // 2/9


  class Rational(x: Int, y: Int) {
    def numer = x
    def denom = y

//    Rational package methods
    def add(r: Rational) =
      new Rational((r.denom * numer + r.numer * denom), (denom * r.denom))

    def neg: Rational =
      new Rational(-numer, denom)

    def sub(r: Rational) =
//      new Rational((r.denom * numer - r.numer * denom), (denom * r.denom)) // <- not DRY
      add(r.neg)

    def mul(r: Rational) =
      new Rational(r.numer * numer, r.denom * denom)

    def div(r: Rational) =
//      new Rational(r.denom * numer, r.numer * denom) // <- not DRY
      mul(new Rational(r.denom, r.numer))

    def eq(r: Rational) =
      r.denom * numer == denom * r.numer

    override def toString(): String =
      numer + "/" + denom
  }
}

