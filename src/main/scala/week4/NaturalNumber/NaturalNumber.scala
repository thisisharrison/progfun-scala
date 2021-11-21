package week4.NaturalNumber

// Peano Numbers
abstract class NaturalNumber {
  def isZero: Boolean

  def predecessor: NaturalNumber

  def successor: NaturalNumber = new Succ(this)

  def +(that: NaturalNumber): NaturalNumber
  //  = if (that.isZero) this else (this.successor + that.predecessor)

  def -(that: NaturalNumber): NaturalNumber
  //  = if (that.isZero) this else (this.predecessor - that.predecessor)
}
