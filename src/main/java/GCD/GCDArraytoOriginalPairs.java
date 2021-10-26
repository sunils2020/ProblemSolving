package GCD;

import java.util.*;

public class GCDArraytoOriginalPairs {
    public static void main(String[] args) {
        GCDArraytoOriginalPairs obj = new GCDArraytoOriginalPairs();
        System.out.println(obj.solve(Arrays.asList(708, 4, 1, 4, 1, 3, 1, 2, 4, 1, 4, 1, 2, 6, 1, 2, 1, 3, 6, 3, 1, 4, 1, 2, 1, 4, 904, 1, 1, 4, 1, 1, 2, 8, 1, 4, 1, 2, 2, 1, 2, 1, 1, 2, 1, 1, 8, 1, 2, 1, 1, 1, 865, 1, 1, 1, 1, 5, 5, 1, 1, 5, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 843, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 3, 3, 3, 1, 1, 1, 1, 1, 4, 4, 1, 1, 52, 1, 1, 2, 4, 1, 4, 1, 2, 2, 1, 2, 1, 1, 2, 1, 13, 4, 1, 2, 1, 1, 1, 1, 1, 1, 961, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 31, 1, 1, 1, 1, 1, 1, 1, 1, 787, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 5, 1, 2, 1, 1, 790, 10, 1, 2, 5, 2, 10, 1, 2, 1, 1, 2, 1, 1, 2, 1, 2, 1, 4, 8, 5, 1, 4, 1, 1, 10, 560, 1, 4, 5, 2, 10, 1, 2, 1, 1, 2, 1, 1, 8, 1, 2, 7, 1, 1, 1, 1, 1, 1, 1, 1, 1, 701, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 1, 1, 4, 1, 1, 2, 4, 1, 116, 1, 2, 2, 1, 2, 1, 1, 2, 1, 1, 4, 29, 2, 1, 1, 1, 5, 1, 1, 1, 1, 5, 5, 1, 1, 785, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 2, 1, 1, 2, 2, 1, 2, 1, 122, 2, 1, 2, 1, 1, 2, 1, 1, 2, 1, 2, 1, 6, 2, 5, 3, 2, 1, 1, 10, 10, 1, 2, 5, 2, 810, 1, 2, 1, 3, 6, 3, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 227, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 2, 1, 1, 2, 2, 1, 2, 1, 2, 2, 1, 242, 1, 1, 2, 1, 1, 2, 1, 2, 11, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 653, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 633, 3, 3, 1, 1, 1, 1, 1, 6, 2, 1, 3, 2, 1, 1, 2, 2, 1, 2, 1, 2, 6, 1, 2, 1, 3, 6, 3, 1, 2, 1, 2, 1, 3, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 3, 3, 993, 1, 1, 1, 1, 1, 1, 1, 1, 1, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 871, 1, 1, 1, 1, 1, 1, 4, 8, 1, 1, 4, 1, 1, 2, 8, 1, 4, 1, 2, 2, 1, 2, 1, 1, 2, 1, 1, 824, 1, 2, 1, 1, 1, 1, 1, 1, 31, 1, 1, 1, 1, 29, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 899, 1, 1, 2, 2, 1, 1, 2, 1, 1, 2, 2, 1, 2, 1, 2, 2, 1, 2, 1, 1, 2, 1, 1, 2, 1, 934, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 11, 1, 1, 1, 1, 1, 1, 1, 1, 77)));
    }
    //  Hint 1 : Lets reverse the question a bit . Find all GCD pairs using the numbers 2 , 8 , 10
    //  Possible pairs : 9 pairs in total   = n ^ p => 3 ^ 3 = 9
    //  1.  (2,2)    = 2
    //  2.  (8,8)    = 8
    //  3.  (10,10)  = 10
    //  4.  (2,8)    = 2
    //  5.  (8,2)    = 2
    //  6.  (2,10)   = 2
    //  7.  (10,2)   = 2
    //  8.  (8,10)   = 2
    //  9.  (10,8)   = 2

    //  Example 2 : Take values 1, 2
    //  All combinations becomes   (1,1)  (2,2)  (1,2) (2,1) - 4 pairs in total => n ^ p = 2 ^ 2 = 4
    //  Hint 2: Square root of the Array size would be the real list
    //  (1,2)   =   1
    //  (2,2)   =   2
    //  (1,2)   =   1
    //  (2,1)   =   1
    //
    //  Solution:
    //  Considering Example 2 Array
    //  1   2   1   1
    //  Sort:  1   1   1   2
    //
    //  create a inputList ArrayList variable to store all the combinations and duplicate Map
    //  * Beginning from Last  - take 2 -  Hence add to the inputList
    //  * Take the next number - 1   => Not in the list , add it to the inputList
    //  * Take GCD between 2 and 1 Also between 1 and 2, which will result in 1 and 1 -> add this to duplicate list
    //  * Take the 3rd number - 1 => Already in the duplicate list - remove 1 entry from map
    //  * Take the 4th number - 1 => Already in the duplicate list - remove 1 entry from map
    //  Now the final result = 1, 2

    public ArrayList<Integer> solve(List<Integer> list) {
        Collections.sort(list);
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> dummyNumberMap = new HashMap<>();
        for (int i=list.size()-1;i>-1;i--){
            int currentNumber = list.get(i);
            if (dummyNumberMap.containsKey(currentNumber)){
                int value = dummyNumberMap.get(currentNumber);
                if (value == 1) {
                    dummyNumberMap.remove(currentNumber);
                }
                else {
                    dummyNumberMap.put(currentNumber,value-1);
                }
                continue;
            }
            result.add(currentNumber);
            if (result.size()>1) {  // Maintaining the count of each duplicate GCD derived from the result
                for (int j=0; j < result.size(); j++){  // This may not be O(n2) because GCD is calculated only for the Square root of the input array
                    // For every incoming number we find the GCD pair
                    Integer pair =  gcd(result.get(j),currentNumber);
                    Integer pairReverse =  gcd(currentNumber,result.get(j));
                    dummyNumberMap.put(pair,dummyNumberMap.getOrDefault(pair,0)+1);
                    dummyNumberMap.put(pair,dummyNumberMap.getOrDefault(pairReverse,0)+1);
                }
            }
        }
        return result;
    }

    public int gcd(int A, int B) {
        if (A==0) return B;
        if (B==0) return A;
        if (A>B) return gcd(B,A%B);
        else return gcd(A,B%A);
    }
}
