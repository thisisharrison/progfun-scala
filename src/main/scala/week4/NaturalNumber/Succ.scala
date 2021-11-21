package week4.NaturalNumber

class Succ(n: NaturalNumber) extends NaturalNumber {
  def isZero: Boolean = false

  //  Trick is here!!
  //  Succ(n) is 1 + n, so predecessor just n
  def predecessor: NaturalNumber = n

  //  n is predecessor of this class
  //  4 + 2 => Successor of -> `Successor of 3 (which is n)` + 2 => Succ(3 + 2) => 5 + 1
  def +(that: NaturalNumber): NaturalNumber = new Succ(n + that)

  //  4 - 2 = 3 (n) - 1 (predecessor of that) // <- take one from both sides
  def -(that: NaturalNumber): NaturalNumber = if (that.isZero) this else n - that.predecessor
}
