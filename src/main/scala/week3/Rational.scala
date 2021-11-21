package week3

import scala.annotation.tailrec

class Rational(x: Int, y: Int) {
  def this(x: Int) = this(x, 1)

  require(y != 0, "denominator must be nonzero")
  
  @tailrec
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  private val g = gcd(x, y)

  def numer: Int = x / g

  def denom: Int = y / g

  def +(r: Rational) =
    new Rational((r.denom * numer + r.numer * denom), (denom * r.denom))

  def unary_- : Rational =
    new Rational(-numer, denom)

  def -(r: Rational) =
    this + -r

  def *(r: Rational) =
    new Rational(r.numer * numer, r.denom * denom)

  def /(r: Rational) =
    this * new Rational(r.denom, r.numer)

  def ==(r: Rational): Boolean =
    r.denom * numer == denom * r.numer

  def <(r: Rational): Boolean = numer * r.denom < r.numer * denom

  def max(r: Rational): Rational = if (this < r) r else this

  override def toString: String =
    numer + "/" + denom
}

