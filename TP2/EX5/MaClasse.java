package EX5;

public class MaClasse {
    public static void main(String[] args) {
        Node n = null;
        for (int i = 0; i < 4; i++) {
            n = Node.add(n, i);
        }

        Node.display(n);
        int[] intList = { 5, 7, 10, 12, 20 };
        n = Node.toNode(intList);
        Node.display(n);

        Node nRev = Node.reverse(n);
        Node.display(nRev);

        int[] vals = { 0, 0, 1, 2, 2, 3, 4, 4 };
        Node nDouble = Node.toNode(vals);
        Node.display(nDouble);
        Node nWithoutDouble = Node.delDouble(nDouble);
        Node.display(nWithoutDouble);

        int[] v1 = {3,2,1};
        int[] v2 = {2,1};

        Node n1 = Node.toNode(v1);
        Node n2 = Node.toNode(v2);
        Node res = Node.sum(n1, n2);
        Node.display(res);


        Node first = Node.toNode(vals);
        Node last = first.next.next.next.next.next.next.next;
        Node middleNode = Node.getMiddleNode(first, last);
        System.out.println(middleNode.val);


        first = nWithoutDouble;
        last = first.next.next.next.next;
        middleNode = Node.getMiddleNode(first, last);
        System.out.println(middleNode.val);

        first = nWithoutDouble;
        last = first;
        middleNode = Node.getMiddleNode(first, last);
        System.out.println(middleNode.val);

        first = nWithoutDouble;
        last = first.next.next.next;
        middleNode = Node.getMiddleNode(first, last);
        System.out.println(middleNode.val);



        int[] list = {9,3,7,2,4,1,7};
        Node l = Node.toNode(list);
        Node sorted = Node.mergeSort(l);
        Node.display(sorted);




    }
}


