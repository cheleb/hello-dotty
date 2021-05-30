object Main {

  sealed trait Identifiable(id: String)

  case class Person(name: String) extends Identifiable(name)
  case class Password(value: String)

  def main(args: Array[String]): Unit = {
    println(s"Hello world! $msg")
    println(msg)
  }

  def msg = "I was compiled by dotty :)"

  def union(id: Person | Password) = id match {
    case Person(name) => name
    case Password(value) => value
  }

}
