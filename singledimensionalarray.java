package JavaClassPrograms;

import java.util.Scanner;

public class singledimensionalarray {
    public static void main (String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter "+size+" elements: ");
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("The elements of the array are: ");
        for(int i = 0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();    
    }
}
