package rockthejvm

object MonoidInCategoryOfEndofunctors {

  trait MostAbstractMonoid[T, ~>[_, _], U, P] {
    def unit: U ~> T
    def combine: P ~> T
  }

  trait GeneralMonoid[T, U, P] extends MostAbstractMonoid[T, Function1, U, P] {
    // def unit: U => T
    // def combine: P => T
  }

  trait FunctionMonoid[T] extends GeneralMonoid[T, Unit, (T, T)] {
    // def unit: Unit => T
    // def combine: ((T,T)) => T
  }

  trait Monoid[T] extends FunctionMonoid[T] {
    def empty: T
    def combine(a: T, b: T): T

    override def unit: Unit => T = _ => empty

    override def combine: ((T, T)) => T = t => combine(t._1, t._2)
  }

}
