package hu.benyuss.binaryTree.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import hu.benyuss.binaryTree.binaryTreeUtils.BinaryTreeNode;
import hu.benyuss.binaryTree.traversing.TraversConst;

public class LZWBinaryTree extends AbstractBinaryTree<String, Character, TraversConst> {
	// Builds a LZW tree. If current node has a child, currentNode will point
	// to that. If not, it will create one and jump back to root.

	private static final Logger logger = (Logger) LogManager.getLogger(LZWBinaryTree.class.getName());

	private int depth;
	private double avg;
	private double var;
	private int hash;

	public LZWBinaryTree() {
		root = new BinaryTreeNode<Character>('/');
	}

	@Override
	public void add(String value, TraversConst trav) {
		// value is the bitset.
		// only 1 / 0 chars will be parsed.

		BinaryTreeNode<Character> currentNode = root;
		BinaryTreeNode<Character> nextNode = root;
		for (int i = 0; i < value.length(); i++) {
			int c = value.charAt(i);
			if ((c) == '1') {
				nextNode = currentNode.getRightChild(); // if it's null, it will
														// create a child.
				if (nextNode == null) {
					BinaryTreeNode<Character> newNode = new BinaryTreeNode<Character>('1');
					currentNode.setRightChild(newNode);
					nextNode = root;
					logger.trace(currentNode.getRightChild());
				}
			} else if ((c) == '0') {
				nextNode = currentNode.getLeftChild();
				if (nextNode == null) {
					BinaryTreeNode<Character> newNode = new BinaryTreeNode<Character>('0');
					currentNode.setLeftChild(newNode);
					nextNode = root;
					logger.trace(currentNode.getLeftChild());
				}
			}
			currentNode = nextNode; // if not, current will be set to that.
									// recursion just started.
//			logger.trace(currentNode); // if you want to follow the script.
		}
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public double getVar() {
		return var;
	}

	public void setVar(double var) {
		this.var = var;
	}

	public int getHash() {
		return hash;
	}

	public void setHash(int hash) {
		this.hash = hash;
	}

}