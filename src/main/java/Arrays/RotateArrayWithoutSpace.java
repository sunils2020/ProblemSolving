package Arrays;

import java.util.Arrays;
/*
    Trick : 2 steps , interchange and swap

    Example:        1       2       3
                    4       5       6
                    7       8       9

          ==============       interchange    =====================

                    1       4       7
                    2       5       8
                    3       6       9

           ==============       swap    =====================


                    7       4       1
                    8       5       2
                    9       6       3







 */
public class RotateArrayWithoutSpace {
    public static void main(String[] args) {
        int [][] array = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        for (int i=0;i<array.length;i++){
            for (int j=i+1;j<array.length;j++){
                if (i==j) continue;
                int temp1 = array[i][j];
                int temp2 = array[j][i];
                array[i][j] = temp2;
                array[j][i] = temp1;
            }
        }
        for (int i=0;i<array.length;i++){
            for (int j=0,k=array.length-1;j<array.length;j++,k--) {
                if ((j==k) || (k<j))break;
                int temp1 = array[i][j];//00
                int temp2 = array[i][k];
                array[i][j] = temp2;
                array[i][k] = temp1;
            }
        }

        System.out.println(Arrays.deepToString(array));

    }
}
