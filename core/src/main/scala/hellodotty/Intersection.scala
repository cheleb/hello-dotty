package hellodotty

trait Resetable {
  def reset(): Unit
  def children: List[Resetable]
}

trait Growable[T] {
  def add(t: T): Unit
  def children: List[Growable[T]]
}

class Counter(name: String) extends Resetable with Growable[String] {

  var values = List.empty[Resetable & Growable[String]]

  def add(str: String) = values :+= Counter(str)

  def reset() = values = values.empty

  def str = name

  def children = List.empty

}

object Main extends App {

  def testInter(v: Resetable & Growable[String]): Unit = {
    v.reset()
    v.add("helo")
  }

  val myCounter = new Counter("olivier")

  testInter(myCounter)

}
