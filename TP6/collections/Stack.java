package TP6.collections;


public class Stack<T> {
    private T val;
    private Stack<T> next;
    private Stack<T> prev;
    private boolean isEmpty;

    public Stack() {
        val = null;
        next = this;
        prev = this;
        isEmpty = true;
    }

    public Stack(T e) {
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

            next.prev = new Stack<>(val);
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

            T res = val;
            val = this.next.val;
            this.next = this.next.next;
            this.next.prev = this;
            return res;
        }

    }

}
