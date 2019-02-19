object FizzBuzz_412 {
    def main(args: Array[String]): Unit = {
        val n = 15
        fizzBuzz(n).foreach(println)
    }

    def fizzBuzz(n: Int): List[String] = {
        (1 to n).map {
            case x if x % 3 == 0 && x % 5 == 0 => "FizzBuzz"
            case x if x % 3 == 0 => "Fizz"
            case x if x % 5 == 0 => "Buzz"
            case x => x.toString
        }.toList
    }
}
