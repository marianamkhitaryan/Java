import java.util.ArrayList;

public class DirectedEdgeListGraph <V extends Comparable<V>, E extends Comparable<E>> extends EdgeListGraph<V, E> implements Directed{

    public void reverse() {
        for (Edge<E> e : edges()) {
            Vertex<V>[] vertices = endVertices(e);
            removeEdge(e);
            insertEdge(vertices[1], vertices[0], e.getElement());
        }
    }

    public int outDegree(Vertex<V> v) {
        return outgoingEdges(v).size();
    }

    public int inDegree(Vertex<V> v) {
        return incomingEdges(v).size();
    }

    public ArrayList<Edge<E>> outgoingEdges(Vertex<V> v) {
        ArrayList<Edge<E>> outEdges = new ArrayList<V,E>();
        for (GraphEdge<E> e : edges()) {
            if (e.getFirst().equals(v)) {
                outEdges.add(e);
            }
        }
        return outEdges;
    }

    public ArrayList<Edge<E>> incomingEdges(Vertex<V> v) {
        ArrayList<Edge<E>> inEdges = new ArrayList<>();
        for (GraphEdge<E> e : edges()) {
            if (e.getSecond().equals(v)) {
                inEdges.add(e);
            }
        }
        return inEdges;
    }

    public Vertex<V>[] endVertices(Edge<E> e) {
        return super.endVertices(e);
    }
}
