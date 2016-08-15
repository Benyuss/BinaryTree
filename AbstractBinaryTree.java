package binarytree;

public abstract class AbstractBinaryTree<T, N> implements BinaryTree<T>{//String,Char LZWBinary miatt.
	protected Node<N> root;

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((root == null) ? 0 : root.hashCode());
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractBinaryTree other = (AbstractBinaryTree) obj;
		if (root == null) {
			if (other.root != null)
				return false;
		} else if (!root.equals(other.root))
			return false;
		return true;
	}

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
		double count = 0;
		double sum = 0;
		@Override
		protected void processNode(Node<N> current) {
			super.processNode(current);
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
		return adc.sum / adc.count;
	}
	
	
	class VarianceCalculator extends DepthCalculator {
		double sumSqr = 0;
		double count = 0;
		double avg;
		
		public VarianceCalculator(double avg) {
			this.avg = avg;
		}

		@Override
		protected void processNode(Node<N> current) {
			super.processNode(current);
			if (current != null) {
			      if (current.getRightChild() == null && current.getLeftChild() == null) {
			    	  count++;
			    	  sumSqr += ((currentDepth - avg) * (currentDepth - avg));
			      }
			}
		}
		
	}
	
	@Override
	public double variance() {
		double avg = averageDepth();
		VarianceCalculator var = new VarianceCalculator(avg);
		var.traverseTree(root);
		double variance;
		if (var.count > 1)
		    variance = Math.sqrt(var.sumSqr / (var.count - 1));
		  else
		    variance = Math.sqrt(var.sumSqr);
		return variance;
	}
	
}	
