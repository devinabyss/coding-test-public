package algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
class GraphTest {

    private int[] startIdxs = {0, 3};

    private Graph getNewGraph() {
        Graph graph = new Graph(9);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);
        return graph;
    }

    @Test
    public void testDfs() {
        for (int no : startIdxs) {
            Graph graph = getNewGraph();
            List<Graph.Node> uses = graph.dfs(no);
            log.info("## StartIdx : {}, DFS : {}", no, uses);
        }

    }

    @Test
    public void testDfsRecursive() {
        for (int no : startIdxs) {
            Graph graph = getNewGraph();
            List<Graph.Node> uses = graph.dfsRecursive(no);
            log.info("## StartIdx : {}, DFS-R : {}", no, uses);
        }
    }

    @Test
    public void testBfs() {
        for (int no : startIdxs) {
            Graph graph = getNewGraph();
            List<Graph.Node> uses = graph.bfs(no);
            log.info("## StartIdx : {}, BFS : {}", no, uses);
        }
    }


}