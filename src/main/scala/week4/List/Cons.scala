package week4.List

// parameter and field definition
// abbreviation to (_head: Int, _tail IntList) ... { val head = _head; val tail = _tail }
// generalize type parameter [T]
class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
  //  we don't need to def head and tail
  //  val parameters have implemented the definition
  //  difference between val and def is initialization: val when object is first initialized, def is evaluated each time it is referenced

}
