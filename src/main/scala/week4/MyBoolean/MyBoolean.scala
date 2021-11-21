package week4.MyBoolean

abstract class MyBoolean {
  // call by name (:=>)
  //  By-name parameters have the advantage that they are not evaluated if they aren’t used in the function body
  //  then and else part
  //  expression of type Boolean
  //  from `if (cond) t else e` to `cond.ifThenElse(t, e)`
  def ifThenElse[T](t: => T, e: => T): T

  //  if left is true, return x, if false immediately return false
  def &&(x: => MyBoolean): MyBoolean = ifThenElse(x, MyFalse)

  def ||(x: => MyBoolean): MyBoolean = ifThenElse(MyTrue, x)

  def unary_! : MyBoolean = ifThenElse(MyFalse, MyTrue)

  def ==(x: MyBoolean): MyBoolean = ifThenElse(x, !x)

  def !=(x: MyBoolean): MyBoolean = ifThenElse(!x, x)

  //  assume false < true
  //  MyTrue < x, true is always greater than false, so return MyFalse (t)
  //  MyFalse < x, in this case, we enter else (e), eval x
  def <(x: MyBoolean): MyBoolean = ifThenElse(MyFalse, x)
}
