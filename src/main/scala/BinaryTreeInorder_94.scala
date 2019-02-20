object BinaryTreeInorder_94 {
    class TreeNode(var _value: Int) {
        var value: Int = _value
        var left: TreeNode = null
        var right: TreeNode = null
    }


    def inorderTraversal(root: TreeNode): List[Int] = {
        val result = new scala.collection.mutable.ArrayBuffer[Int]()
        traverse(root, result)
        result.toList
    }

    def traverse(root: TreeNode, result: scala.collection.mutable.ArrayBuffer[Int]): Unit = {
        if (root != null) {
            if (root.left != null) traverse(root.left, result)
            result.append(root.value)
            if (root.right != null) traverse(root.right, result)
        }
    }
}
