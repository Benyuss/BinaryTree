package hu.benyuss.binaryTree.traversing;

import hu.benyuss.binaryTree.binaryTreeUtils.BinaryTreeNode;

public interface Traversal<T, M> {
	void traverseTree(BinaryTreeNode<T> current, M trav);
	// every tree have to be traversable.

	// T stands for current Node and its values,
	// M is the way of traversing (pre/in/post)
}