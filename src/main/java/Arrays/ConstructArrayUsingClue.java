package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructArrayUsingClue {
    public static void main(String[] args) {
        ConstructArrayUsingClue obj = new ConstructArrayUsingClue();
        //sample3
        System.out.println(obj.solve(9, 1, 22));
    }

    /*
        1. B and C are given,,,
        2. Hint : Equal difference between numbers . this means it is in AP
           Example:     20  30  40  50  60
           This can be written as
              10+(1*10) + 10+(2*10) + 10+(3*10) ......
           which means
            a+d, a+2d, a+3d, a+4d
            B = a+  p1*d
            C = a+  p2*d
            ----------------
           C-B  = (p2-p1)*d

          d will be in the factor of C - B
          Example: 50 - 20 = 30 ==> d should be factor of 30

          Factors of 30

          1 * 30 = 30
          2 * 15 = 30
          3 * 10 = 30
          5 * 6  = 30
          -----------
          6 * 5  = 30
          10 * 3 = 30
          15 * 2 = 30
          30 * 1 = 30
     */
    public int[] solve(final int A, final int B, final int C) {
        int[] solution = new int[A];
        int[] result = new int[A];
        if (A == 2) {
            solution[0] = B;
            solution[1] = C;
            return solution;
        }
        int diff = C - B;
        ArrayList<Integer> factors = new ArrayList<>();
        for (int divisor = 1; divisor <= (int) Math.sqrt(diff); divisor++) {
            if (diff % divisor == 0) {
                factors.add(divisor);
                factors.add(diff / divisor);
            }
        }
        int count = 1;
        for (int a = 1; a <= 50; a++) {
            boolean bFlag = false;
            boolean cFlag = false;
            for (int divisor : factors) {
                for (int i =0; i < A; i++) {
                    solution[i] = a + (divisor * i);
                    if (B == solution[i]) bFlag = true;
                    if (C == solution[i]) cFlag = true;

                }
                if (bFlag == false || cFlag == false) {
                    continue;
                } else {
                    if (count == 1)
                        result = solution.clone();
                    else if (solution[A-1]<result[A-1])
                        result = solution.clone();
                    count++;
                    bFlag = false;
                    cFlag = false;
                }
            }
        }
        System.out.println(Arrays.toString(result));

        return result;
    }

}
