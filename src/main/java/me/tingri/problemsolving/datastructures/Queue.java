package me.tingri.problemsolving.datastructures;

public class Queue<T> {
    private QueueNode<T> first;
    private QueueNode<T> last;

    public Queue(T item) {
        first = new QueueNode<T>(item);
        last = first;
    }

    public void enqueue(T item) {
        QueueNode<T> newNode =  new QueueNode<T>(item);

        if (first == null) {
            last = first = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
    }

    public T dequeue() {
        QueueNode<T> currentFirst = first;

        if (first == null){
        	return null;
        } else if (last == first) {
            last = first = null;
        } else {
            first = currentFirst.getNext();
        }

        return currentFirst.getValue();
    }

    private class QueueNode<T> {
        private T value;
        private QueueNode<T> next;

        QueueNode(T val) {
            value = val;

        }

        QueueNode<T> getNext() {
            return next;
        }

        void setNext(QueueNode<T> next) {
            this.next = next;
        }

        T getValue() {
            return value;
        }
    }

}