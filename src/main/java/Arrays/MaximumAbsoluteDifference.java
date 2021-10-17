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
