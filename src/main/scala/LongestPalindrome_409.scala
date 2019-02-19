object LongestPalindrome_409 {
    def main(args: Array[String]): Unit = {
        val s = "ccc"
        println(longestPalindrome(s))
    }

    def longestPalindrome(s: String): Int = {
        val hist = new scala.collection.mutable.HashMap[Char, Int]
        s.foreach(c => {
            val item = hist.getOrElseUpdate(c, 0)
            hist(c) = item + 1
        })

        var nEven = 0
        var nOdd = 0
        for ((_, n) <- hist.iterator) {
            nEven += (n/2)*2
            nOdd += n%2
        }

        nEven + math.min(nOdd, 1)
    }
}
