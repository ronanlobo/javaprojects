package JavaClassPrograms;
// Write a java program to print if the number is odd or even
public class condition {
    public static void main (String args[])
    {
        for(int i=0;i<=10;i++)
        {
            if ((i%2) == 0)
            {
                System.out.println(i + " is an even number. ");
            }
            else
            {
                System.out.println(i + " is an odd number. ");
            }
        }
    }
}