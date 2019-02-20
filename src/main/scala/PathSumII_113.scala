object PathSumII_113 {
    def pathSum(root: TreeNode, sum: Int): List[List[Int]] = {
        case class MyNode(orig: TreeNode, parent: MyNode, runningSum: Int)
        val result = new scala.collection.mutable.ListBuffer[List[Int]]()

        def load(node: MyNode): Unit = {
            val currValue = node.orig.value + node.runningSum
            if (currValue == sum)
                if (isLeaf(node.orig))
                    result.append(buildPath(node))

            if (node.orig.left != null) load(MyNode(node.orig.left, node, currValue))
            if (node.orig.right != null) load(MyNode(node.orig.right, node, currValue))
        }

        def buildPath(node: MyNode): List[Int] = {
            var path: List[Int] = Nil
            var currNode = node
            while (currNode != null) {
                path = currNode.orig.value :: path
                currNode = currNode.parent
            }
            path
        }

        def isLeaf(node: TreeNode): Boolean = {
            node.left == null && node.right == null
        }

        if (root != null)
            load(MyNode(root, null, 0))

        result.toList
    }
}
