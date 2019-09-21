
//import scala.language.strictEquality

case class Box[T](a: T)// derives Eql

//given as Eql[Box, Box] = Eql.derived

//given [T, U] as Eql[Box[T], Box[U]] given Eql[T, U] = Eql.derived

Box(1) == Box(1L)