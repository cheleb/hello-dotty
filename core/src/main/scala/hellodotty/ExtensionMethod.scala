package hellodotty

case class ACircle(radius: Double)

object ExtensionMethod extends App {

  def k: String = "k"

  extension (c: ACircle) {
    def circumference: Double = c.radius * math.Pi * 2
    def volume = c.radius * c.radius * c.radius * 4 / 3 * math.Pi
  }

  println(ACircle(2).circumference)

  println(ACircle(2).volume)

}
