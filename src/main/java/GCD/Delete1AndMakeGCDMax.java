package GCD;
import java.util.Arrays;

public class Delete1AndMakeGCDMax {
    public static void main(String[] args) {
        Delete1AndMakeGCDMax obj = new Delete1AndMakeGCDMax();
        System.out.println(obj.solve(new int[]{ 21, 7, 3, 42, 63}));
    }

    //  Hint : if the index number is removed - Find out the GCD of the remaining and see if it is greater
    //  Instead of finding the GCD for every possible combination
    //  Take 2 GCD Array    - PrefixSum and SuffixSum (Reverse)
    //  Now when i is removed = Ex: i=1 is removed then perform gcd between prefix(i-1) and suffix(i+1)
    //  Based on this we can find the maximum GCD occurring

    public int solve(int[] arrays) {
        int[] prefixGCDArray = new int[arrays.length];
        int[] suffixGCDArray = new int[arrays.length];
        // Boundary cases
        prefixGCDArray[0] = arrays[0];
        suffixGCDArray[suffixGCDArray.length-1] = arrays[arrays.length-1];

        for(int i=1;i<arrays.length;i++)
            prefixGCDArray[i] = gcd(arrays[i],prefixGCDArray[i-1]);

        // Suffix GCD Array
        for(int i=arrays.length-2;i>-1;i--)
            suffixGCDArray[i] = gcd(arrays[i],suffixGCDArray[i+1]);

        int maxGCD = Integer.MIN_VALUE;int currentGCD;

        for(int i=0;i<arrays.length;i++){
            if (i==0) currentGCD = suffixGCDArray[i+1];
            else if (i==arrays.length -1) currentGCD = prefixGCDArray[i-1];
            else currentGCD = gcd(prefixGCDArray[i-1],suffixGCDArray[i+1]);
            maxGCD = Math.max(currentGCD,maxGCD);
        }
        return maxGCD;
    }

    public int gcd(int A, int B) {
        if (A==0) return B;
        if (B==0) return A;
        if (A>B) return gcd(B,A%B);
        else return gcd(A,B%A);
    }

}
