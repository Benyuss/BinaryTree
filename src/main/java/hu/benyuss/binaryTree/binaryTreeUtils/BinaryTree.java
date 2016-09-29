package hu.benyuss.binaryTree.binaryTreeUtils;

public interface BinaryTree<T, M> {

    void add(T value, M travWay);

    String[] depth(M travWay);

    double averageDepth(M travWay);

    double variance(M travWay);

}