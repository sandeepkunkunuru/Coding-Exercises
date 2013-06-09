package kunkunur.org.problemsolving;

import java.util.Arrays;

public class TreeBalanceValidator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Build a tree first
		Node<Integer> root = new Node<Integer>(0, null);
		Node<Integer> c1 = new Node<Integer>(1, root);
		Node<Integer> c2 = new Node<Integer>(2, root);
		Node<Integer> c3 = new Node<Integer>(3, root);
		Node<Integer> c11 = new Node<Integer>(11, c1);
		Node<Integer> c21 = new Node<Integer>(21, c2);
		Node<Integer> c22 = new Node<Integer>(22, c2);

		System.out.println(root);

		//should be true
		System.out.println(root.checkIfBalanced());
		
		root = new Node<Integer>(0, null);
		 c1 = new Node<Integer>(1, root);
		 c2 = new Node<Integer>(2, root);
		 c3 = new Node<Integer>(3, root);
		 c11 = new Node<Integer>(11, c1);
		 c21 = new Node<Integer>(21, c2);
		 c22 = new Node<Integer>(22, c2);
		 Node<Integer> c311 = new Node<Integer>(311, c11);

		System.out.println(root);

		//should be false
		System.out.println(root.checkIfBalanced());

	}

	private static class Node<T> {
		Node<T> parent;
		T value;
		LinkedList<Node<T>> children = new LinkedList<Node<T>>();

		Node(T value, Node<T> parent) {
			this.value = value;
			this.parent = parent;

			if (parent != null) {
				parent.children.add(this);
			}
		}

		public String toString() {
			Node<T> curNode = this;
			StringBuilder str = new StringBuilder();

			str.append(curNode.value + "  ");

			LinkedListNode<Node<T>> child = curNode.children.start;

			while (child != null) {
				str.append(child.value.toString());
				child = child.next;
			}

			return str.toString();
		}

		public boolean checkIfBalanced() {
			String depthString = depthString(0, "");
			
			String[] depths = depthString.split("--");
			
			System.out.println(Arrays.toString(depths));
			
			int min = -1, max = -1;
					
		    for(int i =0; i < depths.length; i ++){
		    	int depth = Integer.parseInt(depths[i]);
		    	
		    	if(depth >= max) {
		    		max = depth;
		    	}
		    	
		    	if(depth <= max){
		    		min = depth;
		    	}
		    }
			
			return (max - min) <= 1;
		}

		private String depthString(int curDepth, String depthStr) {
			Node<T> curNode = this;

			LinkedListNode<Node<T>> child = curNode.children.start;

			if(child == null) {
				 depthStr += curDepth + "--";
				 
				 return depthStr;
			}
			
			while (child != null) {
				depthStr = child.value.depthString(curDepth + 1 ,depthStr);
				child = child.next;
			}

			return depthStr;
		}
	}

	private static class LinkedList<U> {
		LinkedListNode<U> start, end;
		int n;

		void add(U next) {
			if (n == 0) {
				start = end = new LinkedListNode<U>(next);
			} else {
				end.next = new LinkedListNode<U>(next);
				end = end.next;
			}
			n++;
		}
	}

	private static class LinkedListNode<U> {
		U value;
		LinkedListNode<U> next;

		public LinkedListNode(U value) {
			this.value = value;
		}

	}

}
