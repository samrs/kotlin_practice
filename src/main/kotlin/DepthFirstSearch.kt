
fun dfsRecursive(
    graph: Map<Int, List<Int>>,
    node: Int,
    visited: MutableSet<Int> = mutableSetOf()
) {
    if (node in visited) return
    visited.add(node)
    println("Visited $node")
    for (neighbor in graph[node] ?: emptyList()) {
        dfsRecursive(graph, neighbor, visited)
    }
}