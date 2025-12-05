package TP6.collections;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue();
        q.append(1);
        q.append(2);
        System.out.println(q.remove());
        q.append(3);

        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());

        Stack<Integer> s = new Stack();
        s.append(1);
        s.append(2);
        System.out.println(s.remove());
        s.append(3);

        System.out.println(s.remove());
        System.out.println(s.remove());
        System.out.println(s.remove());

    }
}
