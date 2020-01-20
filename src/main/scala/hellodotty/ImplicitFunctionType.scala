package hellodotty

import scala.concurrent.ExecutionContext

import java.util.concurrent._

type Executable[T] = (given ExecutionContext) => T 



def f(x: Int): Executable[Int] = x+1

object ImplicitFunctionTypeApp extends App {
  val es: ExecutorService | Null = Executors.newCachedThreadPool

  if(es != null ) {
    given ec: ExecutionContext = ExecutionContext.fromExecutorService(es)
    val f1 = f(22)(given ec)
    println(f1)
  }      
}

