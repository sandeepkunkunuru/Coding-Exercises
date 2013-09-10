package me.tingri.problemsolving.datastructures;

public class StackNode<T> {
	StackNode<T> previous;
	StackNode<T> top;
	T value;
	
	public StackNode(T value){
		this.previous = null;
		this.value = value;
		top = this;
	}
	
	public StackNode<T> push(T value){
		StackNode<T> newNode = new StackNode<T>(value);
		
		if(top == null) {
			top = newNode;
		} else {
			StackNode<T> prevTop = top;
			top = newNode;
			top.previous = prevTop;
		}	
		
		return this;
	}
	
	public T pop(){
		StackNode<T> topNode = null;
		
		if(top != null) {
			topNode = top;
	
			top = topNode.previous;
			
			topNode.previous = null;			
		}
		
		return topNode.value;
	}
	
	public T peek(){
		if(top != null){
			return top.value;
		}
		
		return null;
	}
	
	public boolean isEmpty(){
		return top == null;
	}

}
