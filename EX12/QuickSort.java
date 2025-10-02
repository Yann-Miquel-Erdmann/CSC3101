package EX12;

import java.util.Random;

public class QuickSort {
    static void swap(int[] tab, int i, int j) {
        int t = tab[i];
        tab[i] = tab[j];
        tab[j] = t;
    }

    static void display(int[] t) {
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i] + " ");
        }
        System.out.println();
    }

    static int partition(int[] t, int start, int end) {
        int fin = start;
        for (int i = start; i < end; i++) {
            if (t[i] < t[end]) {
                swap(t, i, fin);
                fin++;
            }
        }
        swap(t, end, fin);
        return fin;
    }

    static void quickSort(int[] t, int start, int end) {
        if (start < end) {
            int p = partition(t, start, end);
            quickSort(t, start, p - 1);
            quickSort(t, p + 1, end);
        }
    }

    static void evaluatePerformance(int nElements, int nExperiments) {
        int[] t = new int[nElements];
        Random rand = new Random();
        long t0 = System.nanoTime();
        for (int i = 0; i < nExperiments; i++) {
            for (int j = 0; j < nElements; j++) {
                t[j] = rand.nextInt();

            }
            quickSort(t, 0, nElements - 1);
        }
        long t1 = System.nanoTime();
        double elapsedMs = (t1 - t0) * 1E-6;
        System.out.println("Trier des tableaux de " + nElements + " éléments aléatoires " + nExperiments
                + " fois a pris " + elapsedMs + " Ms");
    }

    public static void main(String[] args) {
        int[] tab = { 4, 7, 3, 9, 1, 2, 5 };
        quickSort(tab, 0, tab.length - 1);
        display(tab);
        evaluatePerformance(10000, 1000);
    }
}
