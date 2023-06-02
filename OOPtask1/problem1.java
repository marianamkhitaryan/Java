import java.util.Scanner;

public class problem1 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int arrLength = 2*k+1;
        int[] inputArray = new int[(arrLength - 1)];

        int sum = 0;

        for(int i = 0; i < arrLength-1; i++)  
        {  
            inputArray[i]=sc.nextInt();  
        } 
        
        for(int i = 0; i < arrLength - 1; i++) {
            sum += inputArray[i];  
        }

        System.out.println();
        System.out.println(sum*sum);

    }
}
    

