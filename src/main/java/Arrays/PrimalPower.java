package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// Finding the prime number - Divide the factors upto square root of N


public class PrimalPower {

    public static void main(String[] args) {
        PrimalPower obj = new PrimalPower();
        System.out.println(obj.solve(Arrays.asList(97, 43, 29, 11, 100, 47, 76, 83, 37, 19, 17, 19, 71, 0, 1, -82, 2, -83, 37, 13, 5, 97, 17, 30, 31, 48, 2, 19, 31, 91, 19, 2, 5, 89, 2, 67, 31, 47, 43, 31, 5, 17, 83, 11, 47, 73, 19, 3, 3, 19, 59, 91, 67, 7, 43, 4, 3, 51, 52, 23, 3, 37, 53, 89, 9, 41, 19, 61, 7, 5, 53, 59, 19, 11, 79, 37, 31, 37, 73, 82, 41, 2, 13, 8, 2, 36, 19, 58, 17, 17, 59, 59, 37, 11, 13, 37, 47, 83, 31, 3)));
    }

    public int solve(List<Integer> A) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i=0;i<A.size();i++){
            int currentNumber = A.get(i);
            if (currentNumber<2) continue;
            if (set.contains(currentNumber)) {
                count++;
                continue;
            }
            int sqrt = (int)Math.sqrt(currentNumber);
            boolean isPrime = true;
            for(int j=2;j<=sqrt;j++){
                if (currentNumber%j ==0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                set.add(currentNumber);
                count++;
            }
        }
        return count;
    }


}
