package XOR;

import java.util.Arrays;
import java.util.List;

public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber obj = new SingleNumber();
        System.out.println(obj.singleNumber(Arrays.asList(1, 2, 2, 3, 1)));
    }

    //  XOR of same elements results in 0
    //  Finally the duplicate number ends up
    public int singleNumber(final List<Integer> A) {
        int temp = A.get(0) ;
        for(int i=1;i<A.size();i++){
            temp = temp ^  A.get(i);
        }
        return temp;
    }
}
