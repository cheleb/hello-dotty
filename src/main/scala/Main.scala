object Main {

  case class Person(name: String)
  case class Password(value: String)

  def main(args: Array[String]): Unit = {
    println("Hello world!")
    println(msg)
  }

  def msg = "I was compiled by dotty :)"

  def union(id: Person | Password) = id match {
    case Person(name) => name
    case Password(value) => value
  }

}
