import scala.quoted._
import scala.compiletime.{constValue}

object Config {
  inline val logging = false
}

object Logger {

  private var indent = 0

  inline def log[T](msg: String, indentMargin: => Int)(op: => T): T =
    if (Config.logging) {
      println(s"${"  " * indent}start $msg")
      indent += indentMargin
      val result = op
      indent -= indentMargin
      println(s"${"  " * indent}$msg = $result")
      result
    } else op
}

var indentSetting = 2

def factorial(n: BigInt): BigInt =
  Logger.log(s"factorial($n)", indentSetting) {
    if (n == 0) 1
    else n * factorial(n - 1)
  }

factorial(3)

inline def sumTwice(a: Int, b: => Int, inline c: Int) = a + a + b + b + c + c

sumTwice(1, 1, 1)

class A
class B extends A {
  def meth1() = "hello"
}

class C extends A {
  def meth2() = "hello"
}

transparent inline def choose(i: Int): A =
  if (i == 1) new A
  else if (i == 2) new B
  else new C

val res1 = choose(3)

transparent inline def matched(i: Int): A = inline i match {
  case 1 => new A
  case 2 => new B
  case 3 => new C
}

val res2 = matched(2)

transparent inline def zero(): Int = 0

val one: 1 = zero() + 1

def increase(n: Int): Unit = println(s"++ $n ++")
def decrease(n: Int): Unit = println(s"-- $n --")

inline def update(n: Int): Unit =
  inline if (n > 0) increase(n)
  else decrease(n)

inline val i = 1

update(i)

trait Nat

case object Zero extends Nat
case class Succ[N <: Nat](n: N) extends Nat

transparent inline def toInt(n: Nat): Int = inline n match {
  case Zero => 0
  case Succ(prec) => toInt(prec) + 1
}

val two = Succ(Succ(Zero))

val int2: 2 = toInt(two)

//constValueOpt[1] == 1

val o = 1
