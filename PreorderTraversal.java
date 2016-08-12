package binarytree;

class PreorderTraversal<T> implements Traversal<T> {
	
	@Override
	public final void traverseTree(Node<T> current) {
		preProcess();
		processNode(current);
		if (current.getLeftChild() != null) {
			traverseTree(current.getLeftChild());
		}
		if (current.getRightChild() != null) {
			traverseTree(current.getRightChild());
		}		
		postProcess();
	}
	protected void preProcess() {
	};
	protected void processNode(Node<T> current) {
	};
	protected void postProcess() {
	};
}


/*
public class OrderedTraversal<T> implements Traversal<T> {//Char
	@Override
	public final void preOrderTraversal(Node<T> current) {
		preProcess();
		processAvgPRE(current);
		processVarPRE(current);
		if (current.getLeftChild() != null) {
			preOrderTraversal(current.getLeftChild());
		}
		if (current.getRightChild() != null) {
			preOrderTraversal(current.getRightChild());
		}		
		postProcess();
	}
	
	protected void preProcess() {
	}

	protected void postProcess() {
	}

	protected void processAvg() {
	}
	
	protected void processAvgPRE(Node<T> current) {
	}
	
	protected void processVar() {
	}
	
	protected void processVarPRE(Node<T> current) {
		// TODO Auto-generated method stub
		
	}
}*/
