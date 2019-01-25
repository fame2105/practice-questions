package commonDS.Tree;

/**
 * Created by fame.issrani on 1/24/19.
 */
public class App {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(21);
        bst.insert(2312);
        bst.insert(212);
        bst.insert(131);
        bst.insert(209);
        bst.insert(94);
        bst.insert(0);

        System.out.println(bst.getMax());
        System.out.println(bst.getMin());
        bst.traversal();

    }
}
