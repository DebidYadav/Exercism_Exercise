import java.util.*;
public class PythagoreanTriplet {
    
    private final int a;
    private final int b;
    private final int c;
    
    private PythagoreanTriplet() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }
    public PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public static PythagoreanTripletBuilder makeTripletsList() {
        return new PythagoreanTriplet().createBuilder();
    }
    
    private PythagoreanTripletBuilder createBuilder() {
        return new PythagoreanTripletBuilder();
    }
    public class PythagoreanTripletBuilder {
        private final List<PythagoreanTriplet> triplets = new ArrayList<>();
        private int max = Integer.MAX_VALUE;
        private int sum = 0;
        
        public PythagoreanTripletBuilder withFactorsLessThanOrEqualTo(int maximumFactor) {
            max = maximumFactor;
            return this;
        }
        public PythagoreanTripletBuilder thatSumTo(int expectedSum) {
            sum = expectedSum;
            return this;
        }
        public List<PythagoreanTriplet> build() {
            max = Math.min(max, sum / 2);
            for (int c = 3; c <= max; c++) {
                if (c > sum) break;
                int cSquare = c * c;
                for (int b = 2; b < c; b++) {
                    if ((b + c) > sum) break;
                    int bSquare = b * b;
                    int a = sum - b - c;
                    int aSquare = a * a;
                    if (a < b && (aSquare + bSquare) == cSquare) {
                        triplets.add(0, new PythagoreanTriplet(a, b, c));
                    }
                }
            }
        
            return triplets;
        }
    }

    public String toString() {
        return String.format("(%d, %d, %d)", a, b, c);
    }
    
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
    
    public boolean equals(Object obj) {
        if (obj instanceof PythagoreanTriplet other)
            return a == other.a && b == other.b && c == other.c;
        
        return false;
    }
}