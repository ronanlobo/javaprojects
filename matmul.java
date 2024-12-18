package JavaClassPrograms;
import java.util.*;
public class matmul {
    public static void main (String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the number of rows and columns for the first matrix: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        System.out.println("Enter the number of rows and columns for the second matrix: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        if(c1==r2){
            int matrix1[][]=new int[r1][c1];
            int matrix2[][]=new int[r2][c2];
            System.out.println("Enter elements of first array: ");
            for(int i=0;i<r1;i++){
                for(int j=0; j<c1; j++){
                    matrix1[i][j]=sc.nextInt();
                }
            }
            System.out.println("Enter elements of second array: ");
            for(int i=0;i<r2;i++){
                for(int j=0; j<c2; j++){
                    matrix2[i][j]=sc.nextInt();
                }
            }
            int res[][] = new int[r1][c2];
            for(int i = 0;i<r1;i++){
                for (int j = 0;j<c2;j++){
                    res[i][j] = 0;
                    for(int k=0;k<c1;k++){
                        res[i][j] += matrix1[i][k]*matrix2[k][j];
                    }
                }
            }
            System.out.println("Resultant matrix: ");
            for(int i = 0;i<r1;i++){
                for (int j = 0;j<c2;j++){
                    System.out.print(res[i][j]+" ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Matrix Multiplication not possible. ");
        }
        sc.close();
    }
}