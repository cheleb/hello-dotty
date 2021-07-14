package hellozio

import zio._
import zio.console._

class R1
class R2 // extends R1
class E1
class E2 // extends E1

object HelloWorld extends App {

//    val helloZio = ZIO.effect(println("Hello ZIO"))

//  def zio1: ZIO[Any, E1, Int] = ZIO.fromOption(Option.empty[Int]).orDieWith(_ => new Exception)
  def zio1: ZIO[Any, E1, Int] = ZIO.fromOption(Option.empty[Int]).mapError(_ => new E1)
  def zio2: ZIO[Any, E2, Int] = ZIO.succeed(1)
  def zio3 = ZIO.apply(println("oo"))

  def program = for {
    _ <- zio1
    _ <- zio2
  } yield ()

  def run(argv: List[String]) = program.exitCode
}
