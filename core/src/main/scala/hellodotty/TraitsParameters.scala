package hellodotty

trait Debugable(f: String) {
  def format = f
}

trait RunnableBug extends Debugable {

  def debug() = println(format.format("zozo"))

}

object TraitsParameters extends App {

  class MyClass extends RunnableBug with Debugable("(%s)")

  val m = new MyClass

  m.debug()

}
