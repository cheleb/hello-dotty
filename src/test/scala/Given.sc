

trait Ord[T] {
    def compare(x: T, y: T): Int

    def (x: T) < (y: T) = compare(x, y) < 0
    def (x: T) > (y: T) = compare(x, y) > 0 
}

given IntOrd : Ord[Int] {
    def compare(x: Int, y: Int) = (x - y)
}

case class Person(age: Int)

given PersonOrd : Ord[Person] (given ord: Ord[Int]) {
    def compare(x: Person, y: Person) = ord.compare(x.age,y.age)
}




def simpleApplication[T](a: T, b: T) given(ord: Ord[T]) = a < b

simpleApplication(Person(48), Person(45))
simpleApplication(48, 45)