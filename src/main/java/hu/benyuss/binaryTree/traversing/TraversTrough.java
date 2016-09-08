package hu.benyuss.binaryTree.traversing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import hu.benyuss.binaryTree.binaryTreeUtils.BinaryTreeNode;

public class TraversTrough<T, M> implements Traversal<T, M> {
	// traverse trough the tree.

	private static final Logger logger = (Logger) LogManager.getLogger(TraversTrough.class.getName());
	
	@SuppressWarnings("unused")
	private TraversConst trav;

	@Override
	public final void traverseTree(BinaryTreeNode<T> current, M trav) {
		if (trav == TraversConst.PREFIX) {
			prefix(current);
		} else if (trav == TraversConst.INFIX) {
			infix(current);
		} else if (trav == TraversConst.POSTFIX) {
			postfix(current);
		}
		getLogmsg();

	}

	protected void preProcess() {
		// stands for leftChild
	}
	
	private StringBuilder logmsg = new StringBuilder();
	
	protected void processNode(BinaryTreeNode<T> current) {
		// stands for root
		logmsg.append(current.getValue());
	}

	protected void postProcess() {
		// stands for rightChild
	}
	
	public void getLogmsg () {
		logmsg.toString();
		logger.debug(logmsg);
	}
	
	private void prefix(BinaryTreeNode<T> current) { // [ / L R ]
		processNode(current);
		preProcess();
		if (current.getLeftChild() != null) {
			prefix(current.getLeftChild());
		}
		if (current.getRightChild() != null) {
			prefix(current.getRightChild());
		}
		postProcess();
	}

	private void infix(BinaryTreeNode<T> current) { // [ L / R ]
		preProcess();
		if (current.getLeftChild() != null) {
			infix(current.getLeftChild());
		}
		processNode(current);
		if (current.getRightChild() != null) {
			infix(current.getRightChild());
		}
		postProcess();
	}

	private void postfix(BinaryTreeNode<T> current) { // [ L R / ]
		preProcess();
		if (current.getLeftChild() != null) {
			postfix(current.getLeftChild());
		}
		if (current.getRightChild() != null) {
			postfix(current.getRightChild());
		}
		postProcess();
		processNode(current);
	}
}