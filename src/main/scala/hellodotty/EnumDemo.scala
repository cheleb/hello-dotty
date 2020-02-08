package hellodotty

enum Color {
    case Red,Blue, Green
}

sealed trait MyInt
case object ONE extends MyInt
case object TWO extends MyInt

object Test {
  def test(mi: MyInt): Unit = mi match {
    case ONE =>()
    case TWO => ()
  }
}