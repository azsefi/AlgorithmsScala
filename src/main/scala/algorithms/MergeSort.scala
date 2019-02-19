package algorithms

object MergeSort {
    def sort(arr: Array[Int]): Unit = {
        sort(arr, 0, arr.length-1)
    }

    private def sort(arr: Array[Int], start: Int,  end: Int): Unit = {
        if (end > start) {
            val mid = start + (end-start)/2
            sort(arr, start, mid)
            sort(arr, mid+1, end)
            merge(arr, start, mid, end)
        }
    }

    def merge(arr: Array[Int], start: Int, mid: Int, end: Int): Unit = {
        if (arr(mid+1) < arr(mid)) {
            val a1 = arr.slice(start, mid+1).toIterator
            val a2 = arr.slice(mid+1, end+1).toIterator
            val pq = scala.collection.mutable.PriorityQueue[(Iterator[Int], Int)]()(Ordering.by{case(_, v) => v}).reverse
            if (a1.hasNext) pq.enqueue((a1, a1.next))
            if (a2.hasNext) pq.enqueue((a2, a2.next))

            var i = start
            while (pq.nonEmpty) {
                val (iter, v) = pq.dequeue()
                arr(i) = v; i += 1
                if (iter.hasNext) pq.enqueue((iter, iter.next))
            }
        }
    }
}
