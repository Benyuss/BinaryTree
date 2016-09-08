package hu.benyuss.binaryTree.binaryTreeUtils;

public class BinaryTreeNode<T> {
	// every node SHOULD have a value(1 or 0), and 2 childs.
	// that class is only a data structure + getters, setters

	private final T value; // only 0 / 1
	private BinaryTreeNode<T> leftChild; // reference for it's left child.
	private BinaryTreeNode<T> rightChild; // reference for it's right child.

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

	@Override
	public String toString() { // Because satanism exists.
		return "[" + value + ", l=" + leftChild + ", r=" + rightChild + "]";
	}

	@Override
	public boolean equals(Object obj) { // support for equality test
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		BinaryTreeNode other = (BinaryTreeNode) obj;
		if (leftChild == null) {
			if (other.leftChild != null)
				return false;
		} else if (!leftChild.equals(other.leftChild))
			return false;
		if (rightChild == null) {
			if (other.rightChild != null)
				return false;
		} else if (!rightChild.equals(other.rightChild))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}