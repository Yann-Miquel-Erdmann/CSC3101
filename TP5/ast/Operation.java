package TP5.ast;

public abstract class Operation implements Node {
    private Node[] ops;
    
    public Node op(int i){
        return ops[i]; 
    }

    public int nbOps(){
        return ops.length;
    }

    public Operation(Node... ops){
        this.ops = ops;
    }

    public abstract String opString();

    @Override
    public String toString() {
        String res = "(" + opString() ;
        for (int i = 0; i< nbOps(); i++){
            res += " " + op(i);
        };

        return res + ")";
    }
}
