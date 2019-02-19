package algorithms


object QuickSort {

    def main(args: Array[String]): Unit = {
        val arr: Array[Int] = Array(425, 812, 73, 57, 630, 992, 153, 597, 839, 364)
        sort(arr)
    }

    def sort(arr: Array[Int]): Unit = {
        sort(arr, 0, arr.length-1)
    }

    private def sort(arr: Array[Int], start: Int, end: Int): Unit = {
        if (end > start) {
            val p = partition(arr, start, end)
            sort(arr, start, p-1)
            sort(arr, p+1, end)
        }
    }

    private def partition(arr: Array[Int], start: Int, end: Int): Int = {
        var i = start
        var j = end
        var done = false
        while (!done) {
            do {
                i += 1
            } while (i < end && arr(i) < arr(start))

            do {
                j -= 1
            } while (j > start && arr(j) > arr(start))

            if (i < j) {
                flip(arr, i, j)
            }
            else {
                done = true
            }
        }
        flip(arr, start, j)
        j
    }

    def flip(arr: Array[Int], i: Int, j: Int): Unit = {
        val x = arr(i)
        arr(i) = arr(j)
        arr(j) = x
    }
}
