package recfun
import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    (c, r) match {
      case (_, 0)   => 1
      case (0, _)   => 1
      case (`r`, _) => 1
      case (c, r)   => (pascal(c-1,r-1) + pascal(c, r-1))
    }
  }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      @tailrec
      def helper(chars: List[Char], level:Int):Int = {
        (chars, level) match {
          case (Nil, _)    => level
          case (_, -1)     => -1
          case ('('::t, _) => helper(t, level+1)
          case (')'::t, _) => helper(t, level-1)
          case (h::t, _)   => helper(t, level)
        }
      }
      helper(chars, 0) == 0
    }
  
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    (money, coins) match {
      case (_, Nil)       => 0
      case (m, _) if m <0 => 0
      case (0, _)         => 1
      case (m, h::t)      => countChange(m-h, coins)+countChange(m, t)
    }
  }

  def sum(f: Int => Int)(a: Int, b:Int):Int = {
    @tailrec
    def loop(a: Int, acc: Int): Int = {
      if ( a > b) acc
      else loop(a+1, acc+f(a))
    }
    loop(a, 0)
  }
}
