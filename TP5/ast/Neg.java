package TP5.ast;

public class Neg extends Operation {

    Neg(Node n) {
        super(n);
    }

    @Override
    public int execute() {
        if (nbOps() != 1) {
            System.out.println("il le nombre d'opérandes n'es pas valide dans Neg");
            System.exit(1);
        }
        return - op(0).execute() ;
    }

    @Override
    public String opString() {
        return "-";
    }

}