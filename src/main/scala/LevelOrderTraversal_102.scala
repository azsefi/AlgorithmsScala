object LevelOrderTraversal_102 {
    def levelOrder(root: TreeNode): List[List[Int]] = {
        val result = new scala.collection.mutable.ListBuffer[List[Int]]()
        val queue = new scala.collection.mutable.Queue[TreeNode]()

        if (root != null) {
            queue.enqueue(root)
            while (queue.nonEmpty) {
                val n = queue.size
                val level =
                    (0 until n).map(_ => {
                        val node = queue.dequeue()
                        if (node.left != null) queue.enqueue(node.left)
                        if (node.right != null) queue.enqueue(node.right)
                        node.value
                    }).toList
                result.append(level)
            }
        }

        result.toList
    }
}
