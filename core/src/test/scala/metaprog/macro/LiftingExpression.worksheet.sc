
import scala.quoted.{given, _}

enum Exp {
    case Num(n: Int)
    case Plus(e1: Exp, e2: Exp)
    case Var(name: String)
    case Let(x: String, e: Exp, in: Exp)
}

import Exp._

def compile(e: Exp, env: Map[String, Expr[Int]])(using Quotes): Expr[Int] = e match {
    case Num(n) => Expr(n)
    case Plus(e1, e2) =>
    '{ ${ compile(e1, env) } + ${ compile(e2, env) } }
    case Var(x) =>
      env(x)
    case Let(x, e, body) =>
      '{ val y = ${ compile(e, env) }; ${ compile(body, env + (x -> 'y)) } }
}

val exp = Plus(Plus(Num(2), Var("x")), Num(4))
val letExp = Let("x", Num(3), exp)



