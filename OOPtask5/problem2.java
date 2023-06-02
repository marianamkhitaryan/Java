import java.util.Scanner;

public class problem2 {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int n, k;
        
        n = sc.nextInt();
        k = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int temp = arr[k];

        for(int i = k+1; i < n; i++) {
            arr[i - 1] = arr[i];
        }

        arr[n - 1] = temp;

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}