package queue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Queue<E> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Node<E> head = null;
	private Node<E> tail = null;
	private int queueSize=0;
	
	public Queue() {}
	
	//Stars the queue with one element
	public Queue(E obj) {
		head = new Node<E>(obj);
		queueSize =1;
	}
	
	

	public Queue(E head, E tail){
		
		this.head = new Node<E>(head);
		this.tail = new Node<E>(tail);
		this.head.setPrevious(this.tail);
		this.tail.setNext(this.head);
		
		queueSize = 2;
	}
	
	public void enqueue(E obj){
		
		if (queueSize == 0){
			
			head = new Node<E>(obj);
			
		}
		else if (queueSize == 1){
			
			tail = new Node<E>(obj, head, null);
			
		} 
		else {
			
			tail = new Node<E>(obj, tail, null);
		}
		
		queueSize += 1;
	}
	
	public E dequeue() throws NoSuchElementException{
		
		if (queueSize == 0){
	
			throw new NoSuchElementException();
	
		} else {	
			E swap = head.get();
			head = head.getPrevious();
			queueSize -= 1;
			return swap;
		}
	}
	
	public int size(){
		
		return queueSize;
	}
	
	public boolean isEmpty() {
		if(head==null) {
			return true;
		}else {
			return false;
		}
	}
	
	public ArrayList<E> toArrayList() {
		ArrayList<E> vojabes = new ArrayList<E>();
		Queue<E> q = this;
		for (int i = 0; i < queueSize; i++) {
			vojabes.add(q.dequeue());
			
		}
		return vojabes;
	}
}
