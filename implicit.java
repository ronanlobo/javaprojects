package JavaClassPrograms; //Package named the folder name
public class implicit
{
    public static void main (String args[])
    {
        //byte to int (Widening conversion)
        byte byteValue = 10;
        int intValue = byteValue; // byte automatically cast to int
        System.out.println("Byte to Int: "+intValue);

        // double to float (narrowing convserion)
        double doubleValue = 9.786666666666666;
        float floatValue = (float) doubleValue; //  explicit cast from double to float
        System.out.println("Double to Float: "+floatValue);

        //int to byte (Narrowing conversion)
        int i=130;
        byte byteValue1 = (byte) i; 
        System.out.println("Int to byte: "+byteValue1);
    }
}