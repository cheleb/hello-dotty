trait Ord[T] {
    def compare(x: T, y: T): Int

    extension (x: T) {
    def < (y: T) = compare(x, y) < 0
    def > (y: T) = compare(x, y) > 0 
    }
}

given Ord[Int] {
    def compare(x: Int, y: Int) = (x - y)
}

case class Person(age: Int)

given ordrd[Int] as Ord[Person] {
    def compare(x: Person, y: Person) = ord.compare(x.age,y.age)
}




def isYounger[T](a: T, b: T)(using Ord[T]) = a < b

//isYounger(Person(48), Person(49))
//isYounger(48, 45)

given listOrd[T](using ord: Ord[T]) as Ord[List[T]]  {
    def compare(xs1: List[T], xs2: List[T]) = (xs1, xs2) match {
        case (Nil, Nil) => 0
        case (Nil, _) => -1
        case (_, Nil) => +1
        case (h1:: t1, h2 :: t2) =>
            val res = ord.compare(h1, h2)
            if(res != 0) res
            else compare(t1,t2)
    }
}

def max[T](x: T, y: T)(using ord: Ord[T]) = 
    if(ord.compare(x, y) < 0) y else x

def areYounger[T](xs1: List[T], xs2: List[T])(using Ord[T]) = xs1 < xs2 

//areYounger(List(1,3,4), List(1,2))

//max(List(1,3), List(2,3))