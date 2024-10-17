package BST;

import java.util.ArrayList;

public class BSTAvl<E, K extends Comparable<? super K>> extends BST<E, K> {

	private Node<E, K> root;

	public BSTAvl() {
		root = null;
	}

	public BSTAvl(E element, K key) {
		root = new Node<>(element, key);
	}

	// Add a new element with the corresponding key
	@Override
	public void add(E element, K key) {
		root = addNodeRecursive(root, element, key);
	}

	// Recursive function to insert a node and balance the AVL tree
	private Node<E, K> addNodeRecursive(Node<E, K> current, E element, K key) {
		if (current == null) {
			return new Node<>(element, key); // Base case
		}

		if (key.compareTo(current.getKey()) < 0) {
			current.setLeft(addNodeRecursive(current.getNodeLeft(), element, key));
		} else if (key.compareTo(current.getKey()) > 0) {
			current.setRight(addNodeRecursive(current.getNodeRight(), element, key));
		} else {
			return current; // Duplicate keys not allowed
		}

		// Update the height of the current node
		current.setHeight(1 + Math.max(height(current.getNodeLeft()), height(current.getNodeRight())));

		// Balance the node
		return balanceNode(current, key);
	}

	// Delete a node by key and balance the AVL tree
	@Override
	public void delete(K key) {
		root = deleteNodeRecursive(root, key);
	}

	private Node<E, K> deleteNodeRecursive(Node<E, K> node, K key) {
		if (node == null) {
			return null; // Base case
		}

		if (key.compareTo(node.getKey()) < 0) {
			node.setLeft(deleteNodeRecursive(node.getNodeLeft(), key));
		} else if (key.compareTo(node.getKey()) > 0) {
			node.setRight(deleteNodeRecursive(node.getNodeRight(), key));
		} else {
			// Node found, handle deletion cases
			if (node.getNodeLeft() == null || node.getNodeRight() == null) {
				return (node.getNodeLeft() != null) ? node.getNodeLeft() : node.getNodeRight();
			} else {
				// Find the leftmost node in the right subtree
				Node<E, K> temp = findLeftmost(node.getNodeRight());
				node.setElement(temp.getElement());
				node.setRight(deleteNodeRecursive(node.getNodeRight(), temp.getKey()));
			}
		}

		// Update the height of the current node
		node.setHeight(1 + Math.max(height(node.getNodeLeft()), height(node.getNodeRight())));

		// Balance the node
		return balanceNode(node, key);
	}

	// Balances the AVL tree node after insert/delete operations
	private Node<E, K> balanceNode(Node<E, K> node, K key) {
		int balance = getBalance(node);

		// Left Left Case
		if (balance > 1 && key.compareTo(node.getNodeLeft().getKey()) < 0) {
			return rotateRight(node);
		}

		// Right Right Case
		if (balance < -1 && key.compareTo(node.getNodeRight().getKey()) > 0) {
			return rotateLeft(node);
		}

		// Left Right Case
		if (balance > 1 && key.compareTo(node.getNodeLeft().getKey()) > 0) {
			node.setLeft(rotateLeft(node.getNodeLeft()));
			return rotateRight(node);
		}

		// Right Left Case
		if (balance < -1 && key.compareTo(node.getNodeRight().getKey()) < 0) {
			node.setRight(rotateRight(node.getNodeRight()));
			return rotateLeft(node);
		}

		return node;
	}

	// Find the leftmost node in the tree (used for deletion)
	private Node<E, K> findLeftmost(Node<E, K> node) {
		while (node.getNodeLeft() != null) {
			node = node.getNodeLeft();
		}
		return node;
	}

	// AVL Tree rotations
	private Node<E, K> rotateRight(Node<E, K> y) {
		Node<E, K> x = y.getNodeLeft();
		Node<E, K> T2 = x.getNodeRight();

		// Perform rotation
		x.setRight(y);
		y.setLeft(T2);

		// Update heights
		y.setHeight(1 + Math.max(height(y.getNodeLeft()), height(y.getNodeRight())));
		x.setHeight(1 + Math.max(height(x.getNodeLeft()), height(x.getNodeRight())));

		return x;
	}

	private Node<E, K> rotateLeft(Node<E, K> x) {
		Node<E, K> y = x.getNodeRight();
		Node<E, K> T2 = y.getNodeLeft();

		// Perform rotation
		y.setLeft(x);
		x.setRight(T2);

		// Update heights
		x.setHeight(1 + Math.max(height(x.getNodeLeft()), height(x.getNodeRight())));
		y.setHeight(1 + Math.max(height(y.getNodeLeft()), height(y.getNodeRight())));

		return y;
	}

	// Get the balance factor of the node
	private int getBalance(Node<E, K> node) {
		if (node == null) {
			return 0;
		}
		return height(node.getNodeLeft()) - height(node.getNodeRight());
	}

	// Utility to get the height of a node
	private int height(Node<E, K> node) {
		if (node == null) {
			return 0;
		}
		return node.getHeight();
	}

	// Convert the tree to an array list (in-order traversal)
	public ArrayList<E> toArrayList() {
		ArrayList<E> result = new ArrayList<>();
		toArrayList(root, result);
		return result;
	}

	private void toArrayList(Node<E, K> node, ArrayList<E> list) {
		if (node != null) {
			toArrayList(node.getNodeLeft(), list);
			list.add(node.getElement());
			toArrayList(node.getNodeRight(), list);
		}
	}

	// Tree traversals
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
