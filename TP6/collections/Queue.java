package TP6.collections;

public class Queue<T> {
    private T val;
    private Queue<T> next;
    private Queue<T> prev;
    private boolean isEmpty;

    public Queue() {
        val = null;
        next = this;
        prev = this;
        isEmpty = true;
    }

    public Queue(T e) {
        val = e;
        next = this;
        prev = this;
        isEmpty = false;
    }

    public void append(T e) {
        if (isEmpty) {
            val = e;
            isEmpty = false;
            return;
        } else {

            next.prev = new Queue<>(val);
            next.prev.next = next;
            next = next.prev;
            next.prev = this;
            val = e;
            isEmpty = false;

        }
    }

    public T remove() {
        if (isEmpty) {
            return null;
        }

        if (this.next == this) {
            isEmpty = true;
            return val;
        } else {

            T res = this.prev.val;
            this.prev.prev.next = this;
            this.prev = this.prev.prev;
            return res;
        }

    }

}
