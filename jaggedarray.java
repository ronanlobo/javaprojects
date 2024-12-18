package JavaClassPrograms;
public class jaggedarray {
    public static void main (String args[]){
        int jagarr[][] = new int [3][];
        jagarr[0]=new int[3];
        jagarr[1]=new int[2];
        jagarr[2]=new int[4];
        
        jagarr[0][0]=1;
        jagarr[0][1]=2;
        jagarr[0][2]=3;

        jagarr[1][0]=4;
        jagarr[1][1]=5;

        jagarr[2][0]=6;
        jagarr[2][1]=7;
        jagarr[2][2]=8;
        jagarr[2][3]=9;

        for(int i =0;i< jagarr.length; i++){
            for(int j=0; j<jagarr[i].length; j++){
                System.out.print(jagarr[i][j]+" ");
            }
            System.out.println();
        }
    }
}