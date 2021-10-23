package GCD;

public class GCDof2Numbers {
    public static void main(String[] args) {
        GCDof2Numbers obj = new GCDof2Numbers();
        System.out.println(obj.gcd(6,8));
    }
    //  Hint in question : B is always greater than A
    //  GCD properties - GCD(a,b) = GCD( a,b%a) ==> here b is greater
    //  Example : GCD (6,8)
    //           Normal way of calculation :
    //              Factors of 6 :  1   2   3   6
    //              Factors of 8 :  1   2   4   8
    //              GCD = 2 - because this is the highest divisor
    //
    //  Let us solve using the property
    //  GCD(6,8) = GCD (6,8%6) = GCD(6,2) => GCD(6%2, 2)    = GCD (0,2)
    //  Property 2 : GCD (a,0) = a
    //  This can be achieved in Log(Max(a,b)) times
    //
    //
    //
    //

    public int gcd(int A, int B) {
        if (B==0) return A;
        if (B>A) return gcd(A,B%A);
        else return gcd(B,A%B);
    }
}
