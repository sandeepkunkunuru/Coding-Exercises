package me.tingri.ds.simple;
/**
 * Simple Queue implementation
 * 
 * @author kunkunur
 *
 */
public class Queue<T> {
	 Node start;
	 Node end;
	 
	 public void enqueue(T value){
	   if(start == null){
	       start = new Node(value);
	       end = start;
	   } else {
	       Node node = new Node(value);
	       
	       end.next = node;
	       
	       end = node;
	   }
	 }
	 
	 public T dequeue() throws Exception{
	  if(start == null){
	      throw new Exception("Queue is empty");
	  } else {
	     T value = start.value;

	     start = start.next;

	     return value;
	  }
	 }
	 
	 class Node{
	   Node next;
	   T value;
	   
	   Node(T value){
	    this.value = value;	   
	  }
	 }
	}