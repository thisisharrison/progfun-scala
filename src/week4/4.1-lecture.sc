import week4._

object week4_1 {
  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])

  singleton[Int](1)
  singleton[Boolean](true)

  //  scala can infer the type
  singleton(1)
  singleton(true)


  def nth[T](n: Int, list: List[T]): T = {
    if (list.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) list.head
    else nth(n - 1, list.tail)
  }

  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
  nth(2, list) // 3
  nth(5, list) // java.lang.IndexOutOfBoundsException
  nth(-1, list) // java.lang.IndexOutOfBoundsException
}
