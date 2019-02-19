object AddStrings_415 {
    def main(args: Array[String]): Unit = {
        val input = ("25", "35")
        println(addStrings(input._1, input._2))
    }

    def addStrings(num1: String, num2: String): String = {
        val result = new scala.collection.mutable.Stack[Int]()
        val (l1, l2) = (num1.length - 1, num2.length - 1)
        val l = Math.max(l1, l2)
        var n = 0

        (0 to l).foreach(i => {
            val k1 = if (l1 >= i) num1(l1 - i).toString.toInt else 0
            val k2 = if (l2 >= i) num2(l2 - i).toString.toInt else 0
            val k = k1 + k2 + n

            result.push(k%10)
            n = k/10
        })
        if (n > 0) result.push(n)

        result.mkString("")
    }
}
