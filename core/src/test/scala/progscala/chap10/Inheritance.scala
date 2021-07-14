package progscala.chap10

abstract class Element:
  def contents: Vector[String]
  def height: Int = contents.length

class VectorElement(conts: Vector[String]) extends Element:
  def contents = conts
