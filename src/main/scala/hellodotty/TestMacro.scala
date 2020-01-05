package hellodotty

import scala.quoted._

//import given scala.quoted._

object PowerMacro {


inline def assert(expr: => Boolean): Unit =
  ${ assertImpl('expr) }


def assertImpl(expr: Expr[Boolean])(given QuoteContext) = '{
  if (!$expr)
    throw new AssertionError(s"failed assertion: ${${ showExpr(expr) }}")
}

def showExpr(expr: Expr[Boolean])(given QuoteContext): Expr[String] =
  '{ "<some source code>" } // Better implementation later in this document

  }
