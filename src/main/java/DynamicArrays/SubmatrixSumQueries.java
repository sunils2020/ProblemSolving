package DynamicArrays;
import java.util.Arrays;
//  Hint : Prefix sum horizontally & prefix sum vertically
//  Make sure for prefix sum - have an additional row and column
//
//                              Transforms to
//      1   2   3               0   0   0   0               0   0   0   0
//      4   5   6       ==>     0   1   3   6       ==>     0   1   3   6
//      7   8   9               0   4   9   15              0   5   12  21
//                              0   7   15  24              0   12  27  45
//
//      Now inorder to find sum of  5   6
//                                  8   9
//
//                                                  Take the bottom right corner 45
//                                                  subtract   12               -12
//                                                  subtract    6               -6
//                                                  add         1                  1    ==> Reason for adding because remove twice
//                                                                          ----------
//                                                                              28
//
//

public class SubmatrixSumQueries {
    public static void main(String[] args) {
        SubmatrixSumQueries obj = new SubmatrixSumQueries();
        System.out.println(Arrays.toString(obj.solve(new int[][]{{5, 17, 100, 11},{0, 0, 2, 8}},new int[]{1,1},new int[]{1,4},new int[]{2,2},new int[]{2,4})));
    }
    //      0   0   0   0    0
    //      0   5   17  100  11
    //      0   0   0     2   8
    //
    //

    //      0 0   0   0
    //      0 1   2   3             1   2   3
    //      0 4   5   6             4   5   6
    //      0 7   8   9             7   8   9
    public int[] solve(int[][] arrays, int[] B, int[] C, int[] D, int[] E) {
        long [][] prefixSum = new long[arrays.length+1][arrays[0].length+1];
        int rows = prefixSum.length;
        int cols = prefixSum[0].length;

        for (int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                prefixSum[i][j] =   (prefixSum[i][j-1] + arrays[i-1][j-1])%1000000007;
            }
        }

        for (int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                prefixSum[i][j] =   (prefixSum[i-1][j] + prefixSum[i][j])%1000000007;
            }
        }

        long solution = 0;
        int[] solutionArray = new int[B.length];
        for (int i=0;i<B.length;i++) {
            int a   =  B[i];
            int b   =  C[i];
            int x   =  D[i];
            int y   =  E[i];
            long matrixSum = prefixSum[x][y];
            long excludeLeft = prefixSum[x][b-1];
            long excludeTop = prefixSum[a-1][y];
            long addPreviousMatrix  = prefixSum[a-1][b-1];
            solution = Math.floorMod(matrixSum - excludeLeft - excludeTop + addPreviousMatrix,1000000007);
            solutionArray[i] = (int)solution;
        }

        return solutionArray;
        //      0 0   0   0
        //      0 1   2   3             1   2   3
        //      0 4   5   6             4   5   6
        //      0 7   8   9             7   8   9
    }
}
