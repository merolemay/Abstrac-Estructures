package BST;

import java.util.ArrayList;

public interface iBSTAVL<E,K extends Comparable<? super K>> {
	
	
	int depth(Node<E, K> current);
	
	int checkAVLBalance();
	
	
	ArrayList<E> toArrayList();
	
}
