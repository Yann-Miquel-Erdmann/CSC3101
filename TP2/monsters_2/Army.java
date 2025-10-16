package monsters_2;

public class Army {
    Node first;

    public static Army create() {
        Army a = new Army();
        a.first = null;
        return a;
    }

    public static void addMonster(Army a, Monster m){
        a.first = Node.add(a.first, m);
    }


    public static void delMonster(Army a, Monster m) {
        a.first = Node.del(a.first, m);
    }

    public static Monster getMonster(Army a, int i) {
        return Node.get(a.first, i);
    }

    public static void display(Army a) {
        Node.display(a.first);
    }
}
