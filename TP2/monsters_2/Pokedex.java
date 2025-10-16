package monsters_2;

public class Pokedex {

    public static void main(String[] args) {

        Army a = Army.create();
        for (int i = 0; i < 8; i++) {
            Monster aMonster = new Monster();
            aMonster.name = "Pikachu" + i;
            aMonster.health = 0;
            Army.addMonster(a, aMonster);
        }

        Army.display(a);
        Monster m5 = Army.getMonster(a, 5);
        Monster.display(m5);
        Army.display(a);
        Army.delMonster(a, m5);
        Army.display(a);

    }

}
