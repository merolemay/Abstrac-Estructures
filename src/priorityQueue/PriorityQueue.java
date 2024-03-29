package priorityQueue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import queue.Queue;

public class PriorityQueue <E> implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Object[] table;
	private final int capacity;
	private int size;
	
	public PriorityQueue(int size) {
			table  = new Object[size];
	        capacity = size;
	        this.size = -1;
	}
	
	
    @SuppressWarnings("unchecked")
	public E Head() throws NoSuchElementException  {
    	
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return ((Node<E>) table[0]).getObj();
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public E pop() throws NoSuchElementException  {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
        	E aux = ((Node<E>) table[0]).getObj();
        	 remove();
            return aux;
        }
    }
    
    @SuppressWarnings("unchecked")
	public void add(E obj,int priority) throws ArrayIndexOutOfBoundsException {
    	
    	size = size + 1;
    	
    		if(size>=capacity) {
    			 size = size - 1;
    	            throw new ArrayIndexOutOfBoundsException();
    		} else {
    			
    			int i = size;
    			
    			 while (i > 0 && ((Node<E>) table[i - 1]).getPriority() < priority) {
    				 table[i] = table[i - 1];
    	                i = i - 1;
    	            }
    			 
    			 table[i] = new Node<>(obj, priority);
    			
    		}
    }
    
    /**
     * Remove the highest priority item from the queue. Throw an exception if
     * it's empty.
     * @throws NullPointerException
     */
    public void remove() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException();
        } else {
            for (int i = 0; i < size; i++) {
                table[i] = table[i + 1];
            }
            size = size - 1;
        }
    }
    
    public int getSize() {
		return size;
	}
    
	public boolean isEmpty() {
		
		return size < 0;
	}
	public ArrayList<E> toArrayList() {
		ArrayList<E> vojabes = new ArrayList<E>();
		PriorityQueue<E> q = this;
		for (int i = 0; i < size; i++) {
			vojabes.add(q.pop());
		}
		
		return vojabes;
	}
}

