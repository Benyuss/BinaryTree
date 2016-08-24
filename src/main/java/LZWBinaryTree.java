import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Logger;

public class LZWBinaryTree extends AbstractBinaryTree<String, Character>{
//Builds an LZW tree. If current node has a child, currentNode will point to that. If not, it will create one and jump back to root.
	
	private static Logger logger = null;

	static {

		try {
			InitLogger.initialize();
		} catch (FileNotFoundException e) {
			logger.log(Level.ERROR,
					"Can't initialize main's constructor due to loggers configuration file hasn't been found.");
			e.printStackTrace();
		} catch (IOException e) {
			logger.log(Level.ERROR,
					"Can't initialize main's constructor due to loggers configuration file hasn't been found.");
			e.printStackTrace();
		}

		logger = InitLogger.logger[0];
	}

	public LZWBinaryTree() {
		root = new Node<Character>('/');
	}

	@Override
	public void add(String value) { //value is the bitset.
		Node<Character> currentNode = root;
		Node<Character> nextNode = root;
		for (int i = 0; i < value.length(); i++) {
			int c = value.charAt(i);
			if ((c) == '1') {
				nextNode = currentNode.getRightChild(); // if it's null, it will create a child.
				if (nextNode == null) {
					Node<Character> newNode = new Node<Character>('1');
					currentNode.setRightChild(newNode);
					nextNode = root;
					logger.log(Level.TRACE, currentNode.getRightChild());
				}
			} else if ((c) == '0') {
				nextNode = currentNode.getLeftChild();
				if (nextNode == null) {
					Node<Character> newNode = new Node<Character>('0');
					currentNode.setLeftChild(newNode);
					nextNode = root;
					logger.log(Level.TRACE, currentNode.getLeftChild());
				}
			}
			currentNode = nextNode; // if not, current will be set to that. recursion just started.
			logger.log(Level.TRACE, currentNode);
		}
	}
}