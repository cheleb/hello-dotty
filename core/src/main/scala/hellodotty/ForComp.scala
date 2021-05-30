package hellodotty

object ForComp extends App {

  def either1() = Right(1)
  def either2(): Either[String, Int] = Left("oooo") //Right(2)
  def either3() = Right(3)

  val res = for {
    one <- either1()
    two <- either2()
    three <- either3()
  } yield three + two + one

  println(res)

}
