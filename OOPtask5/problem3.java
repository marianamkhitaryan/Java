import java.util.Scanner;

public class problem3 {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
 
        int digit1 = n % 10;
        n /= 10;

        boolean increasing = false;

        while (n != 0) {
            int digit2 = n % 10;
            n /= 10;

            if (digit1 < digit2) {
                increasing = false;
                break;
            }
            digit1 = digit2;
        }

        System.out.println(increasing);

    }
}