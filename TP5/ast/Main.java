package TP5.ast;

public class Main {
    public static void main(String[] args) {
        Scalar un = new Scalar(1);
        System.out.println(un);
        System.out.println(un.execute());


        Scalar deux = new Scalar(2);

        Add un_plus_deux = new Add(un, deux);

        System.out.println(un_plus_deux);
        System.out.println(un_plus_deux.execute());

        Scalar trois = new Scalar(3);
        Scalar quatre = new Scalar(4);

        Add trois_plus_quatre = new Add(trois, quatre);

        Add total  = new Add(un_plus_deux,new Neg( trois_plus_quatre));

        System.out.println(total);
        System.out.println(total.execute());
        System.out.println(total);

        Variable x = new Variable("x");

        Set set = new Set(x, new Scalar(22));
        System.out.println(set);
        System.out.println(set.execute());

        Scalar vingt = new Scalar(20);
        Add x_plus_vingt = new Add(x, vingt);

        System.out.println(x_plus_vingt);
        System.out.println(x_plus_vingt.execute());


        Add echo_test = new Add( new Echo( un_plus_deux), new Scalar( 7));
        System.out.println(echo_test);
        System.out.println(echo_test.execute());


        


    }
}


