package week4.MyInt

abstract class MyInt {
  //  overloading
  //  1 + 2.0 should result in Double 3.0
  def +(that: Double): Double

  def +(that: Float): Float

  def +(that: Long): Long

  def +(that: Int): Int

  def <<(cnt: Int): Int

  def &(that: Long): Long

  def &(that: Int): Int

  def ==(that: Double): Boolean

  def ==(that: Float): Boolean

  def ==(that: Long): Boolean

}
