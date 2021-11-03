package PrimeNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FactorialArray {
    public static void main(String[] args) {
        FactorialArray obj = new FactorialArray();
        System.out.println(obj.solve(Arrays.asList(251, 923, 561, 230, 100, 399, 542, 198, 548, 892, 721, 781, 174, 809, 9, 232, 165, 861, 36, 837, 377, 313, 475, 269, 210, 530, 940, 570, 24, 434, 764, 275, 709, 325, 505, 161, 724, 47, 359, 625, 291, 81, 406, 465, 242, 767, 698, 408, 629, 86, 597, 358, 399, 72, 979, 962, 603, 919, 884, 627, 353, 1, 254, 414, 678, 111, 575, 755, 511, 287, 380, 802, 720, 138, 620, 314, 905, 670, 74, 886, 756, 671, 244, 508, 744, 224, 822, 347, 495, 706, 326, 201, 707, 580, 615, 386, 43, 543, 141, 554)));
    }
    //  Hint : Find the numbers which falls between the prime numbers
    //  Example: 8, 9, 10 --> 3 numbers exists between 7 and 11 prime numbers
    //  Now take 2^3 - With 3 numbers number of subsequences which can be formed
    //  (8,9) (9,10) (8,10) (8) (9) (10) (8,9,10) ()    - 8 possibilities
    //  However, per question empty subsequence should be eliminated. Hence 2^3 - 1 = Results in 7

    public int solve(List<Integer> inputList) {
        int combinations = 0;
        // Find all the prime numbers from 1 till 1000000
        int[] prime = new int[1000005];
        for (int i = 2; i < 1000005; i++) {
            prime[i] = 1;
        }
        ArrayList<Integer> primeList = new ArrayList<>();

        // Technique to find the number of prime numbers using sieve theorum
        // Mark the factors - First multiples of 2 and then multiples of 3 and so on
        for (int i = 2; i < 1000005; i++) {
            int dividingFactor = i;
            // For ex: In first iteration 4 is set to 0 , hence no need calculate for all the factors of 4
            if (prime[dividingFactor] == 0) continue;    // If it is not a prime then the loop will not happen
            primeList.add(i);   // Store the prime numbers while computing prime numbers
            // which means the time complexity is N/2 + N/3 + N/5 + ... all primes  ==> ( N * Log (Log n))
            for (int j = i * 2; j < prime.length; j = j + i) {
                prime[j] = 0;
            }
        }
        Collections.sort(inputList);

        // From the given input , find the numbers which lie between prime numbers
        for (int i = 1,j=0; i < primeList.size(); i++) {
            int total = 0;
            while (j < inputList.size()) {
                if (inputList.get(j)<=1) {
                    j++;
                    break;
                }
                // Check if the given number is between 2 prime numbers, if not break - move to the next prime range
                if (inputList.get(j) >= primeList.get(i - 1) && inputList.get(j) < primeList.get(i)) {
                    total++; // if Prime exists, increment the total number of numbers in the range
                    j++;
                    continue;
                } else {
                    break;
                }
            }
            // Using Fermat's little theorum
            int possibilities = (power(2, total, 1000000007)) % 1000000007;
            combinations = combinations + (possibilities - 1);
            total = 0;
            if (j==inputList.size()) break;
        }
        return combinations;
    }
    int power(long a,long b,int modulo){
        long result = 1;
        if (b==0) return 1;
        else if (b%2==0){
            result = power((a*a)%modulo,b/2,modulo)%modulo;
        }
        else {
            result = (a * power((a*a)%modulo,(b-1)/2,modulo))%modulo;
        }
        return (int)result%modulo;
    }
}

