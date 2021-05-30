package hellodotty

trait PrettyPrint[A] {
  def prettyString(a: A): String
}

object GivenApp extends App {

  val intPrettyPrint = new PrettyPrint[Int] {
    def prettyString(i: Int): String = "$i"
  }

  println(intPrettyPrint.prettyString(11))

}
