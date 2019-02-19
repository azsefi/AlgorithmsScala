package algorithms

object SelectionSort {

    def main(args: Array[String]): Unit = {
        val arr: Array[Int] = Array(425, 812, 73, 57, 630, 992, 153, 597, 839, 364)
        sort(arr)
    }

    def sort(arr: Array[Int]): Unit = {
        sort(arr, 0)
    }

    private def sort(arr: Array[Int], start: Int): Unit = {
        if (start < arr.length-1) {
            val i = getMinIndex(arr, start)
            flip(arr, start, i)
            sort(arr, start + 1)
        }
    }

    def getMinIndex(arr: Array[Int], start: Int): Int = {
        arr.
          zipWithIndex.
          takeRight(arr.length - start).
          minBy(x => x._1).
          _2
    }

    def flip(arr: Array[Int], i: Int, j: Int): Unit = {
        val x = arr(i)
        arr(i) = arr(j)
        arr(j) = x
    }
}
