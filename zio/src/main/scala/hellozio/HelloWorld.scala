package hellozio

import zio._
import zio.console._

class R1                                                   
class R2// extends R1
class E1                     
class E2// extends E1

object HelloWorld extends App {

//    val helloZio = ZIO.effect(println("Hello ZIO")) 
    
    def zio1: ZIO[R1, E1, Int] = ???
    def zio2: ZIO[R2, E2, Int] = ???


    def program = for{
        _ <- zio1
        _ <- zio2   
    }  yield ()

    def run(argv: List[String]) = putStrLn("Hello")
    .exitCode
}