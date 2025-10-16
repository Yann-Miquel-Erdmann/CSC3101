package EX6;
public class Pgcd {

    static int pgcd(int p, int q) {

        while ((p != 0) && (q != 0)) {

            if (p > q) {
                p -= q;
            }else{
                q -= p;
            }
        }
        if (p == 0) {
            return q;
        }
        if (q == 0) {
            return p;
        }
        return -1;
    }

    static int pgcd_opt(int p, int q) {
        while ((p != 0) && (q != 0)) {
            if (p >= q) {
                int t = p;
                p = q;
                q = t % q;
            }else{
                q -= p;
            }
        }
        if (p == 0) {
            return q;
        }
        if (q == 0) {
            return p;
        }
        return -1;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.exit(1);
        }
        System.out.println(args[0]);
        System.out.println(args[1]);

        int p, q;
        p = Integer.parseInt(args[0]);
        q = Integer.parseInt(args[1]);

        System.out.println("pgcd:" + pgcd(p, q));
        System.out.println("pgcd_opt:" + pgcd_opt(p, q));
    }
}
