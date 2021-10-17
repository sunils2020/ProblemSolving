package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args) {
        String[] array = new String[]{".........", ".........", ".......1.", "...8....7", ".....9.49", ".........", ".4....7..", "....5....", ".......5."};
        HashSet<Character> charset1 = new HashSet<>();
        HashSet<Character> charset2 = new HashSet<>();
        HashSet<Character> charset3 = new HashSet<>();
        int[][] set = new int[9][9];
        int count = 0; boolean isValidSudoku = true;
        for (int i=0;i<array.length;i++){
            String row = array[i];
            int[] temp = new int[row.length()];
            if (count == 27) {
                charset1.clear();
                charset2.clear();
                charset3.clear();
                count = 0;
            }
            for(int j=0,k=0;j<row.length();j++,k++){
                count++;
                int pos = (int)row.charAt(j);
                if (row.charAt(j)=='.') continue;
                if (temp[pos-49] == 1) {
                    isValidSudoku = false;
                    break; // Number already exists
                } else {
                    temp[pos-49] = 1;
                }
                if ((k==0)||(k==1)||(k==2))  {
                    if(charset1.contains(row.charAt(j))) {
                        isValidSudoku = false;
                        break;// Number already exists
                    }
                    charset1.add(row.charAt(j));
                }
                else if ((k==3)||(k==4)||(k==5))  {
                    if(charset2.contains(row.charAt(j))) {
                        isValidSudoku = false;
                        break;// Number already exists
                    }
                    charset2.add(row.charAt(j));
                }
                else if ((k==6)||(k==7)||(k==8))  {
                    if(charset3.contains(row.charAt(j))) {
                        isValidSudoku = false;
                        break;// Number already exists
                    }
                    charset3.add(row.charAt(j));
                }
                // Take mod to find the appropriate bucket of column
                int mod = j%9;
                if (set[mod][pos-49] == 1) {
                    isValidSudoku = false;
                    break;
                }
                else set[mod][pos-49] = 1;
            }
            if (!isValidSudoku) {
                break;
            }
        }
    }
}
