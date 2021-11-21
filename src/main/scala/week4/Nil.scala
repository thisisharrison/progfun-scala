package week4

import java.util.NoSuchElementException

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true

  def head: Nothing = throw new NoSuchElementException("Nil.head") // <- Nothing is a subtype of any other type (including T) so this is ok

  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}
