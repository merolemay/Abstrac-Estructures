package iLinkedList;

public class iNode<E> {

	private E data = null;
	private iNode<E> next = null;
	
	public iNode(E obj, iNode<E> next){
		
		this.data = obj;
		this.next = next;
	}
	
	public iNode(E obj){
		
		this.data = obj;
		this.next = null;
		
	}

	public void set(E object){
		
		this.data = object;
	}
	
	public void setNext(iNode<E> node){
		
		this.next = node;
		
	}

	public E get(){
		
		return this.data;
	}
	
	public iNode<E> nextNode(){
		
		return next;
	}

}
