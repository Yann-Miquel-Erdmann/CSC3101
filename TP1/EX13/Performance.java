package EX13;
import java.util.Random;;


public class Performance {
    static void evaluatePerformance(int nElements, int nExperiments){
        double[] t = new double[nElements];
        Random rand = new Random();
        long t0 = System.nanoTime();
        for (int i = 0; i< nExperiments; i++){
            for (int j = 0; j< nElements; j++){
                t[j] = rand.nextDouble();
                
            }
        }
        long t1 = System.nanoTime();
        double elapsedMs = (t1 - t0) * 1E-6;
        System.out.println("Trier des tableaux de "+nElements + " éléments aléatoires " + nExperiments + " fois a pris " + elapsedMs + " Ms"); 
    }
    
    public static void main(String[] args) {
        
    }    
}
