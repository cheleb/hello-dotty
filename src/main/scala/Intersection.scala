package hellodotty



trait Resetable {

  def reset(): Unit
}


trait Printable {
  def str: String
}

class Counter(name: String) extends Resetable with Printable {

  var count = 0

  def reset() = count = 0

  def str = name

}

object Main extends App {
   
    

   def testInter(v: Resetable & Printable): Unit = {
       v.reset()
       println(v.str)
   }

   val myCounter = new Counter("olivier")

   testInter(myCounter)

}