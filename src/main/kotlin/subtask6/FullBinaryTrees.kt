package subtask6

class FullBinaryTrees {

    fun stringForNodeCount(count: Int): String {

        val arrayOfNodes = getNodes(count)
        val result = StringBuilder()

        arrayOfNodes?.map { el ->
            val node = "[0,$el]"
            val nodeWithoutNull = node.replace("(null,)+]".toRegex(), "]")
            result.append(nodeWithoutNull).deleteCharAt(result.length - 2)
        }
        println("[${result}]")
        return "[${result}]"
    }

    class Node(var root: Int = 0) {

        var left: Node? = null
        var right: Node? = null

        override fun toString(): String {
            return if (left == null && right == null)
                "${left},${right},"
            else
                "${left?.root},${right?.root},$left$right"
        }
    }

    fun getNodes(n: Int): List<Node>? {

        val list = mutableListOf<Node>()
        var i = 1

        if (n % 2 == 0) return list
        if (n == 1) {
            list.add(Node())
            return list
        }

        while (i < n) {
            for (left in getNodes(i)!!)
                for (right in getNodes(n - i - 1)!!) {
                    val root = Node()
                    root.left = left
                    root.right = right
                    list.add(root)
                }
            i += 2
        }
        return list
    }
}
