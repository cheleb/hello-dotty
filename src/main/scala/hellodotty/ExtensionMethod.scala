package hellodotty



case class ACircle(radius: Double)


object ExtensionMethod extends App {

def (c: ACircle) circumference: Double = c.radius * math.Pi * 2

   println( ACircle(2).circumference )


}