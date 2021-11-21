package week4.List

trait List[T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]
}
