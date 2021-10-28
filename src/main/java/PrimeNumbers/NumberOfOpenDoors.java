package PrimeNumbers;

public class NumberOfOpenDoors {
    public static void main(String[] args) {
        NumberOfOpenDoors obj = new NumberOfOpenDoors();
        System.out.println(obj.solve(5));
    }

    //  Assume there are 5 doors
    //              Door1       Door2       Door3       Door4       Door5
    //  Initial      X            X          X           X            X         ===> Initially, all the doors are closed
    //  =>  1        O            O          O           O            O         ===> 1st person toggles all factors of 1
    //  ==> 2        O            X          O           X            O         ===> Toggles 2nd factor
    //  ==> 3        O            X          X           X            O         ===> Toggles 3 factors
    //  ==> 4        O            X          X           O            O         ===> Toggles 4 factors
    //  ==> 5        O            X          X           O            X         ===> Toggles 5 factors
    //
    //  Any door if it has even factors will finally end up closed.
    //  It means number 10 - for example
    //  1   2   5   10 - 4 factors for number 10 , even - this will finally end up in CLOSED
    //  Consider number - 9
    //  1   3   9   => Odd number of factors. This means the door would be finally OPEN
    //
    //  Solution 1 : Take each number and find the corresponding factors of it - if the factor is odd then count that particular number
    //  In our case, it would be 1, 4 => Results in 2.. This is O(n) solution
    //
    //  Better Solution:    To find the number of factors - it is enough to find the Square root of the number to find its factors
    //  Example:   Math.sqrt(10) = 3    ==> Numbers less than 3 which are divisible by 3 are 1, 2
    //  Now we know the total number of doors = 5, maximum doors which can be open should be square root of (5)
    //
    public int solve(int doors) {
        int count = 0;
        for(int i=0;i<(int)Math.sqrt(doors);i++){
            count++;
        }
        return count;
    }
}
