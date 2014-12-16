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

fsc = Fast Scala Compiler
compiler daemon
