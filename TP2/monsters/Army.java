package monsters;

public class Army {
    Monster[] monsters;
    int top;

    public static Army create() {
        Army a = new Army();
        a.monsters = new Monster[4];
        a.top = 0;
        return a;
    }

    public static void addMonster(Army a, Monster m) {
        while (a.top >= a.monsters.length) {
            Monster[] newMonsters = new Monster[a.monsters.length * 2];
            for (int i = 0; i < a.monsters.length; i++) {
                newMonsters[i] = a.monsters[i];
            }
            a.monsters = newMonsters;
        }

        a.monsters[a.top] = m;
        a.top++;
    }

    public static void display(Army a) {
        for (int i = 0; i < a.top; i++) {
            Monster.display(a.monsters[i]);
        }
    }
}
