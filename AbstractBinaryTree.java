package binarytree;

public abstract class AbstractBinaryTree<T, N> implements BinaryTree<T>{//String,Char LZWBinary miatt.
	protected Node<N> root;

	class DepthCalculator extends PreorderTraversal<N> {
		int currentDepth = -1; // root node should not be counted
		int maxDepth = 0;
		@Override
		public void preProcess() {
			currentDepth++;
			if (currentDepth > maxDepth) {
				maxDepth = currentDepth;
			}
		}
		@Override
		protected void postProcess() {
			currentDepth--;
		}
	}
	
	@Override
	public int depth() {
		DepthCalculator dc = new DepthCalculator();
		dc.traverseTree(root);
		return dc.maxDepth;
	}
	
	class AverageDepthCalculator extends DepthCalculator {
		int count = 0;
		int sum = 0;
		double avg = 0;
		@Override
		protected void processNode(Node<N> current) {
			if (current.getLeftChild() == null && current.getRightChild() == null) {
				count++;
				sum += currentDepth;
			}
		}
	}
	
	@Override
	public double averageDepth() {
		AverageDepthCalculator adc = new AverageDepthCalculator();
		adc.traverseTree(root);
		adc.avg = (double)adc.sum / (double)adc.count;
		return adc.avg;
	}
	
	
	class VarianceCalculator extends AverageDepthCalculator {
		int sum = 0;
		int supersum = super.sum;
		
		@Override
		protected void processNode(Node<N> current) {
			if (current != null) {
			      if (current.getRightChild() == null && current.getLeftChild() == null) {
			    	  super.sum++;
			    	  sum += ((maxDepth - avg) * (maxDepth - avg));
			      }
			}
		}
		
	}
	
	@Override
	public double variance() {
		VarianceCalculator var = new VarianceCalculator();
		double variance;
		var.traverseTree(root);
		if (var.supersum - 1 > 0)
		    variance = Math.sqrt(var.sum / (var.supersum - 1));
		  else
		    variance = Math.sqrt(var.sum);
		return variance;
	}
}	
