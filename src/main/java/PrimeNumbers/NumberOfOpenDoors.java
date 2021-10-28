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
    //
    //
    //
    //
    //



    public int solve(int doors) {
        int count = 0;
        for(int i=0;i<(int)Math.sqrt(doors);i++){
            count++;
        }
        return count;
    }
}
