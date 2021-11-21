import week4.MyBoolean._
import week4.NaturalNumber._

object week4_2 {
  MyTrue || MyFalse // true
  MyTrue || MyTrue // true

  MyTrue && MyFalse // false
  MyFalse && MyTrue // false
  MyTrue && MyTrue // true
  MyFalse && MyFalse // false

  MyTrue && !MyFalse // true


  //  All the ways to reason about MyTrue && MyFalse:
  //  1. a MyBoolean object using the method && with argument of an expression which eval to MyBoolean object
  MyTrue.&&(if (true) MyTrue else MyFalse) // true
  // 2. Using the ifThenElse method in the MyTrue object, then `ifThenElse` takes x which is evals to MyBoolean (eg. MyFalse)
  MyTrue.ifThenElse(MyFalse, MyTrue) // false

  val one = new Succ(Zero)
  val two = new Succ(one)
  two - one
  two + two
  one - one - one // NaturalNumber: has no negative number
}
