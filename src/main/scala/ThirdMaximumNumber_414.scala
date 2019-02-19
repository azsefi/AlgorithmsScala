object ThirdMaximumNumber_414 {
    def main(args: Array[String]): Unit = {
        val input = Array(2, 2, 3, 1)
        println(thirdMax(input))
    }

    def thirdMax(nums: Array[Int]): Int = {
        val pq = new scala.collection.mutable.PriorityQueue[Int]().reverse
        nums.toSet[Int].foreach(x => {
            if (pq.size >= 3) {
                if (pq.head < x) {
                    pq.dequeue()
                    pq.enqueue(x)
                }
            }
            else
                pq.enqueue(x)
        })
        if (pq.size == 3)
            pq.head
        else
            pq.last
    }
}
