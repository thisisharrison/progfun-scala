object week4_3 {
  val square = (x: Int) => x * x
//  is expanded to...
  class AnonFun extends Function1[Int, Int] {
    def apply(x: Int) = x * x
  }
  new AnonFun
//  or shorter
  new Function1[Int, Int] {
    override def apply(x: Int): Int = x * x
  }
//  Function1 comes from:
  //  type A => B
  //  is an abbreviation to...

  //  scala.Function1[A, B] // There's a 22 Function parameters limit
  //  defined as follow...

  //  package scala
  //  trait Function1[A, B] {
  //    def apply(x: A): B
  //  }

//  Function call
  square.apply(10) //res2: Int = 100
//  same as
  val square2 = new Function1[Int, Int] {
    override def apply(x: Int): Int = x * x
  }
  square2.apply(10) //res3: Int = 100
  //  apply is not an object, which would create an infinite expansion
  //  def f(y: Y): z = ... is not a function value
  //  but if f is used in a place where Function type is expected, it is converted to:
  //  (y: Y) = f(y)
  //  the above square2's apply is converted to (x: Int) => x * x
}