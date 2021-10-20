package DynamicArrays;

public class SumOfAllSubMatrices {
    public static void main(String[] args) {
        SumOfAllSubMatrices obj = new SumOfAllSubMatrices();
        System.out.println(obj.solve(new int[][]{{1,1},{1,1}}));
    }

    /*
        Hint : Find how many times each element contribute (i.e) Number of sub matrices possible considering the given element
        [   1   2   3   4
            5   6   7   8
            9   10  11  12  ]
        Take number 6 => All matrices possible using
                        1   2       and         6   7   8
                        5   6                   10  11  12

         6 => (1,1) position
         In case of     1   2       => on top of 6 there is 1 possibility and left 1 possibility
                        5   6          including 6 => 2 possibilities
         Hence 6 * (x+1) * (y+1)

         Another example == array = 1   2   , at 2 (0,1) = 2 * (1+1) * (2-1)  = 4
                                              at 1 (0,0) = 1    = 4 +2  = 5

                                                 1  2
                                                    2
                                                ------
                                                    5

         In case of     6   7   8       => below = Out of n columns - use 3 - 1 = 2
                        10  11  12                  Out of m rows - use 4 -1 = 3

    */
    public int solve(int[][] arrays) {
        int solution = 0;
        int cols = arrays.length;
        for(int i=0;i<cols;i++){
            int rows = arrays[i].length;
            for(int j=0;j<rows;j++){
                int currentElement = arrays[i][j];
                int topPossibility      =   i + 1; // Inclusive - since index is starting from 0 , including it
                int leftPossibility     =   j + 1;// Inclusive - since index is starting from 0 , including it
                int rightPossibility    =   rows - j; // Exclusive - since index is starting from 0 , excluding it
                int bottomPossibility   =  cols- i;// Exclusive - since index is starting from 0 , excluding it
                int temp = (currentElement * topPossibility * leftPossibility * rightPossibility * bottomPossibility);
                solution = solution + temp;
            }
        }
        return solution;
    }
}
