Notes from reading [Programming in Scala, by Martin Odersky](http://www.artima.com/pins1ed/)
----

Classes and Objects
====

Classes cannot have static members. Scala defines singleton objects, denoted by the keyword object instead of class.

A singleton object with the same name as a class is called a companion object, and the class is called a companion class. A companion object and class can access one anothers private members. The class and object must both be in the same source file.

Singleton objects cannot take parameters, whereas classes can. You cannot instantiate a singleton object with the new keyword.

Singleton objects without a companion class are referred to as standalone objects. Among other things, standalone objects are useful for defining application entry points.

Auxiliary constructors:
```
def this(n: Int) = this(n, 1)
```

Basic Types and Operations
=====

+, -, * etc are functions in Scala.

val - an immutable variable
var - a mutable variable

While a collection may be immutable, it doesn't mean the object in the collection are.

*return type Unit*
Unit is a subtype of scala.AnyVal. There is only one value of type Unit, (), and it is not represented by any object in the underlying runtime. A method with return type Unit is analogous to a Java method which is declared void.

*return type Nothing*
Nothing is a subtype of every other type including scala.Null; there are no instances of this type. The scala library defines a value Nil of type List[Nothing]. This makes Nil an instance of List[T], for any element of type T.
Nothing is the return type for methods which never return normally.

Object Equality
=====

To compare two objects for equality,  == or !=
Scala does not use reference equality for these operators.

eq in Scala compares referential equality.

Tail Recursion
=====

Scala detects tail recursion (functions which call themselves recursively as their last action) and replaces it with a jump back to the beginning of the function. so there is no runtime overhead to be paid. One thing to watch out for is that this optimization will look different in a stack trace than you might expect! Because the recursive call is replaced with the optimization, a stacktrace will only display a single instruction set.

Control Abstraction
=====

*higher-order functions* - functions that take functions as parameters

*loan pattern* - a control abstraction, like a function, that lends something to another function. Like a function that creates a printwriter wrapped in a try/finally, that automatically closes the file once the argument function has completed.

Composition and Inheritance
=====

What are the simple objects?
In what ways can more interesting objects be constructed out of simpler ones?
How do combinators hang together?
What are the most general combinations?
Do they satisfy any interesting laws?


Other
=====

fsc = Fast Scala Compiler
compiler daemon
