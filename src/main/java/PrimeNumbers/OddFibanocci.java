package PrimeNumbers;

import java.util.HashMap;

public class OddFibanocci {
    public static void main(String[] args) {
        OddFibanocci obj = new OddFibanocci();
        System.out.println(obj.solve2(30,36));
    }
    //  Fibonacci sequence is a sequence whose definition is as follows:
    //  F[1] = 1 , F[2] = 1
    //  F[i] = F[i-1] + F[i-2] for i > 2
    //
    //  Per Problem, when values are 1 and 2 fibanocci is odd (i.e) 1
    //  For other numbers > 2, it lies in this equation F[i-1] + F[i-2]
    //  Example:
    //  F(2) = 1
    //  F(3) = F(2) + F (1) = 1 + 1 = 2
    //  F(4) = F(3) + F (2) = 2 + 1 = 3
    //  F(5) = F(4) + F (3) = 3 + 2 = 5
    //  F(6) = F(5) + F (4) = 5 + 3 = 8
    //
    //  Achieve the same in recursive way. XXX - Recursion will be a problem when there is a large gap of numbers
    //  Recursion : Write a recursion equation
    //  F(N) = F(N-1) + F(N-2);
    //  Edge cases , if N is <= 2 then answer is 1

    // The above solution will not work because of the huge number

    // X    --      Observe the pattern             --  XX  //
    //  Fibanocci of first 10 numbers
    //  1   1   2   3   5   8   13  21  34  55  89  144 ==> Fibanocci
    //  O   O   E   O   O   E   O   O   E   O   O   E   ==> Odd/Even
    //  1   2   3   4   5   6   7   8   9   10  11  12  ==> N Numbers
    //
    //  Total number of even possibilities = 12/3 = 4 is the answer for the above list, Hence odd numbers => 12 - 4 = 8
    //  Suppose one is asking for the range between  9 and 12
    //  Find out the numbers for the entire range and subtract the remaining range
    //  Overall result of evens = 12/3 = 4
    //  (A -1) /3 = remaining evens = 8/3 = 2
    //  Range of evens = overall evens - remaining evens    => 4 - 2 = 2
    //
    public int solve2(int A, int B) {
        //  Find out the total number of evens possible
        int totalEvens = B/3;
        int remainingEvens = (A - 1)/3;
        int resultantEvens = totalEvens - remainingEvens;
        int range = B - A + 1;
        int rangeOdds = range - resultantEvens;
        return rangeOdds;
    }



    public int solve(int A, int B) {
        HashMap<Long,Long> fibMap = new HashMap<>();
        long count = 0;
        fibMap.put(1L,1L);
        fibMap.put(2L,1L);
        for(long i=3;i<=B;i++){  // Find out all the previous Fib from 3 till A and store in Map
            long temp = fibMap.get(i-2)%1000000007 + fibMap.get(i-1)%1000000007;
            fibMap.put(i,temp%1000000007);
        }
        for(long i=A;i<=B;i++){
            if (fibMap.containsKey(i)){
                long current = fibMap.get(i);
                if (current%2!=0)   count++;
            }
            else {
                long temp = (i%1000000007 + fibMap.get(i-1)%1000000007)%1000000007;
                if (temp%2 != 0) count++;
                fibMap.put(i,temp%1000000007);
            }
        }
        return (int)count;
    }

    // Recursion - Stack overflow for very big numbers
    public int oddFibanocii(int number) {
        if(number<=2) return 1;
        int result =  oddFibanocii(number-1) + oddFibanocii(number-2);
        return result;
    }

}
