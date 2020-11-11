package hellodotty

class Animal(val food: Int){
    override def toString = s"food: $food"
    }
    class Dog(name: String, food: Int) extends Animal(food){
        override def toString = s"name: $name, food: $food"
    }

case class Lair[+A](a: A){
    def get: A = a
}

case class Feeder[-A <: Animal](name: String, quantity: Int){
    def feed(a: A): Feeder[A] = {
        println(s"$name feeder miam(${a.food})")
        Feeder(name, quantity-a.food)
    }
}

object CoContInv extends App {

  val medor = Dog("medor", 20)
  val animal: Animal = medor

  val dogHouse = Lair(medor)
  println(dogHouse.get)
  
  val animalHouse: Lair[Animal] = dogHouse
  println(animalHouse.get)



  val animalFeeder = Feeder[Animal]("animal", 100)
  animalFeeder.feed(medor)

  val dogFeeder: Feeder[Dog] = animalFeeder
  dogFeeder.feed(medor)




}