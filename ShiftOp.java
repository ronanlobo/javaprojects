package JavaClassPrograms;
public class ShiftOp {
    public static void main(String[] args) {
        int a = -10; //8 in binary is 1000

        //Left Shift Operator
        System.out.println("Left shift (a<<2): "+ (a<<2)); //8<<2 =32 (1000 becomes 100000)

        //Right Shift Operator
        System.out.println("Right shift (a>>2): "+ (a>>2)); //8>>2 = 2 (1000 becomes 10)

        //Unsigned Right Shift Operator
        int b = -2;
        System.out.println("Unsigned right shift (b>>>2): "+ (b>>>2)); //8>>2 = 2 (1000 becomes 10)
    }
}
