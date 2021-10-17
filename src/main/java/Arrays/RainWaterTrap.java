package Arrays;

import java.util.Arrays;

public class RainWaterTrap {
    public static void main(String[] args) {
        int[] array = new int[]{ 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int count = 0;
        if (array.length<3) System.out.println("0");
        int[] maxFromStart = new int[array.length];
        int[] maxFromEnd = new int[array.length];
        maxFromStart[0] = Math.max(array[0],0);
        maxFromEnd[array.length-1] = Math.max(array[array.length-1],0);
        for (int i=1,j=array.length-2;i<array.length;i++,j--){
            maxFromStart[i] = Math.max(array[i],maxFromStart[i-1]);
            maxFromEnd[j] = Math.max(array[j],maxFromEnd[j+1]);
        }
        for (int i=1;i<array.length-1;i++){
            int currentBar = array[i];
            int startMax = maxFromStart[i-1];
            int endMax = maxFromEnd[i+1];
            int minHeight = Math.min(startMax,endMax);
            if (minHeight>currentBar)
            count = count + ( minHeight -  currentBar);
        }
        System.out.println(count);
    }
}
