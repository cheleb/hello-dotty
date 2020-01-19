trait Resetable {
    def reset(): Resetable
    def split(): List[Resetable]
}

trait Growable[T] {
    def add(x: T): Growable[T]
    def split(): List[Growable[T]]
}


class AString(value: String) extends Resetable with Growable[String]{
    def reset() = AString("")
    def add(str: String) = AString(s"$value$str")
    def split() = value.split("").toList.map(AString(_))
}

val a = AString("iii")
a.split()


