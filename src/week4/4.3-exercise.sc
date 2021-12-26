import week4.List._

object List {
  // We want to pass parameters to List in package week4. So it's just missing an apply method
  //  List(1, 2) = List.apply(1, 2)
  def apply[T](x1: T): List[T] = new Cons(x1, new Nil)
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))
  def apply[T](): List[T] = new Nil
}

object test {
  val one = List.apply(1)
  one.head // 1
  val two = List.apply(1, 2)
  two.tail.head // 2
  val empty = List.apply()
}