package TP3.bank;

public class Bank {
    Node root;

    public static Bank create() {
        Bank b = new Bank();
        b.root = Node.create();
        return b;
    }

    public Account lookupOrCreate(String name) {
        if (root == null) {
            root = Node.create();
            root.etiquette = Account.create(name);
            return root.etiquette;
        }
        return root.lookupOrCreate(name);
    }


    public void display(){
        root.display(0);
    }
}
