

import scala.compiletime.erasedValue

case class Box(size: Int)

inline def defaultValue[T] = inline erasedValue[T] match {
    case _: Byte => Some(0: Byte)
    case _: Int => Some(0)
    case _: String => Some("")
    case _: Box => Some(Box(12))
    case _ => None
}


val b: Option[Byte] = defaultValue[Byte]
val defaultBox = defaultValue[Box]

