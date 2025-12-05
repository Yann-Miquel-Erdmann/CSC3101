package TP5.ast;

public class Set extends Operation {
    
    public Set(Variable v, Node n) {
        super(v, n);
    }

    @Override
    public String opString(){
        return "set!";
    } 


    @Override
    public int execute() {
        if (nbOps() != 2 ){
            System.out.println("il le nombre d'opérandes n'es pas valide dans Set");
            System.exit(1);
        }

        if (! (op(0) instanceof Variable)){
            System.out.println("le premier opérande Set n'est pas un nom de variable");
            System.exit(1);
            return -1;
        }

        int val = op(1).execute();

        ((Variable) op(0)).set(val);

        return val;

    }

}
