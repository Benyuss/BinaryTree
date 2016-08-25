import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Logger;

class TraversedTree<T> implements Traversal<T>{
//traverse trough the tree. Implementation isn't final.
	
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
	public final void traverseTree(Node<T> current) {
		preProcess();
		if (current.getLeftChild() != null) {
			traverseTree(current.getLeftChild());
		}
		processNode(current);
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