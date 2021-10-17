package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/*
    Technique :
    1		2		3		4		5
    Rotate by 2,
    Iterate through the array 0 - 5
    * (0 + 2 ) % 5 = 2
    * (1 + 2 ) % 5 = 3
    * (2 + 2 ) % 5 = 4
    * (3 + 2 ) % 5 = 0
    * (4 + 2 ) % 5 = 1
 */


public class LeftRotationsArray {

    public static void main(String[] args) {
        LeftRotationsArray obj = new LeftRotationsArray();
        ArrayList<ArrayList<Integer>> output = obj.solve2(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1,3)
        );
        System.out.println(output);
    }

    // Short approach - but both the approaches iterate once through the array
    public ArrayList<ArrayList<Integer>> solve2(List<Integer> A, List<Integer> B) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for (int i=0;i<B.size();i++){
            int currentRotation = B.get(i)%A.size();
            if (!map.containsKey(currentRotation))  {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j=0;j<A.size();j++){
                    int findIndex = (j+currentRotation) % A.size();
                    temp.add(A.get(findIndex));
                }
                map.put(currentRotation,temp);
                output.add(temp);
            } else {
                output.add(map.get(currentRotation));
            }
        }
        return output;
    }






    // Approach 2
    public ArrayList<ArrayList<Integer>> solve(List<Integer> A, List<Integer> B) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for (int i=0;i<B.size();i++){
            int currentRotation = B.get(i)%A.size();
            if (!map.containsKey(currentRotation))  {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j=currentRotation;j<A.size();j++){
                    temp.add(A.get(j));
                }
                for (int k=0;k<currentRotation;k++){
                    temp.add(A.get(k));
                }
                map.put(currentRotation,temp);
                output.add(temp);
            } else {
                output.add(map.get(currentRotation));
            }
        }
        return output;
    }
}
