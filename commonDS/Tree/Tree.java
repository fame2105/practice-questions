package commonDS.Tree;

/**
 * Created by fame.issrani on 1/24/19.
 */
public interface Tree<T> {
    public void traversal();
    public void insert(T data);
    public void delete(T data);
    public T getMax();
    public T getMin();
}
