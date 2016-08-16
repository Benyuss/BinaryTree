package binarytree;

public class LZWBinaryTree extends AbstractBinaryTree<String, Character> implements initLogger{

	public LZWBinaryTree() {
		root = new Node<Character>('/');
	}

	@Override
	public void add(String value) {
		Node<Character> currentNode = root;
		for (int i = 0; i < value.length(); i++) {
			int c = value.charAt(i);
				Node<Character> nextNode;
				if ((c) == '1') {
					nextNode = currentNode.getRightChild();
					if (nextNode == null) {
						Node<Character> newNode = new Node<Character>('1');
						currentNode.setRightChild(newNode);
						nextNode = root;
					}
				} else {
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
	
	/*public void initalization (String bits) {
		lzwTree.add(bits);
		
		int depth = lzwTree.depth();
		double avg = lzwTree.averageDepth();
		double var = lzwTree.variance();
		System.out.println(depth + " " + avg + " " + var);
	}*/
}
