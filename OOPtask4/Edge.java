public interface Edge <E extends Comparable> extends Comparable<Edge<E>>{
    E getElement();
    void swapEnds();
}
