package S99

/**
  * Created by Jilliankim on 5/23/16.
  */
object FindNthElement extends App {

	def nth[A](k: Int, list: List[A]):A = (k, list) match {
		case (_, Nil) => throw new NoSuchElementException
		case (0, h :: _) => h
		case (k, _ :: tail) => nth(k-1, tail)
	}

	def reverseList[A](list: List[A]):List[A] = list match {
		case Nil => throw new NoSuchElementException
		case h => h
		case _ :: tail => reverseList(tail)
	}
}
