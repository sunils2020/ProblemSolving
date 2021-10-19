package Arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class Flip01findMax1s {
    public static void main(String[] args) {
        Flip01findMax1s obj = new Flip01findMax1s();
        System.out.println(obj.flip("01010110"));
        //System.out.println(obj.flip("111"));
    }
    public ArrayList<Integer> flip(String A) {
        // Flip 1s to -1 because 1 is not contributing to the answer
        // Flip 0s to 1 because 1 will contribute to the answer
        // Example:  0  1  0  is written as    1    -1     1
        // Kadane's algorithm           1       -1      1
        //  Sum till now - 0    ==>     1       0       1
        //  Large sum    - 0    ==>     1       1       1
        //  So the entire sub array is used to determine the largest sum
        HashMap<Integer,ArrayList<ArrayList<Integer>>> map = new HashMap<>();
        int array[] = new int[A.length()];
        for (int i=0;i<A.length();i++){
            if (A.charAt(i)=='1') array[i] = -1;
            else array[i] = 1;
        }
        int sumTillNow = 0; // Kadens algorithm trick
        int maxSum = 0;
        int start =0;
        for(int i=0;i<array.length;i++){
            sumTillNow = sumTillNow + array[i];
            maxSum = Math.max(maxSum,sumTillNow);
            if (sumTillNow<0){  // Change the index to the next element when the sum is less than 0
                start = i+1;
                sumTillNow = 0;
            } else{
                ArrayList<ArrayList<Integer>> tempArray = new ArrayList<>();
                ArrayList<Integer> indexes = new ArrayList<>();
                indexes.add(start+1);   // Per problem index position is 1 rather than 0
                indexes.add(i+1);
                tempArray.add(indexes);
                if (!map.containsKey(sumTillNow))
                    map.put(sumTillNow,tempArray);
                else {
                    ArrayList<ArrayList<Integer>> existingArray = map.get(sumTillNow);
                    existingArray.add(indexes);
                    map.replace(sumTillNow,existingArray);
                }
            }
        }
        ArrayList<ArrayList<Integer>> existingArray = map.get(maxSum);
        if (existingArray==null) return new ArrayList<Integer>();
        // Sort to pick the lexically smaller one
        existingArray.sort((x,y)->x.get(0)>y.get(0)?1:(x.get(0)<y.get(0))?-1:0);
        return existingArray.get(0);
    }

    // Brute Force Approach
    public int[] flip(String A,int x) {
        int allOneCount = 0;
        for(int i=0;i<A.length();i++){
            int temp = (A.charAt(i) == '1') ? allOneCount++:0;
        }
        int max = allOneCount;
        for (int i=0;i<A.length();i++){ // Start the index
            int zeroCount = 0;
            int oneCount = 0;
            for (int j=i;j<A.length();j++){ // Move the end index
                if ((A.charAt(j) == '0')) {
                    zeroCount++;
                } else {
                    oneCount++;
                }
                //for(int k=i;k<=j;k++){ // between start and end index - Count the 0s and 1s
                    max = Math.max(max,allOneCount+zeroCount-oneCount);
                //}
            }
        }
        System.out.println(max);
        return null;
    }
}
