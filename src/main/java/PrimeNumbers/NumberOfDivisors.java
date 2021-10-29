package PrimeNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NumberOfDivisors {
    public static void main(String[] args) {
        NumberOfDivisors divisor = new NumberOfDivisors();
        System.out.println(Math.ceil(Math.sqrt(2)));
        System.out.println(divisor.solve(Arrays.asList(100, 9, 10)).toString());
    }

    //  Finding the number of factors is always 1 to Square root of n
    //  But, if the factor is a perfect square it will be odd - for example 16
    //  1   2   4   8   16
    //  1-16,   2-8 pair together . 4 pairs with itself, Hence for the place of 4 , count = 1
    public ArrayList<Integer> solve(List<Integer> arrayList) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<arrayList.size();i++){
            int number = arrayList.get(i);
            if (!map.containsKey(number)) {
                int factors = numOfFactors(number);
                result.add(factors);
                map.put(number,factors);
            } else {
                result.add(map.get(number));
            }
        }
        return result;
    }

    public int numOfFactors(int number){
        int count = 0;
        int sqrt = (int)Math.sqrt(number);
        for(int i=1;i<=sqrt;i++){
            if (i * i == number) {
                count++;
                continue;
            }
            if (number%i==0) count = count + 2;
        }
         return count;
    }
}
