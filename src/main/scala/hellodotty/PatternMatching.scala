package hellodotty

object Even {
  def unapply(str: String): Boolean = str.size % 2 == 0 
}

class FirstChar(s: String) extends Product {
  def _1 = s.charAt(0)
  def _2 = s.charAt(1)

  // Not used by pattern matching: Product is only used as a marker trait.
  def canEqual(that: Any): Boolean = ???
  def productArity: Int = ???
  def productElement(n: Int): Any = ???
}

object FirstChar {
  def unapply(s: String): FirstChar = new FirstChar(s)
}

object TestPatternApp extends App {

  "even" match {
    case s @ Even() => println(s"$s has even number of character") 
    case s  => println(s"$s has odd number of character") 
  }

  "Hi!" match {
    case FirstChar(c1, c2) => 
    println(s"Char1: $c1, char2: $c2")
  }

} 