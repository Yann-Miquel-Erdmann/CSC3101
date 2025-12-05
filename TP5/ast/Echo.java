package TP5.ast;

public class Echo extends Operation {

    public Echo(Node n){
        super(n);
    }

    @Override
    public String opString() {
        return "echo";
    }

    @Override
    public int execute() {
        if (nbOps() != 1) {
            System.out.println("il le nombre d'opérandes n'es pas valide dans Echo");
            System.exit(1);
        }

        int res = op(0).execute();
        System.out.println(res);
        return res;
    }
    
}
