class Graph {
    private val graph = HashMap<Int, ArrayList<Int>>()

    fun addEdge(v: Int, w: Int) {
        if(graph.contains(v)) {
            graph[v]?.add(w)
        } else {
            graph[v] = arrayListOf(w)
        }
    }

    fun bfs(startingVertex: Int): HashMap<Int, Int> {
        val visited = HashSet<Int>()
        val queue = ArrayList<Int>()
        val prev = HashMap<Int, Int>()

        visited.add(startingVertex)
        queue.add(startingVertex)

        while (queue.isNotEmpty()) {
            val currentVertex = queue.removeFirst()
            print("$currentVertex ")

            val neighbors = graph[currentVertex] ?: arrayListOf()
            for (neighbor in neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor)
                    queue.add(neighbor)
                    prev[neighbor] = currentVertex
                }
            }
        }
        return prev
    }
}

fun reconstructPath(start: Int, final: Int, prev: HashMap<Int, Int>): List<Int> {
    val path = arrayListOf(final)
    var at = prev[final]

    while (at != null) {
        path.add(at)
        at = prev[at]
    }

    return if (path.contains(start))
        path.reversed()
    else
        listOf()
}

fun main() {
    val graph = Graph()

    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 3)
    graph.addEdge(1, 8)
    graph.addEdge(2, 4)
    graph.addEdge(3, 5)

    println("Breadth-First Traversal (starting from vertex 0):")
    println(
        reconstructPath(
            0,
            5,
            graph.bfs(0)
        )
    )
}
