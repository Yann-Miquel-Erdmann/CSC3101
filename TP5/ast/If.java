package TP5.ast;

public class If extends Operation {
    public If (Node condition, Node ifTrue, Node ifFalse){
        super(condition, ifTrue, ifFalse);
    }

    @Override
    public int execute() {
        if (nbOps() != 3 ){
            System.out.println("il le nombre d'opérandes n'es pas valide dans If");
            System.exit(1);
        }

        if (op(0).execute() != 0){
            return op(1).execute();
        } else {

            return op(2).execute();
        }

    }

    @Override
    public String opString() {
        return "if";
    }
}
