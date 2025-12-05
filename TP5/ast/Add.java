package TP5.ast;

public class Add extends Operation {

    Add(Node l, Node r) {
        super(l,r);
    }

    @Override
    public int execute() {
        if (nbOps() != 2 ){
            System.out.println("il le nombre d'opérandes n'es pas valide dans Add");
            System.exit(1);
        }
        return op(0).execute() + op(1).execute();
    }

    @Override
    public String opString(){
        return "+";
    }

   
}
