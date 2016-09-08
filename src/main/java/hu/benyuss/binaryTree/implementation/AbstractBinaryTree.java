package hu.benyuss.binaryTree.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import hu.benyuss.binaryTree.binaryTreeUtils.BinaryTree;
import hu.benyuss.binaryTree.binaryTreeUtils.BinaryTreeNode;
import hu.benyuss.binaryTree.traversing.TraversTrough;

public abstract class AbstractBinaryTree<T, N, M> implements BinaryTree<T, M> {

	// Every method has the same logics as
	// http://www.inf.unideb.hu/~nbatfai/z3a7.cpp

	private static final Logger logger = (Logger) LogManager.getLogger(AbstractBinaryTree.class.getName());

	protected BinaryTreeNode<N> root;

	@Override
	public boolean equals(Object obj) {
		// to know if the trees are the same or not.

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		AbstractBinaryTree other = (AbstractBinaryTree) obj;
		if (root == null) {
			if (other.root != null)
				return false;
		} else if (!root.equals(other.root))
			return false;
		return true;
	}

	class DepthCalculator extends TraversTrough<N, M> {
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
	public int depth(M trav) {
		DepthCalculator dc = new DepthCalculator();
		dc.traverseTree(root, trav);
		logger.info("Tree is " + dc.maxDepth + " deep.");
		return dc.maxDepth;
	}

	class AverageDepthCalculator extends DepthCalculator {
		double count = 0;
		double sum = 0;

		@Override
		protected void processNode(BinaryTreeNode<N> current) {
			super.processNode(current);

			if (current.getLeftChild() == null && current.getRightChild() == null) {
				count++;
				sum += currentDepth;
			}
		}
	}

	@Override
	public double averageDepth(M trav) {
		AverageDepthCalculator adc = new AverageDepthCalculator();
		adc.traverseTree(root, trav);
		double temp = adc.sum / adc.count;
		logger.info("Avarage depth is " + temp);
		return temp;
	}

	class VarianceCalculator extends DepthCalculator {
		double sumSqr = 0;
		double count = 0;
		double avg;

		public VarianceCalculator(double avg) {
			this.avg = avg;
		}

		@Override
		protected void processNode(BinaryTreeNode<N> current) {
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
	public double variance(M trav) {
		double avg = averageDepth(trav);
		VarianceCalculator var = new VarianceCalculator(avg);
		var.traverseTree(root, trav);
		double variance;
		if (var.count > 1)
			variance = Math.sqrt(var.sumSqr / (var.count - 1));
		else
			variance = Math.sqrt(var.sumSqr);
		logger.info("Variance is " + variance);
		return variance;
	}
}