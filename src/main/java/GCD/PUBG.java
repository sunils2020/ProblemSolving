package GCD;

import java.util.Arrays;
import java.util.List;

public class PUBG {
    public static void main(String[] args) {
        PUBG obj = new PUBG();
        System.out.println(obj.solve(Arrays.asList(6, 4)));
    }

    //  Health between two player
    //  (6,4) => Take the highest common factor =>  2
    //  Continue to do until the last number
    public int solve(List<Integer> A) {
        int computedGcd = gcd(0,A.get(0));
        for(int i=1;i<A.size();i++){
            computedGcd = gcd(computedGcd,A.get(i));
        }
        return computedGcd;
    }

    //  Efficient way to compute GCD(a,b) ==> (a>b) ==> GCD(a,a%b)
    public int gcd(int A, int B) {
        if (A==0) return B;
        if (B==0) return A;
        if (A>B) return gcd(B,A%B);
        else return gcd(A,B%A);
    }
}