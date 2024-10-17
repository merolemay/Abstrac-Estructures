package BST;

public class BST<E, K extends Comparable<? super K>> {

	private Node<E, K> root;

	// Default constructor
	public BST() {
		root = null;
	}

	// Constructor initializing with a specific root node
	public BST(Node<E, K> root) {
		this.root = root;
	}

	// Constructor initializing with an element and key
	public BST(E element, K key) {
		root = new Node<>(element, key);
	}

	// Search for an element by key
	public E search(K key) {
		if (root == null) {
			throw new NullPointerException("Tree is empty.");
		}
		return searchRecursive(root, key);
	}

	// Recursive function to search for a key
	private E searchRecursive(Node<E, K> current, K key) {
		if (current == null) {
			return null; // Key not found
		}
		if (key.compareTo(current.getKey()) == 0) {
			return current.getElement(); // Key found
		} else if (key.compareTo(current.getKey()) < 0) {
			return searchRecursive(current.getNodeLeft(), key); // Search left subtree
		} else {
			return searchRecursive(current.getNodeRight(), key); // Search right subtree
		}
	}

	// Add a new element with the corresponding key
	public void add(E element, K key) {
		root = addNodeRecursive(root, element, key);
	}

	// Recursive function to add a new node
	private Node<E, K> addNodeRecursive(Node<E, K> current, E element, K key) {
		if (current == null) {
			return new Node<>(element, key); // Base case: insert new node
		}

		if (key.compareTo(current.getKey()) < 0) {
			current.setLeft(addNodeRecursive(current.getNodeLeft(), element, key)); // Insert in left subtree
		} else if (key.compareTo(current.getKey()) > 0) {
			current.setRight(addNodeRecursive(current.getNodeRight(), element, key)); // Insert in right subtree
		}

		return current;
	}

	// Delete a node by key
	public void delete(K key) {
		root = deleteRecursive(root, key);
	}

	// Recursive function to delete a node
	private Node<E, K> deleteRecursive(Node<E, K> current, K key) {
		if (current == null) {
			return null; // Base case: key not found
		}

		if (key.compareTo(current.getKey()) < 0) {
			current.setLeft(deleteRecursive(current.getNodeLeft(), key)); // Search in left subtree
		} else if (key.compareTo(current.getKey()) > 0) {
			current.setRight(deleteRecursive(current.getNodeRight(), key)); // Search in right subtree
		} else {
			// Node to be deleted found
			if (current.getNodeLeft() == null) {
				return current.getNodeRight(); // Node with only right child or no children
			} else if (current.getNodeRight() == null) {
				return current.getNodeLeft(); // Node with only left child
			} else {
				// Node with two children: find in-order successor (smallest in right subtree)
				Node<E, K> temp = findRightmost(current.getNodeRight());
				current.setElement(temp.getElement());
				current.setRight(deleteRecursive(current.getNodeRight(), temp.getKey()));
			}
		}

		return current;
	}

	// Find the rightmost node (smallest key) in a subtree
	private Node<E, K> findRightmost(Node<E, K> node) {
		while (node.getNodeLeft() != null) {
			node = node.getNodeLeft();
		}
		return node;
	}

	// In-order traversal: left subtree -> root -> right subtree
	public void traverseInOrder() {
		traverseInOrder(root);
	}

	private void traverseInOrder(Node<E, K> node) {
		if (node != null) {
			traverseInOrder(node.getNodeLeft());
			System.out.println(node.getElement());
			traverseInOrder(node.getNodeRight());
		}
	}

	// Pre-order traversal: root -> left subtree -> right subtree
	public void traversePreOrder() {
		traversePreOrder(root);
	}

	private void traversePreOrder(Node<E, K> node) {
		if (node != null) {
			System.out.println(node.getElement());
			traversePreOrder(node.getNodeLeft());
			traversePreOrder(node.getNodeRight());
		}
	}

	// Post-order traversal: left subtree -> right subtree -> root
	public void traversePostOrder() {
		traversePostOrder(root);
	}

	private void traversePostOrder(Node<E, K> node) {
		if (node != null) {
			traversePostOrder(node.getNodeLeft());
			traversePostOrder(node.getNodeRight());
			System.out.println(node.getElement());
		}
	}

	// Get the root node
	public Node<E, K> getRoot() {
		return root;
	}
}
