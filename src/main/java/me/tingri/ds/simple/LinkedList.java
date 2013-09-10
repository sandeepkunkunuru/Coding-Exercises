package me.tingri.ds.simple;
/**
 * Simple Doubly Linked List implementation
 * 
 * @author kunkunur
 *
 */
public class LinkedList<T>{
	 Node start;
	 Node end;
	 
	 public void add(T value){
	     if(start == null){
	         this.start = this.end = new Node(value, null);
	     } else {
	         Node newNode = new Node(value, end);
	         end = newNode;
	     }
	 }
	 
	 public T remove() throws Exception{
	     if(start != null){
	         Node retNode = start;
	         
	         start = start.next;  
	         
	         start.previous = null;
	         retNode.next = null;
	         
	         return retNode.value;  
	     } else {
	    	 throw new Exception("List is empty");
	     }
	 }
	 

	 class Node{
	     Node next, previous;
	     T value;
	     
	     Node(T value, Node previous){
	         this.value = value;
	         this.previous = previous;
	         previous.next = this;
	     }
	 }
	}
