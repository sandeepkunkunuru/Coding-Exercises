package me.tingri.problemsolving.datastructures;

/**
 * A very simple implementation of linkedlist where node itself is overloaded with
 * the responsibilities of the list
 * @author kunkunur
 *
 */
public class Node<T> {
	Node<T> next;
	T value;
	
	public Node(T value){
		this.value = value; 
	}
	
	public Node<T> next(){
		return next;
	}
	
	public T value(){
		return value;
	}
	/**
	 * 
	 * @param value
	 * @return newly added node
	 */
	public Node<T> addNodeToTail(T value){
		Node<T> temp = this;

		while(temp.next != null){
			temp = temp.next;
		}
		
		temp.next = new Node<T>(value);
		
		return temp.next;
	} 
}
