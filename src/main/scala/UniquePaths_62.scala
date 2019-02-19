object UniquePaths_62 {
    def main(args: Array[String]): Unit = {
        val input = (51, 9)
        println(uniquePaths(input._1, input._2))
    }

    def uniquePaths(m: Int, n: Int): Int = {
        val arr = Array.fill(m)(Array.fill(n)(0))
        for (
            i <- 0 until m;
            j <- 0 until n
        ){
            if (i == 0 && j == 0)
                arr(i)(j) = 1
            else if (m == 0 && n == 1 || m == 1 && n == 0)
                arr(i)(j) = 1
            else {
                val up = if (i > 0) arr(i-1)(j) else 0
                val left = if (j > 0) arr(i)(j-1) else 0
                arr(i)(j) = up + left
            }
        }

        arr(m-1)(n-1)
    }
}
