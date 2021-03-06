object week3_4 {

  //    methods are not defined
  //    new IntSet will not instantiate class
  //    can be extended
  abstract class IntSet {
    def incl(x: Int): IntSet

    def contains(x: Int): Boolean
  }

  //    implement a binary tree
  //    incl has two subtrees
  //    there's really only single empty IntSet and it's overkill to new Empty creating many instances of it
  //    refactor: using object definition - defines a singleton object named Empty
  //    no other instances can be (or need to be) created with new. It's created the first time we reference it
  //    evaluation: Singleton object are values so Empty evaluates to itself
  object Empty extends IntSet {
    def contains(x: Int): Boolean = false

    def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)

    override def toString = "."
  }

  // Both Empty and NonEmpty extends IntSet implies the types Empty and NonEmpty conform to the type IntSet
  // Object of type Empty or NonEmpty can be used wherever an object of type IntSet is required
  class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
    def contains(x: Int): Boolean = {
      //            both style of method calling are okay
      if (x < elem) left.contains(x)
      else if (x > elem) right contains x
      else true
    }

    def incl(x: Int): IntSet = {
      //            persistent data structure: create new tree when adding a new x. old tree is maintained.
      if (x < elem) new NonEmpty(elem, left incl x, right)
      else if (x > elem) new NonEmpty(elem, left, right incl x)
      else this
    }

    override def toString = "{" + left + elem + right + "}"
  }

  //    see how these are two trees
  val root = new NonEmpty(3, Empty, Empty) // root: NonEmpty = {.3.}
  val newRoot = root incl 4 // newRoot: IntSet = {.3{.4.}}

}
