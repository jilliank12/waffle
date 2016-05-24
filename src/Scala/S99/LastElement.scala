package S99

/**
  * Created by Jilliankim on 5/23/16.
  */
object LastElement extends App {

	val list = (1, 2, Nil)

	def findLast[A](list: List[A]):A = list match {
		case h :: Nil => h
		case _ :: tail => findLast(tail)
		case _ => throw new NoSuchElementException
	}

	def findLastNonRecursive[A](list: List[A]):A = {
		list.last
	}

}
