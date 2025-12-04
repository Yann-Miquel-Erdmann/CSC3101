package TP3.bank;

public class IronBank {

    public static void main(String[] var0) {
        Bank b = Bank.create();

        b.lookupOrCreate("Tyrion");
        b.lookupOrCreate("Jaime");
        b.lookupOrCreate("Cersei");
        b.lookupOrCreate("Tywin");
        b.lookupOrCreate("Kevan");
        b.lookupOrCreate("Lancel");
        b.lookupOrCreate("Alton");
        b.lookupOrCreate("Martyn");
        b.lookupOrCreate("Willem");

        b.display();
    }


}
