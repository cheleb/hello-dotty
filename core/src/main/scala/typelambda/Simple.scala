package typelambda

trait Functor[M[_]]:
   extension [A] (m: M[A]) def map2[B](f: A => B): M[B]

given Functor[Seq] with
   extension [A] (seq: Seq[A]) def map2[B](f: A => B) = seq map f

given Functor[Option] with
   extension [A] (opt: Option[A]) def map2[B](f: A => B) = opt map f