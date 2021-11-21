package week4.MyBoolean

abstract class MyBoolean {
  // call by name (:=>)
  //  By-name parameters have the advantage that they are not evaluated if they aren’t used in the function body
  //  then and else part
  //  expression of type Boolean
  //  from `if (cond) t else e` to `cond.ifThenElse(t, e)`
  def ifThenElse[T](t: => T, e: => T): T

  //  if left is true, return x, if false immediately return false
  //  true && true/false -> return x
  //  false && ??? -> doesn't matter, must return false
  def &&(x: => MyBoolean): MyBoolean = ifThenElse(x, MyFalse)

  //  if left is true, then return true (true || false -> true)
  //  else evaluate x (false || true / false)
  def ||(x: => MyBoolean): MyBoolean = ifThenElse(MyTrue, x)

  //  true then return t, false then return f
  def unary_! : MyBoolean = ifThenElse(MyFalse, MyTrue)

  //  if left is true, result of equal test is the result of the argument
  //  if left is false, result of equal test is the negation of the argument
  //  this == x
  //  true == true -> true, true == false -> false
  //               -> x                   -> x
  //  false == false -> !false, false == true -> !true
  //               -> !x                   -> !x
  def ==(x: MyBoolean): MyBoolean = ifThenElse(x, !x)

  //  this != x
  //  true != true -> !true, true != false -> !false
  //               -> !x                   -> !x
  //  false != true -> true, false != false -> false
  //               -> x                   -> x
  def !=(x: MyBoolean): MyBoolean = ifThenElse(!x, x)

  //  assume false < true
  // true < ??? then must always be false because true must be >
  //  false < x then evaluate x. true is correct. false < false return false, which is also correct
  def <(x: MyBoolean): MyBoolean = ifThenElse(MyFalse, x)
}
