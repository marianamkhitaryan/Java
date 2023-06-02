// used ChatGPT
import java.util.ArrayList;

public class EdgeListGraph <V extends Comparable<V>, E extends Comparable<E>> extends AbstractGraph<V, E> {

    public int outDegree(Vertex<V> v) {
        int numLeavingEdges = 0;
        for (GraphEdge<E> e : edges()) {
            if (e.getFirst().equals(v)) {
                numLeavingEdges++;
            }
        }
        return numLeavingEdges;
    }

    public int inDegree(Vertex<V> v) {
        int count = 0;
        for (GraphEdge<E> e : edges()) {
            if (e.getSecond().equals(v)) {
                count++;
            }
        }
        return count;
    }

    public ArrayList<Edge<E>> outgoingEdges(Vertex<V> v) {
        ArrayList<Edge<E>> outEdges = new ArrayList<>();
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

    public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) {
        for (GraphEdge<E> e : edges()) {
            if (e.getFirst().equals(u) && e.getSecond().equals(v)) {
                return e;
            }
        }
        return null;
    }

    public Vertex<V>[] endVertices(Edge<E> e) {
        Vertex<V>[] vertices = (Vertex<V>[]) new Vertex[2];
        vertices[0] = e.getFirst();
        vertices[1] = e.getSecond();
        return vertices;
    }

    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        if (e.getFirst().equals(v)) {
            return e.getSecond();
        } else {
            return e.getFirst();
        }
    }

    public Vertex<V> insertVertex(V element) {
        GraphVertex<V> v = new GraphVertex<>(element);
        vertices().add(v);
        return v;
    }

    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element) {
        for (GraphEdge<E> e : edges()) {
            if ((e.getFirst().equals(u) && e.getSecond().equals(v)) || (e.getFirst().equals(v) && e.getSecond().equals(u))) {
                throw new IllegalArgumentException("Edge already exists");
            }
        }
        GraphEdge<E> e = new GraphEdge<>(element, (GraphVertex<V>)u, (GraphVertex<V>)v);
        edges().add(e);
        return e;
    }

    public void removeVertex(Vertex<V> v) {
        ArrayList<GraphEdge<E>> toRemove = new ArrayList<>();
        for (GraphEdge<E> e : edges()) {
            if (e.getFirst().equals(v) || e.getSecond().equals(v)) {
                toRemove.add(e);
            }
        }
        edges().removeAll(toRemove);
        vertices().remove(v);
    }

    public void removeEdge(Edge<E> e) {
        edges().remove(e);
    }

}
