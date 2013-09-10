package me.tingri.problemsolving.datastructures;

public class LinkedListNew<T> {
	LinkedListNode<T> start;
	LinkedListNode<T> end;
	
	
	public LinkedListNew(T value){
		start = new LinkedListNode<T>(value, null);
		end = start;
	}
	
	public LinkedListNew<T> add(T nextElement){
		LinkedListNode<T> node = new LinkedListNode<T>(nextElement, end);
		end = node;
		
		return this;
	}
	
	public LinkedListIterator<T> iterator(){
		return new LinkedListIterator<T>(start);
	}

	private static class LinkedListNode<T> {
		private T value;
		private LinkedListNode<T> next;
		private LinkedListNode<T> prev;
	
		LinkedListNode(T node, LinkedListNode<T> previous){
			value = node;
			prev = previous;
			
			if(prev != null) {
				prev.setNext(this);
			}
		}
		
		void setNext(LinkedListNode<T> nextNode) {
			next = nextNode;
		}
		
		LinkedListNode<T> getNext(){
			return next;
		}
		
		LinkedListNode<T> getPrevious(){
			return prev;
		}
		
		void setPrevious(LinkedListNode<T> previous){
			prev = previous;
		}		
		
		T getValue(){
			return value;
		}
	
	}
	
	public static class LinkedListIterator<T> {
		LinkedListNode<T> currentPosition;
		
		LinkedListIterator(LinkedListNode<T> start){
			currentPosition = start;
		}
		
		public LinkedListNode<T> next(){
			if(currentPosition == null){
				return null;
			} else if(currentPosition.getNext() == null){
				currentPosition = null;
				
				return null;
			} 
			
			LinkedListNode<T> value = currentPosition.getNext();
			
			currentPosition = currentPosition.getNext();
			
			return value;
		}
		
		public boolean hasNext(){
			return ! (currentPosition == null  || currentPosition.getNext() == null);
		}
		
		public LinkedListNode<T> previous() {
			if(currentPosition == null){
				return null;
			} else if(currentPosition.getPrevious() == null){
				currentPosition = null;
				
				return null;
			} 

			LinkedListNode<T> value = currentPosition.getPrevious();
			
			currentPosition = currentPosition.getPrevious();
			
			return value;
		}
		
		public boolean hasPrevious(){
			return !(currentPosition == null  || currentPosition.getPrevious() == null);
		}
		
		public T remove(){  
			LinkedListNode<T> ref = currentPosition;
			
			if(currentPosition != null){
				LinkedListNode<T> next = currentPosition.getNext();
				LinkedListNode<T> prev = currentPosition.getPrevious();

				currentPosition.setNext(null);
				currentPosition.setPrevious(null);
				
				if(next != null){								
					next.setPrevious(prev);	
					
					if(prev != null){
						prev.setNext(next);
					}	
				} 
				
				currentPosition = next;
			} 
						
			return ref.getValue();
		}
		
	
	}
}