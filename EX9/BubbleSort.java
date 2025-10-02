package EX9;

import java.util.Random;

public class BubbleSort {

    static void swap(int i, int j, double[] tab) {
        double t = tab[i];
        tab[i] = tab[j];
        tab[j] = t;
    }

    static void sort(double[] tab) {
        for (int i = tab.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (tab[j] > tab[j + 1]) {
                    swap(j, j + 1, tab);
                }
            }

        }
    }

    static void evaluatePerformance(int nElements, int nExperiments) {
        double[] t = new double[nElements];
        Random rand = new Random();
        long t0 = System.nanoTime();
        for (int i = 0; i < nExperiments; i++) {
            for (int j = 0; j < nElements; j++) {
                t[j] = rand.nextDouble();

            }
            sort(t);
        }
        long t1 = System.nanoTime();
        double elapsedMs = (t1 - t0) * 1E-6;
        System.out.println("Trier des tableaux de " + nElements + " éléments aléatoires " + nExperiments
                + " fois a pris " + elapsedMs + " Ms");
    }

    public static void main(String[] args) {
        double[] tab = { 2.3, 17.0, 3.14, 8.83, 7.26 };
        sort(tab);
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + ", ");
        }
        System.out.println();
        
        evaluatePerformance(1000, 1000);
    }
}
