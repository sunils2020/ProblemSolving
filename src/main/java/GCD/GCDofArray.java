package GCD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class GCDofArray {
    public static void main(String[] args) {
        GCDofArray obj = new GCDofArray();
        System.out.println(obj.solve(Arrays.asList(2, 2, 2, 2, 8, 2, 2, 2, 10)));
    }
    public ArrayList<Integer> solve(List<Integer> list) {
        HashSet<Long> set = new HashSet<>();
        long runningGCD = 0;
        for(int i=1;i<list.size();i++){
            runningGCD = gcd(list.get(i),runningGCD);
            System.out.println(runningGCD);
        }
        System.out.println(set.toString());
        return null;
    }

    public long gcd(long A, long B) {
        if (B==0) return A;
        if (B>A) return gcd(A,B%A);
        else return gcd(B,A%B);
    }
}
