// Force Call By Name for y
def constOne (x: Int, y: => Int) = 1

// If else
def abs(x: Double) = if (x >= 0) x else -x
abs(-10)
abs(10)

// Short circuit evaluation
def e = 2 + 2 == 4
false && e // e is not evaluated
true && e // e is not evaluated

// 1.4 Exercise
def loop: Boolean = loop
// Pass by name instead of value, otherwise arguments will always be evaluated
def and(x: => Boolean, y: => Boolean) = if (x) y else false
and(true, false) // false
and(false, true) // false
and(true, true) // true
and(false, loop) // false -> if we didn't pass by name, this will create infinite loop

def or(x: => Boolean, y: => Boolean) = if (x) x else y
or(true, false) // true
or(false, true) // true
or(true, true) // true
or(false, false) // false
or(true, loop) // true



