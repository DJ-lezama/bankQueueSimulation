public class poissonRandom {
    public static int poissonRandom(double lambda) {
        int k = 0;
        double p = 1.0;
        double expLambda = Math.exp(-lambda);
        
        do {
            k++;
            p *= Math.random();
        } while (p >= expLambda);
        
        return k - 1;
    }
}
