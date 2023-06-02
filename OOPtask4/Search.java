import java.util.ArrayList;

public interface Search<V extends Comparable<V>, E extends Comparable<E>> {
    void traverse(Graph<V, E> graph, Vertex<V> origin, ArrayList<Vertex<V>> visited, boolean toPrint) throws NotTraversableException;
}
