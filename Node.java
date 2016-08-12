package binarytree;

public class Node<T> {//Char
	private final T value;
	private Node<T> leftChild;
	private Node<T> rightChild;

	public Node(T value) {
		this.value = value;
	}

	public Node<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}

	public Node<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node<T> rightChild) {
		this.rightChild = rightChild;
	}

	public T getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "[" + value + ", l=" + leftChild + ", r=" + rightChild + "]";
	}

}
