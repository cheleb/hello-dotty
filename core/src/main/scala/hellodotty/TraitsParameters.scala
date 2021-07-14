package hellodotty

trait Philosophical(message: String):
  def philosophize = message

class Animal

class ProfondAnimal extends Animal, Philosophical("Am I")
trait PhilosophicalAnimal extends Animal with Philosophical

class Frog extends PhilosophicalAnimal, Philosophical("Croak")

trait Debugable(f: String) {
  def format: String = f
}

trait RunnableBug extends Debugable {

  def debug() = println(format.format("zozo"))

}

object TraitsParameters extends App {

  class MyClass extends RunnableBug with Debugable("(%s)")

  val m = new MyClass

  m.debug()

  println(new Frog().philosophize)

}
