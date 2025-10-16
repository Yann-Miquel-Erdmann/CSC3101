package EX5;

public class Node {
    Node next;
    int val;

    public static Node add(Node n, int i) {

        Node n2 = new Node();
        n2.val = i;
        n2.next = n;
        return n2;

    }

    public static Node del(Node n, int i) {
        if (n == null)
            return null;
        if (n.val == i) {
            return n.next;
        }

        while (n.next != null && n.next.val != i) {
            n = n.next;
        }

        if (n.next != null && n.next.val == i) {
            n.next = n.next.next;
        }
        return n;
    }

    public static int get(Node n, int i) {

        for (int j = 0; j < i; j++) {
            if (n == null) {
                break;
            }
            n = n.next;
        }

        if (n == null) {
            return Integer.MIN_VALUE;
        } else {
            return n.val;
        }
    }

    public static void display(Node n) {

        while (n != null) {
            if (n.next != null) {
                System.out.print(n.val + " -> ");
            } else {
                System.out.println(n.val);
            }
            n = n.next;
        }
    }

    public static Node toNode(int[] intList) {
        Node n = null;
        for (int i = intList.length - 1; i >= 0; i--) {
            n = add(n, intList[i]);
        }
        return n;
    }

    public static Node reverse(Node n) {
        Node res = null;
        while (n != null) {
            res = add(res, n.val);
            n = n.next;
        }
        return res;
    }

    public static Node delDouble(Node n) {
        Node res = n;
        while (n != null) {
            if (n.next != null && n.val == n.next.val) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
        return res;
    }

    public static Node sum(Node n1, Node n2) {
        Node res = null;
        int carry = 0;
        while (n1 != null || n2 != null) {
            int v1;
            int v2;
            if (n1 == null) {
                v1 = 0;
            } else {
                v1 = n1.val;
            }

            if (n2 == null) {
                v2 = 0;
            } else {
                v2 = n2.val;
            }

            res = add(res, (v1 + v2 + carry) % 10);
            carry = (v1 + v2 + carry) / 10;
            if (n1 != null) {
                n1 = n1.next;
            }
            if (n2 != null) {
                n2 = n2.next;

            }
        }

        return reverse(res);

    }

    public static Node getMiddleNode(Node nodeFrom, Node nodeTo) {
        Node cursor = nodeFrom;
        Node mid = nodeFrom;
        while (cursor != nodeTo && cursor.next != nodeTo) {
            cursor = cursor.next.next;
            mid = mid.next;
        }

        return mid;

    }

    public static Node getLastNode(Node n) {
        while (n.next != null) {
            n = n.next;
        }
        return n;
    }

    public static Node merge(Node n1, Node n2) {
        Node res = null;

        while (n1 != null || n2 != null) {
            if (n1 == null) {
                res = add(res, n2.val);
                n2 = n2.next;
                continue;
            }
            if (n2 == null) {
                res = add(res, n1.val);
                n1 = n1.next;
                continue;
            }

            if (n1.val > n2.val) {
                res = add(res, n1.val);
                n1 = n1.next;
            } else {
                res = add(res, n2.val);
                n2 = n2.next;
            }

        }
        return reverse(res);
    }

    public static Node mergeSortAux(Node start, Node end) {
        if (end == start) {
            return null;
        }

        if (start != null && start.next == end) {
            Node n = null;
            return add(n, start.val);

        }

        Node middle = Node.getMiddleNode(start, end);
        Node left = Node.mergeSortAux(start, middle);
        Node right = Node.mergeSortAux(middle, end);

        return merge(left, right);
    }

    public static Node mergeSort(Node n) {
        Node end = getLastNode(n);
        return reverse(mergeSortAux(n, end));
    }

}
