package algorithms

object InsertionSort {
    def sort(arr: Array[Int]): Unit = {
        for (
            i <- 1 until arr.length
        ) {
            var j = i
            while (j > 0 && arr(j) < arr(j-1)) {
                flip(arr, j, j-1)
                j -= 1
            }
        }
    }

    def flip(arr: Array[Int], i: Int, j: Int): Unit = {
        val x = arr(i)
        arr(i) = arr(j)
        arr(j) = x
    }
}
