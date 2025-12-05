package TP5.ast;

public class Scalar implements Node {
    protected int value;


    Scalar(int v){
        value = v;
    }

    public int get(){
        return value;
    }

    @Override
    public String toString(){
        return Integer.toString(value);
    }

    
    public int execute(){
        return get();
    }

}
