package week4.NaturalNumber

object Zero extends NaturalNumber {
  def isZero: Boolean = true

  def predecessor: NaturalNumber = throw new Error("Zero: has no predecessor")

  def +(that: NaturalNumber): NaturalNumber = that

  def -(that: NaturalNumber): NaturalNumber = if (that.isZero) this else throw new Error("NaturalNumber: has no negative number")
}
