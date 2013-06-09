package kunkunur.org.problemsolving.datastructures;

public class LinkedList {
	private Node start;
	private Node end;

	public LinkedList(int value) {
		Node node = new Node(value);
		start = end = node;
	}

	public LinkedList add(int value) {
		Node node = new Node(value);
		end.setNext(node);
		node.setPrevious(end);

		end = node;

		return this;
	}

	public int remove() throws Exception {
		if (end.getNext() == null) {
			throw new Exception("There is only one node to remove");
		}
		Node previous = end.getPrevious();
		Node removedNode = previous.removeNext();

		end = previous;
		return removedNode.getValue();
	}

	public void removeDuplicates() { // 2---> 5 ---> 3 ---> 2 ---> 3 ---> 5
		if (start == end) {
			return;
		}

		Node currentNode = start;
		Node nodeToCompare = currentNode.getNext();

		while (nodeToCompare != null) {
			boolean isSame = currentNode.hasSameValue(nodeToCompare);

			if (isSame) { // 2 ---> 2
				Node tempPrevious = nodeToCompare.getPrevious();
				Node tempNext = nodeToCompare.getNext();

				tempPrevious.removeNext();

				nodeToCompare = tempNext;
			} else {
				nodeToCompare = nodeToCompare.getNext();
			}
			
			if (nodeToCompare == null) {
				currentNode = currentNode.getNext();

				if (currentNode != null) {
					nodeToCompare = currentNode.getNext();
				}
			}

		}

	}

	public void print() {
		System.out.println("----------");

		Node node = start;
		while (node != null) {
			System.out.println(node.getValue());
			node = node.getNext();
		}

		System.out.println("----------");
	}

	private class Node {
		private int value;
		private Node next;
		private Node previous;

		public Node(int val) {
			setValue(val);
		}

		public void setValue(int val) {
			value = val;
		}

		public int getValue() {
			return value;
		}

		public void setNext(Node nextNode) {
			next = nextNode;
		}

		public Node getNext() {
			return next;
		}

		public void setPrevious(Node prevNode) {
			previous = prevNode;
		}

		public Node getPrevious() {
			return previous;
		}

		public boolean hasSameValue(Node b) {

			return b == null ? false : value == b.getValue();
		}

		public Node removeNext() {
			Node nextNode = next;

			if (nextNode != null) {
				Node nextNext = nextNode.getNext();
				setNext(nextNext);

				if (nextNext != null) {
					nextNext.setPrevious(this);
				}

				nextNode.setPrevious(null);
				nextNode.setNext(null);

				return nextNode;
			} else {
				return null; // there isnt any next Node;
			}
		}

	}
}
