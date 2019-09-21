import scala.quoted._

object Config {
  inline val logging = true
}

object Logger {

  private var indent = 0

  inline def log[T](msg: String, indentMargin: =>Int)(op: => T): T =
    if (Config.logging) {
      println(s"${"  " * indent}start $msg")
      indent += indentMargin
      val result = op
      indent -= indentMargin
      println(s"${"  " * indent}$msg = $result")
      result
    }
    else op
}

var indentSetting = 2

def factorial(n: BigInt): BigInt = {
  Logger.log(s"factorial($n)", indentSetting) {
    if (n == 0) 1
    else n * factorial(n - 1)
  }
}

factorial(3)