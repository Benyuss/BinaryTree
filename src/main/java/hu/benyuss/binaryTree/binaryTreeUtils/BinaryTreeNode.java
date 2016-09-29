package hu.benyuss.binaryTree.binaryTreeUtils;

public class BinaryTreeNode<T> {
    // every node SHOULD have a value(1 or 0), and 2 childs.
    // that class is only a data structure + getters, setters

    private final T value; // only 0 / 1
    private BinaryTreeNode<T> leftChild; // reference for it's left child.
    private BinaryTreeNode<T> rightChild; // reference for it's right child.
    private int depth; //every node should know it's depth.

    public BinaryTreeNode(T value) {
        this.value = value;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public T getValue() { // is 0 or 1?
        return value;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}