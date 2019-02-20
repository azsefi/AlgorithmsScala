object ValidateBST_98 {
    class TreeNode(var _value: Int) {
        var value: Int = _value
        var left: TreeNode = null
        var right: TreeNode = null
    }

    def isValidBST(root: TreeNode): Boolean = {
        if (root != null) {
            val stack = new scala.collection.mutable.Stack[Int]()

            def load(node: TreeNode): Unit = {
                if (node != null) {
                    load(node.left)
                    stack.push(node.value)
                    load(node.right)
                }
            }

            load(root)
            var prev = stack.pop()
            var isValid = true
            while (isValid && stack.nonEmpty) {
                val x = stack.pop()
                if (x < prev) {
                    prev = x
                }
                else
                    isValid = false
            }

            isValid
        }
        else
            true
    }
}
