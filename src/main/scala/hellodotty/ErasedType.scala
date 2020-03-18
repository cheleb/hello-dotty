package hellodotty


import scala.annotation.implicitNotFound

sealed trait State

final class On extends State

final class Off extends State

@implicitNotFound("State must be off")
class IsOff[A <: State]
object IsOff {
    erased implicit def isOff: IsOff[Off] = new IsOff[Off]
}


@implicitNotFound("State must be off")
class IsOn[A <: State]
object IsOn {
    erased implicit def isOn: IsOn[On] = new IsOn[On]
}


class Machine[S <: State]{
    def turnOn(using erased ev: IsOff[S]): Machine[On] = {
        println("Wroum wroum")
        new Machine[On]
    }
    def turnOff(using erased  ev: IsOn[S]): Machine[Off] = {
        println("Plop")
        new Machine[Off]
    }
 }