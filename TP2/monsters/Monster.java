package monsters;

public class Monster {
    String name;
    int health;

    public static void display(Monster m) {
        System.out.println("Monster<" + m.name + ">");
    }

}
