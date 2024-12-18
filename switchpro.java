package JavaClassPrograms;
import java.util.*;
public class switchpro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("1 for Addition\n2 for Subtraction\n3 for Multiplication\n4 for Division");
        int ch = sc.nextInt();
        switch(ch)
        {
            case 1:
                System.out.println(a + "+" + b + "="+(a+b));
                break;
            case 2:
                System.out.println(a + "-" + b + "="+(a-b));
                break;
            case 3:
                System.out.println(a + "*" + b + "="+(a*b));
                break;
            case 4:
                if (b==0) System.out.println("Denominator cant be 0. ");
                else System.out.println(a + "/" + b + "="+(a/b));
                break;
            default:
                System.out.println("Invalid choice. ");
        }
        sc.close();
    }
}
