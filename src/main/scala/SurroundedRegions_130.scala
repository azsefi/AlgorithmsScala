object SurroundedRegions_130 {
    def main(args: Array[String]) = {
        val board =
            Array(
                Array("X","X","X","X"),
                Array("X","O","O","X"),
                Array("X","X","O","X"),
                Array("X","O","X","X")
            )
        solve(board.map(x => x.map(_.toCharArray.head)))
    }

    def solve(board: Array[Array[Char]]): Unit = {
        val (height, width) = (board.length, board(0).length)
        val Os: Array[Int] =
            board.zipWithIndex.flatMap{
                case(w, i) => w.zipWithIndex.filter{case(x,_) => x == 'O'}.map{
                    case(_, j) => i * width + j
                }
            }

        Os.foreach(println)
    }
}
