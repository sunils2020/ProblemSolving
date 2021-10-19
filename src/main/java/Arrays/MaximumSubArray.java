package Arrays;

public class MaximumSubArray {
    public static void main(String[] args) {
        MaximumSubArray obj = new MaximumSubArray();
        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(obj.maxSubArray(array));
    }
    /*
        Brute Force Approach :
        Take all sub arrays and calculate its sum. Find out the maximum sum in this lot.
        Example:
            -2 1 -3 4 -1 2 1 -5 4

        At point -2 ---> Maximum sum array is -2
        At point  1 ---> Calculate -2 + 1   -1
                                     1       1
        At point -3 ----> Calculate -2 1 -3  = -4
                          Calculate 1 -3     = -2
                          Calculate -3       = -3
    */

    /*
        Efficient Approach :

        *****  Consider current element - Compare whether it is maximum or by including previous sum **********
        Example:
            -2 1 -3 4 -1 2 1 -5 4

        At -2   = -2 is the maximum sum
        At  1   = max(1,1-2) is the maximum sum => 1
        At -3   = max(-3,-3+1) = -2 is the maximum sum
        At 4    = max(4,4-2) = 4 is the maximum sum
        At -1   = max(-1,4-1) = 3 is the maximum sim
        At 2 = max(2,2+3) = 5 is the maximum sum
        At 1 = max(1,5+1) = 6 is the maximum sum
        At -5 = max(-5,-5+6) = 1 is the maximum sum
        At 4 = max(4,4+1) = maximum sum = 5
    */

    public int maxSubArray(final int[] array) {
        int[] solution = new int[array.length];
        solution[0] = array[0];
        int currentMax = solution[0];
        for (int i=1;i<array.length;i++){
            solution[i] = Math.max(array[i],array[i]+solution[i-1]);
            currentMax = Math.max(solution[i],currentMax);
        }
        return currentMax;
    }

}
