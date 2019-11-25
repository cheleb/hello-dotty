package hellodotty

import scala.concurrent.ExecutionContext

type Executable[T] = (given ExecutionContext) => T 

given ec: ExecutionContext = ExecutionContext.fromExecutor(null)

def f(x: Int): Executable[Int] = x+1

object ImplicitFunctionTypeApp extends App {
 val f1 = f(22)(given ec)
 println(f1)
}
