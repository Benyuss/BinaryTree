public class Node<T> {// Char
	//every node SHOULD have a value(1 or 0), and 2 childs.
	//that class is only a data structure + getters, setters
	
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

	@Override
	public boolean equals(Object obj) {  //support equality test
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
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