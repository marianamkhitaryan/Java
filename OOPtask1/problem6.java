import java.util.Scanner;

public class problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();

        for (int i = 1; i <= (l*2 + 1); i++) {
            for (int j = 1; j <= (l*2 + 1); j++) {
                if (i == j || (i + j) == ((l*2)+2)) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
