package algorithms


fun main() {

}

fun rightSideView(root: TreeNode?): List<Int> {
    val map = mutableMapOf<Int, Int>()
    dfs(root, 0, map)
    return map.values.toList()
}

fun dfs(root: TreeNode?, depth: Int, map: MutableMap<Int, Int>) {
    root ?: return
    map[depth] = root.`val`
    dfs(root.left, depth + 1, map)
    dfs(root.right, depth + 1, map)
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}