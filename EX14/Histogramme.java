package EX14;

public class Histogramme {
    static void histogramme(int[] tab){
        int argMin = 0;
        int argMax = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[argMin] > tab[i]) {
                argMin = i;
            }
            if (tab[argMax] < tab[i]) {
                argMax = i;
            }
        }

        System.out.println(tab[argMin]);
        System.out.println(tab[argMax]);

        for (int i = tab[argMax]; i >= tab[argMin]; i--) {
            for (int j = 0; j < tab.length; j++) {
                if (i >= 0) {
                    if (i<=tab[j]) {
                        if (i == 0 && tab[j] != 0) {
                            System.out.print("+");

                        } else{
                            System.out.print("*");

                        }
                    } else {
                        if (i == 0) {
                            System.out.print("+");

                        } else {
                            System.out.print(" ");
                        }
                    }

                } else {
                    if ( i >=  tab[j]) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");

                    }
                }
            }
            System.out.println();
        }
    
    }
    public static void main(String[] args) {
        int[] tab = { -1, -3, 2, -2, 3, 0, 4, 2, -2, -1 };
        histogramme(tab);
    } 
}
