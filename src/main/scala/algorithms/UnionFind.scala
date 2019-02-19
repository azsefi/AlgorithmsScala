package algorithms

class UnionFind(val numberOfElements: Int) {
    val items: Array[Int] = (0 until numberOfElements).toArray

    def join(x: Int, y: Int): Unit = {
        val (dX, rootX) = getRoot(x)
        val (dY, rootY) = getRoot(y)

        if (dX > dY) items(y) = rootX
        else items(x) = rootY
    }

    def getRoot(x: Int): (Int, Int) = {
        var i = x
        var depth = 0
        while(i != items(i)) {
            items(i) = items(items(i))
            i = items(i)
            depth += 1
        }
        (depth, i)
    }

    def isConnected(x: Int, y: Int): Boolean = {
        getRoot(x) == getRoot(y)
    }
}
