package rockthejvm

object Traits {

  trait Talker(subject: String) {
    def talkTo(another: Talker): String
  }

  class Person(name: String) extends Talker("Rock music") {
    override def talkTo(another: Talker): String = "???"
  }

}
