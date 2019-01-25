package commonDS.Tree;

/**
 * Created by fame.issrani on 1/24/19.
 */
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;


    @Override
    public void traversal() {
        if (root != null) {
            inorderTraversal(root);
        }
    }

    private void inorderTraversal(Node<T> node) {
        if (node.getLeftChild() != null) {
            inorderTraversal(node.getLeftChild());
        }

        System.out.print(" " + node.getData());

        if (node.getRightChild() != null) {
            inorderTraversal(node.getRightChild());
        }
    }

    private void postOrderTraversal(Node<T> node) {
        if (node.getLeftChild() != null) {
            postOrderTraversal(node.getLeftChild());
        }

        if (node.getRightChild() != null) {
            postOrderTraversal(node.getRightChild());
        }

        System.out.print(" " + node.getData());
    }

    private void preOrderTraversal(Node<T> node) {

        System.out.print(" " + node.getData());
        
        if (node.getLeftChild() != null) {
            preOrderTraversal(node.getLeftChild());
        }

        if (node.getRightChild() != null) {
            preOrderTraversal(node.getRightChild());
        }
    }

    @Override
    public void insert(T data) {
        if (this.root == null) {
            root = new Node<>(data);
            return;
        }
        insertHelper(data, this.root);
    }

    @Override
    public void delete(T data) {

    }

    @Override
    public T getMax() {
        if (root == null) {
            return null;
        }
        return getMaxHelper(root);
    }

    @Override
    public T getMin() {
        if (root == null) {
            return null;
        }
        return getMinHelper(root);
    }

    private T getMinHelper(Node<T> node) {
        if (node.getLeftChild() != null) {
            return getMinHelper(node.getLeftChild());
        }
        return node.getData();
    }


    private T getMaxHelper(Node<T> node) {
        if (node.getRightChild() != null) {
            return getMaxHelper(node.getRightChild());
        }
        return node.getData();
    }

    private void insertHelper(T data, Node<T> node) {
        if (data.compareTo(node.getData()) < 0) {
            if (node.getLeftChild() == null) {
                node.setLeftChild(new Node<>(data));
            } else {
                insertHelper(data, node.getLeftChild());
            }
        } else {
            if (node.getRightChild() == null) {
                node.setRightChild(new Node<>(data));
            } else {
                insertHelper(data, node.getRightChild());
            }
        }
    }
}
