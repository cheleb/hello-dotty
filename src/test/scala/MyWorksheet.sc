
trait Greeting(val name: String){
   def msg = s"How are you $name"
}

class FormalGreeting extends Greeting("toto"){
 override def msg = s"How do you do M. $name"
}

trait FormalGreetingLate extends Greeting {
 override def msg = s"How do you do M. $name"
}

class TestGreeting extends FormalGreeting with Greeting
class TestGreetingLate extends FormalGreetingLate with Greeting("lolo")

new TestGreeting().msg
new TestGreetingLate().msg




