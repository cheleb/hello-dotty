trait Resetable {
    def reset(): Unit
}

trait Growable[T] {
    def add(x: T): Unit
}


class AString(var value: String) extends Resetable with Growable[String]{
    def reset(): Unit = value = ""
    def add(str: String): Unit = value = s"$value, $str"
    override def toString = value
}

def f(x: Resetable & Growable[String] ) = {
    x.reset()
    x.add("first")
}

trait A {
    def children: List[A]
}

trait B {
    def children: List[B]
}

class C extends A with B {
   def children: List[A & B] = List.empty

}

val x: A & B = new C

val m = x.children



