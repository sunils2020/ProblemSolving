package Arrays;

public class MaximumAbsoluteDifference {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,-1};
        MaximumAbsoluteDifference obj = new MaximumAbsoluteDifference();
        obj.maxArr(array);

        // Brute Force Approach
        int maxDiff = 0;
        // i value range between 1 to i
        // j range from j to N (array.length)
        int N = array.length;
        for(int i=0;i<array.length;i++){
            int a = array[i];
            for(int j=i+1;j<N;j++){
                int b = array[j];
                int temp = Math.abs(a-b)  +  Math.abs(i-j);
                maxDiff = Math.max(temp,maxDiff);
            }
        }
        System.out.println(maxDiff);
    }

    /*
        Approach :

        |a[i] - a[j]| + |i - j|
==>     This can be written as - considering +/- scenarios if not modulo operation

Case 1  : a[i] > a[j] and i>j
          This can also be written as   (a[i]+i)  - (a[j]+j)

Case 2  : a[i] < a[j] and i>j
          This can also be written as   - (a[i]-i) - (-a[j]+j)

Case 3  : a[i] < a[j] and i<j
          This can also be written as   -(a[i]+i)  - (-a[j]-j)

Case 4  : a[i] > a[j] and i<j
          This can also be written as   (a[i]-i)  - (a[j]-j)

Case 2 and Case 3 will end up in negative values but we were asked to find the maximum value.

i and j is same except for the index.

Golden rule : Maximum value and minimum value difference will be the largest difference

Take 2 sets of difference and return the largest difference


    */
    public int maxArr(int[] array) {
        int[] case1 = new int[array.length];
        int case1Min = Integer.MAX_VALUE;
        int case1Max = Integer.MIN_VALUE;

        int[] case2 = new int[array.length];
        int case2Min = Integer.MAX_VALUE;
        int case2Max = Integer.MIN_VALUE;

        for (int i=0;i<array.length;i++){
            case1[i] = array[i]+i;
            case1Min = Math.min(case1Min,case1[i]);
            case1Max = Math.max(case1Max,case1[i]);
        }

        for (int i=0;i<array.length;i++){
            case2[i] = array[i]-i;
            case2Min = Math.min(case2Min,case2[i]);
            case2Max = Math.max(case2Max,case2[i]);
        }
        return Math.max(case1Max-case1Min,case2Max-case2Min);
    }

}
