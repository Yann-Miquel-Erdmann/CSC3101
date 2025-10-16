package EX11;

import java.util.Random;

public class MergeSort {
    static void display(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
    }

    static int[] right(int[] tab) {
        int[] t = new int[tab.length - 1];
        for (int i = 1; i < tab.length; i++) {
            t[i - 1] = tab[i];
        }
        return t;
    }

    static int[] merge(int val, int[] tab) {
        int[] t = new int[tab.length + 1];
        t[0] = val;
        for (int i = 0; i < tab.length; i++) {
            t[i + 1] = tab[i];
        }
        return t;
    }

    static int[] merge(int[] t1, int[] t2) {
        if (t1.length == 0)
            return t2;
        if (t2.length == 0)
            return t1;
        if (t1[0] <= t2[0]) {
            return merge(t1[0], merge(right(t1), t2));
        } else {
            return merge(t2[0], merge(t1, right(t2)));
        }
    }

    static int[] mergeOpti(int[] t1, int[] t2) {
        int[] t = new int[t1.length + t2.length];
        int i = 0, j = 0;
        for (int k = 0; k < t.length; k++) {
            if (i < t1.length) {
                if (j < t2.length) {
                    if (t1[i] <= t2[j]) {
                        t[k] = t1[i];
                        i++;
                    } else {
                        t[k] = t2[j];
                        j++;
                    }
                } else {
                    t[k] = t1[i];
                    i++;
                }
            } else {
                t[k] = t2[j];
                j++;
            }
        }
        return t;
    }

    static int[] extract(int[] tab, int start, int end) {
        if (end <= start) {
            System.err.println("end > start: " + end + start);
            System.exit(1);
        }
        int[] t = new int[end - start];
        for (int i = start; i < end; i++) {
            t[i - start] = tab[i];
        }
        return t;
    }

    static int[] mergeSort(int[] tab) {
        if (tab.length <= 1)
            return tab;
        return mergeOpti(mergeSort(extract(tab, 0, tab.length / 2)),
                mergeSort(extract(tab, tab.length / 2, tab.length)));
    }

    static void evaluatePerformance(int nElements, int nExperiments) {
        int[] t = new int[nElements];
        Random rand = new Random();
        long t0 = System.nanoTime();
        for (int i = 0; i < nExperiments; i++) {
            for (int j = 0; j < nElements; j++) {
                t[j] = rand.nextInt();

            }
            mergeSort(t);
        }
        long t1 = System.nanoTime();
        double elapsedMs = (t1 - t0) * 1E-6;
        System.out.println("Trier des tableaux de " + nElements + " éléments aléatoires " + nExperiments
                + " fois a pris " + elapsedMs + " Ms");
    }

    public static void main(String[] args) {
        int[] tab = { 4, 7, 3, 9, 1, 2, 5 };
        display(extract(tab, 0, tab.length / 2));
        display(mergeSort(tab));

        evaluatePerformance(10000, 1000);
    }
}
