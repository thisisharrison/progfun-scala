object week3_4 {

    abstract class IntSet {
        def incl(x: Int): IntSet
        def contains(x: Int): Boolean
        def union(other: IntSet): IntSet
    }

    object Empty extends IntSet {
        def contains(x: Int): Boolean = false
        def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
        def union(other: IntSet): IntSet = other

        override def toString = "."
    }

    class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
        def contains(x: Int): Boolean = {
            if (x < elem) left.contains(x)
            else if (x > elem) right contains x
            else true
        }

        def incl(x: Int): IntSet = {
            if (x < elem) new NonEmpty(elem, left incl x, right)
            else if (x > elem) new NonEmpty(elem, left, right incl x)
            else this
        }

// set without the elem, then union with other set, then include the elem back
        def union(other: IntSet): IntSet =
            ((left union right) union other) incl elem

        override def toString = "{" + left + elem + right + "}"
    }

    val root = new NonEmpty(3, Empty, Empty) // root: NonEmpty = {.3.}
    val newRoot = root incl 4 // newRoot: IntSet = {.3{.4.}}

    val x = new NonEmpty(3, Empty, Empty)
    val y = new NonEmpty(5, Empty, Empty)
    x union y //res0: IntSet = {{.3.}5.}
    y union x //res1: IntSet = {.3{.5.}}
}
