object week3_4 {
  abstract class Base {
//    abstract can have implementation
    def foo: Int = 1
    def bar: Int
  }

  class Sub extends Base {
//    can we need to override to reimplement
    override def foo: Int = 2
    def bar: Int = 3
  }
}
