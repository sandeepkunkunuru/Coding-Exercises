package me.tingri.ds.simple;
/**
 * Simple Stack implementation
 * 
 * @author kunkunur
 *
 */
public class Stack<T>{
	 Node top;
	 
	 public void push(T value){
	     if(top == null ){
	         top = new Node(value, null);
	     } else {
	         top = new Node(value, top);
	     }
	 }
	 
	 public T pop() throws Exception{
	     if(top != null){
	         T value = top.value;
	    	 top = top.previous;
	         return value;
	     }
	     
	     throw new Exception("Stack is empty");
	 }

	 private class Node{
	   Node previous;
	   T value;
	   
	   Node(T value, Node previous){
	    this.value = value;
	    this.previous = previous;
	   }
	 }
	}
