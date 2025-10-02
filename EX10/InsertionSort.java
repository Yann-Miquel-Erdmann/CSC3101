package EX10;

import java.util.Random;

public record InsertionSort() {
    static double[] sort(double[] tab){
        double[] sorted = new double[tab.length];
        for (int i = 0; i< tab.length; i++){
            int j = i-1;
            while (j >= 0 && sorted[j] > tab[i]){
                sorted[j+1] = sorted[j];
                j--;
            }
            sorted[j+1] = tab[i];
        }
        return sorted;
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
        for (int i = 0; i<args.length; i++){
            System.out.println(args[i]);
        }

        double[] tab = new double[args.length];
        for (int i = 0; i< args.length; i++){
            tab[i] = Double.parseDouble(args[i]);
        }

        double[] sorted = sort(tab);

        for (int i = 0; i< args.length; i++){
            System.out.print(sorted[i] + ", ");
        }
        System.out.println();

        
        evaluatePerformance(1000, 1000);
    }
}
