package binarytree;

public interface BinaryTree<T> {//String
	
	//void travWay(String bits); //select the traversal way
	void add(T value); 
	int depth(); //mélység
	double averageDepth();
	double variance();
}
