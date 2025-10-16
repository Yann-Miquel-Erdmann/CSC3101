package monsters_2;

public class Node {
    Node next;
    Monster monster;

    public static Node add(Node n, Monster m){

        Node n2 = new Node();
        n2.monster = m;
        n2.next = n;
        return n2;

    }

    public static Node del(Node n, Monster m) {
        if (n == null)
            return null;
        if (n.monster == m) {
            return n.next;
        }

        while (n.next != null && n.next.monster != m) {
            n = n.next;
        }

        if (n.next != null && n.next.monster == m) {
            n.next = n.next.next;
        }
        return n;
    }
    

    public static Monster get(Node n, int i) {
        
        for (int j = 0; j < i; j++) {
            if (n == null) {
                break;
            }
            n = n.next;
        }

        if (n == null) {
            return null;
        } else {
            return n.monster;
        }
    }


    public static void display(Node n) {

        while (n != null) {
            Monster.display(n.monster);
            n = n.next;
        }
    }





}
