import java.util.ArrayList;

public abstract class AbstractGraph<V extends Comparable<V>, E extends Comparable<E>> implements Graph<V, E> {
    private ArrayList<Vertex<V>> vertices;
    private ArrayList<Edge<E>> edges;

    public int numVertices() {
        return vertices.size();
    }

    public int numEdges() {
        return edges.size();
    }

    public ArrayList<Vertex<V>> vertices() {
        return vertices;
    }

    public ArrayList<Edge<E>> edges() {
        return edges;
    }

    protected class GraphVertex<V extends Comparable<V>> implements Vertex<V> {
        private V element;

        public GraphVertex(V element) {
            this.element = element;
        }

        public V getElement() {
            return element;
        }

        public String toString() {
            return element.toString();
        }

        public int compareTo(Vertex<V> other) {
            return element.compareTo(other.getElement());
        }
    }

    protected class GraphEdge<E extends Comparable<E>> implements Edge<E> {
        private E element;
        private Vertex<V> first;
        private Vertex<V> second;

        public GraphEdge(E element, Vertex<V> first, Vertex<V> second) {
            this.element = element;
            this.first = first;
            this.second = second;
        }

        public E getElement() {
            return element;
        }

        public void swapEnds() {
            Vertex<V> temp = first;
            first = second;
            second = temp;
        }

        public Vertex<V> getFirst() {
            return first;
        }

        public Vertex<V> getSecond() {
            return second;
        }

        public String toString() {
            return element.toString();
        }

        public int compareTo(Edge<E> other) {
            return element.compareTo(other.getElement());
        }
    }
}
