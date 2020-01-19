type Elem[X] = X match {
    case String => Char
    case Array[t] => t
    case Iterable[t] => t
}

type a = Elem[String]


type LeafElem[X] = X match {
  case String => Char
  case Array[t] => LeafElem[t]
  case Iterable[t] => LeafElem[t]
  case AnyVal => X
}

type b = LeafElem[Array[String]]

type Concat[+Xs <: Tuple, +Ys <: Tuple] <: Tuple = Xs match {
  case Unit => Ys
  case x *: xs => x *: Concat[xs, Ys]
}

type c = Concat[String, Char]