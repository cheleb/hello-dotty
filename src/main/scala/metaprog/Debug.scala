package metaprog

import scala.quoted._


object Debug {
    inline def debug(): Unit = println("Hello, world!")

    def debugSimpleImpl(expr: Expr[Any])(using Quotes): Expr[Unit]=
        '{println("Value of" + ${Expr(expr.show)} + " is " + ${expr})} 

    inline def debugSimple(inline expr: Any): Unit = ${debugSimpleImpl('expr)}

}