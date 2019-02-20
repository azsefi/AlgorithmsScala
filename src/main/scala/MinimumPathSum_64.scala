object MinimumPathSum_64 {
    def minPathSum(grid: Array[Array[Int]]): Int = {
        val (height, width) = (grid.length, grid(0).length)
        for (
            i <- 0 until height;
            j <- 0 until width
        ) {
            if (i == 0 && j == 0)
                None
            else {
                val up = if (i > 0) grid(i-1)(j) else Int.MaxValue
                val left = if (j > 0) grid(i)(j-1) else Int.MaxValue
                grid(i)(j) += Math.min(up, left)
            }
        }

        grid(height-1)(width-1)
    }
}
