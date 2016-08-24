class TraversedTree<T> implements Traversal<T>{
//traverse trough the tree. Implementation isn't final.
	
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