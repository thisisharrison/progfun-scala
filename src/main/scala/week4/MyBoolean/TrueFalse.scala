package week4.MyBoolean

object MyTrue extends MyBoolean {
  //  call by name: do not evaluate else expression
  def ifThenElse[T](t: => T, e: => T): T = t

  override def toString: String = "true"
}

object MyFalse extends MyBoolean {
  //  call by name: do not evaluate then expression
  def ifThenElse[T](t: => T, e: => T): T = e

  override def toString: String = "false"
}
