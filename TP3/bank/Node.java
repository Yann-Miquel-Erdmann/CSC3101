package TP3.bank;

public class Node {
    Account etiquette;
    Node fg;
    Node fd;

    public static Node create() {
        return new Node();
    }

    public Account lookupOrCreate(String name) {

        if (this.etiquette == null) {
            this.etiquette = Account.create(name);
            this.fg = Node.create();
            this.fd = Node.create();
            return etiquette;
        }

        if (etiquette.compareTo(name) == 0) {
            return etiquette;
        }

        if (etiquette.compareTo(name) > 0) {
            return fg.lookupOrCreate(name);
        } else {
            return fd.lookupOrCreate(name);
        }
    }

    public void display(int tabs) {

        if (etiquette != null) {

            fg.display(tabs + 1);
            for (int i = 0; i < tabs; i++) {
                System.out.print("\t");
            }
            etiquette.display();
            fd.display(tabs + 1);
        }
    }

    public Boolean isLeaf() {
        return this.etiquette == null;
    }

    // returns the number of nodes of the tree
    public int size() {

        if (this.isLeaf()) {
            return 0;
        } else {
            return 1 + fg.size() + fd.size();
        }
    }

    public int height(){
        if (this.isLeaf()){
            return 0;
        } 
        return 1 + Math.max(fg.height(), fd.height());
    }

    // public Boolean isBalanced(){
    //     if this.
    // }

}
