package BST;

public class Node<T, K extends Comparable<? super K>> {

	private T element;         // The value or data stored in the node
	private K key;             // The key used for comparisons
	private int height;        // Height of the node (for AVL balancing)
	private Node<T, K> nodeLeft;  // Left child
	private Node<T, K> nodeRight; // Right child

	// Constructor for a new node with a specific element and key
	public Node(T element, K key) {
		this.element = element;
		this.key = key;
		this.height = 1; // Starting height is 1 for a new node
		this.nodeLeft = null;
		this.nodeRight = null;
	}

	// Constructor with all properties
	public Node(T element, K key, int height, Node<T, K> nodeLeft, Node<T, K> nodeRight) {
		this.element = element;
		this.key = key;
		this.height = height;
		this.nodeLeft = nodeLeft;
		this.nodeRight = nodeRight;
	}

	// Getters and Setters
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Node<T, K> getNodeLeft() {
		return nodeLeft;
	}

	public void setLeft(Node<T, K> nodeLeft) {
		this.nodeLeft = nodeLeft;
	}

	public Node<T, K> getNodeRight() {
		return nodeRight;
	}

	public void setRight(Node<T, K> nodeRight) {
		this.nodeRight = nodeRight;
	}
}