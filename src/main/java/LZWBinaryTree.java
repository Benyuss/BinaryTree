public class LZWBinaryTree extends AbstractBinaryTree<String, Character> implements InitLogger{

	public LZWBinaryTree() {
		root = new Node<Character>('/');
	}

	@Override
	public void add(String value) {
		Node<Character> currentNode = root;
		Node<Character> nextNode = root;
		for (int i = 0; i < value.length(); i++) {
			int c = value.charAt(i);
				if ((c) == '1') {
					nextNode = currentNode.getRightChild();
					if (nextNode == null) {
						Node<Character> newNode = new Node<Character>('1');
						currentNode.setRightChild(newNode);
						nextNode = root;
					}
				} else if ((c) == '0'){
					nextNode = currentNode.getLeftChild();
					if (nextNode == null) {
						Node<Character> newNode = new Node<Character>('0');
						currentNode.setLeftChild(newNode);
						nextNode = root;
					}
				}
				currentNode = nextNode;
		}
	}
}	