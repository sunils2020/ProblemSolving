package XOR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumPairXOR {
    public static void main(String[] args) {
        MinimumPairXOR obj = new MinimumPairXOR();
        System.out.println(obj.findMinXor(Arrays.asList(0, 2, 5, 7)));
    }
    //  Hint: a <= b <= c
    //  If this is the case 1:  a ^ b  < a ^ c
    //                 case 2:  b ^ c  < a ^ c
    //  a < c cannot be less than a ^ b AND b ^ c
    //
    //  Proof :     1   <   2   <   3
    //
    //    1 ^ 2     = 01 ^ 10 => 11 = 3
    //    2 ^ 3     = 10 ^ 11 => 01 = 1
    //    1 ^ 3     = 01 ^ 11 => 10 = 2     2 is less than 3 but not than 1
    public int findMinXor(List<Integer> arrayList) {
        Collections.sort(arrayList);
        int min = Integer.MAX_VALUE;
        for (int i=1;i<arrayList.size();i++){
            int current = arrayList.get(i-1) ^ arrayList.get(i);
            min = Math.min(min,current);
        }
        return min;
    }

}
