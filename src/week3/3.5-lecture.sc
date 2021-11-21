//import week3.Rational
// import everything from package

import week3._
// import week3.{Rational. Hello} // <- named imports

object week3_5 {
  new week3.Rational(3, 5)

  //  imported and we don't need package.ClassName
  new Rational(1, 2)

  //  Null type
  val x: String = null
  val y: String = x
  //  val z: Int = null // <- an expression of type Null is ineligible for implicit conversion

  //  AnyVal
  if (true) 1 else false // AnyVal 1 because Int and Boolean belongs to AnyVal and type checker picked the type that matched both
}
