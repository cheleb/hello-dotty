package hellodotty

object LiteralTypes extends App {

  val three: 3 = 3

  def a3or4(tf: 3 | 4) = println(tf)

  a3or4(three)

}
