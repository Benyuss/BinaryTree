import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Logger;

public abstract class AbstractBinaryTree<T, N> implements BinaryTree<T>{// String,Char
	
	protected Node<N> root;

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

	@Override
	public boolean equals(Object obj) {	//to know if the trees are the same or not.
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

	class DepthCalculator extends TraversedTree<N> {
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
		logger.log(Level.DEBUG, "Tree is " + dc.maxDepth + " deep.");
		return dc.maxDepth;
	}

	class AverageDepthCalculator extends DepthCalculator {
		double count = 0;
		double sum = 0;

		@Override
		protected void processNode(Node<N> current) {
			super.processNode(current);
			logger.log(Level.DEBUG, current.getValue());
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
		double temp = adc.sum / adc.count;
		logger.log(Level.DEBUG, "Avarage depth is " + temp);
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
		logger.log(Level.DEBUG, "Variance is " + variance);
		return variance;
	}
}