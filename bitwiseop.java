package JavaClassPrograms;
public class bitwiseop {
    public static void main (String args[]){
        int a = 4;
        int b = 7;
        //bitwise and
        //a and b become binary
        //0101 AND 0111 = 0101 = 5
        System.out.println("a & b = "+(a&b));

        //bitwise or
        //0101 OR 0111 = 0111 = 7
        System.out.println("a | b = "+(a|b));

        //bitwise xor
        //0101 XOR 0111 = 0010
        System.out.println("a ^ b = "+(a^b));

        //bitwise not
        //0101 = 1010
        //0111 = 1000
        System.out.println("~a = "+ ~a);
        System.out.println("~b = "+ ~b);
    }
}
