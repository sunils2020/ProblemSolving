package PrimeNumbers;

import java.util.ArrayList;
import java.util.Arrays;

public class GeneratePrimeNumbersUptoX {
    public static void main(String[] args) {
        GeneratePrimeNumbersUptoX obj = new GeneratePrimeNumbersUptoX();
        System.out.println(obj.getAllPrimeNumbers(100).toString());
    }

    //  Generate all prime numbers
    //                                      2   3   4   5   6   7   8   9   10
    //  => Set all values to 0  =>          1   1   1   1   1   1   1   1   1
    //  => From 2 - multiples of 2 mark 0   1   1   0   1   0   1   0   1   0
    //  Multiples of 3                      1   1   0   1   0   1   0   0   0
    //   4                                  1   1   0   5   0   1   0   0   0
    //   5
    //  Continue to do till end of the array
    //  Array value which retains 1 are the list of prime numbers at the end
    //

    public ArrayList<Integer> getAllPrimeNumbers(int number){
        ArrayList<Integer> result = new ArrayList<>();
        int[] arrays = new int[number];
        for (int i=2;i<number;i++){
            arrays[i] = 1;
        }
        for (int i=2;i<number;i++) {
            int dividingFactor = i;
            if (arrays[dividingFactor]==0) continue;    // If it is not a prime then the loop will not happen
            // which means the time complexity is N/2 + N/3 + N/5 + ... all primes  ==> ( N * Log (Log n))
            for (int j = i * 2; j < arrays.length; j = j + i) {
                arrays[j] = 0;
            }
            result.add(dividingFactor);
        }
        return result;
    }
}
