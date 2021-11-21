package week4.NaturalNumber

class Succ(n: NaturalNumber) extends NaturalNumber {
  def isZero: Boolean = false

  //  Trick is here!!
  //  Succ(n) is 1 + n, so predecessor just n
  def predecessor: NaturalNumber = n

  //  n is predecessor of this class so we can use n (Succ - 1) plus that
  //  4 + 2 = Successor of 3 + 2 = 3 + 3
  def +(that: NaturalNumber): NaturalNumber = new Succ(n + that)

  //  4 - 2 = 3 - 1 // <- take one from both sides
  def -(that: NaturalNumber): NaturalNumber = if (that.isZero) this else n - that.predecessor
}
