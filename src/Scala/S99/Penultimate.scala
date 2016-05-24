package S99

/**
  * Created by Jilliankim on 5/23/16.
  */
//find the one away from the last element
//List.get(list.size - 1)
object Penultimate extends App {


	def findElement[A](list: List[A], k: Int):A = {
		list.takeRight(k).head
	}

	def findElementRecursive[A](list: List[A]):A = list match {
		case h :: List(list) => h
		case _ :: tail => findElementRecursive(tail)
		case Nil => throw new NoSuchElementException

	}

}
