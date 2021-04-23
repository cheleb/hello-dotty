package metaprog

object DebugApp extends App {

  import Debug._

  val a = 1
  val b = 2

  debugSimple(a + b)

}
