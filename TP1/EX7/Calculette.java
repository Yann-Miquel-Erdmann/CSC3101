package EX7;

public class Calculette {
    public static void main(String[] args) {
        // for (int i = 0; i< args.length; i++){
        //     System.out.println(args[i]);
        // }

        int[] tab = new int[args.length];

        // for (int i = 0; i<args.length; i++){
        //     System.out.println(tab[i]);
        // }

        for (int i = 0; i<args.length; i++){
            tab[i] = Integer.parseInt(args[i]);
        }

        int res = 0;
        for (int i = 0; i<args.length; i++){
            res+=tab[i];
        }
        System.out.println("La somme des paramètres est: " + res);
    }
}
