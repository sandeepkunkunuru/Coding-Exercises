package me.tingri.problemsolving;

import me.tingri.problemsolving.datastructures.Node;

public class FindNthToLastInLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> head = new Node<Integer>(2);
		
		head.addNodeToTail(3);
		head.addNodeToTail(4);
		head.addNodeToTail(5);
		head.addNodeToTail(6);
		head.addNodeToTail(7);
		head.addNodeToTail(8);
		
		printNthToLast(head,1);
		printNthToLast(head,2);
		printNthToLast(head,3);
		printNthToLast(head,4);
		printNthToLast(head,5);
		printNthToLast(head,6);
		printNthToLast(head,7);
		
	}

	private static void printNthToLast(Node<Integer> head, int n) {
		Node<Integer> temp = head;
		Node<Integer> nthToLast = null;
		int count = 0;
		while(temp != null){
			count++;
			
			if(count == n){
				nthToLast = head;
			} else if (count > n){
				nthToLast = nthToLast.next();
			}
			
			temp = temp.next();
		}
		
		if(nthToLast != null){
			System.out.println(nthToLast.value());
		}
	}
}
