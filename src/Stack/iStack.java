package Stack;

import java.util.NoSuchElementException;

public class iStack<E> {
	
	private iLinkedList<E> stack = null;
	
	//Empty stack
	public iStack() {
		
	stack = new iLinkedList<E>();
	}
	
	//Primes the stack with one object at the top
	public iStack(E obj){	
		
	stack = new iLinkedList<E>(obj);
	}
		
	//Add an element to the top of the stack
	public void push(E obj){
		
	stack.push(obj);	
	}
	
	/* Returns the top element of the stack off and delete it
	 * and if there are no elements then it throws an exception
	 */
	public E pop(E obj) throws NoSuchElementException{
		if (stack.size() == 0){
			
			throw new NoSuchElementException();
		}
		
		return stack.pop();
	}
	
	/* Returns the top element of the stack off and
	 * and if there are no elements then it throws an exception
	 */
	public E peek() throws NoSuchElementException{
		
		if (stack.size() == 0){
			
			throw new NoSuchElementException();
		}
		
		return stack.peek();
	}
	
	//Checks to see if the stack is empty
	public boolean isEmpty(){
		
		return stack.isEmpty();
	}
	
	//Returns the size of the stack
	public int size(){
		
		return stack.size();
	}
}
