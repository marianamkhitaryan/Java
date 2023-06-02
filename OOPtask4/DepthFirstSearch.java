// used ChatGPT

import java.util.ArrayList;

public class DepthFirstSearch<V extends Comparable<V>, E extends Comparable<E>> implements Search<V, E>{
    private boolean isConnected = true;

    public void traverse(Graph<V, E> graph, Vertex<V> origin, ArrayList<Vertex<V>> visited, boolean toPrint) throws NotTraversableException {
        if (graph.numVertices() == 0) {
            throw new NotTraversableException("Graph is not traversable");
        }
        visited.add(origin);
        if (toPrint) {
            System.out.println(origin);
        }
        for (Edge<E> edge : graph.outgoingEdges(origin)) {
            Vertex<V> neighbor = graph.opposite(origin, edge);
            if (!visited.contains(neighbor)) {
                traverse(graph, neighbor, visited, toPrint);
            }
        }
    }

    public boolean isConnected(Graph<V, E> graph) {
        try {
            ArrayList<Vertex<V>> visited = new ArrayList<>();
//            traverse(graph, graph.vertices().get(0), visited, false);

            if (visited.size() != graph.numVertices()) {
                isConnected = false;
            }

            if (graph instanceof Directed) {

                DirectedAdjacencyListGraph<V, E> reversedGraph = reverseGraph(graph);

                visited.clear();
                traverse(reversedGraph, reversedGraph.vertices().get(0), visited, false);

                if (visited.size() != graph.numVertices()) {
                    isConnected = false;
                }
            }
        } catch (NotTraversableException e) {

            isConnected = false;
        }
        return isConnected;
    }

    private DirectedAdjacencyListGraph<V, E> reverseGraph(Graph<V, E> graph) {
        DirectedAdjacencyListGraph<V, E> reversedGraph = new DirectedAdjacencyListGraph<>();

        for (Vertex<V> vertex : graph.vertices()) {
            reversedGraph.insertVertex(vertex.getElement());
        }

        return reversedGraph;
    }

}
