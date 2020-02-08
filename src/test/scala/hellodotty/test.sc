import scala.math.pow

//@annotation.tailrec
def decompose(n: Int): List[Int] =
    if(n == 0) Nil
    else n % 10 :: decompose((n-n%10)/10)


def decomposeTail(n: Int): List[Int] = {
    @annotation.tailrec
    def loop(n: Int, acc: List[Int]) : List[Int] = 
      if(n == 0) acc
      else loop((n-n%10)/10,  acc :+ n % 10 )
    loop(n, Nil)
}


def isZarbDiv(n: Int) : Boolean = 
    decomposeTail(n).map(i=>pow(i, 3)).sum == n
    

(1 to 1000) filter isZarbDiv


decomposeTail(371)



