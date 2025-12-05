package TP5.ast;

public class Variable extends Scalar {
    private String name;

    public Variable(String name) {
        super(0);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void set(int value) {
        this.value = value;
    }

}
