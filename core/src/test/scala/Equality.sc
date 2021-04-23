
import scala.language.strictEquality


case class BoxA[T,U](a: T, b: U)

given [T,U](given Eql[T,U]):  Eql[BoxA[T,U], BoxA[U,T]] = Eql.derived


BoxA(1, 1L) == BoxA(1L, 1)


case class BoxB[T,U](a: T, b: U)  derives Eql

BoxB(1, 1L) == BoxB(1, 1L)
