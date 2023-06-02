import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float v = 2;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String input = sc.next();

            if (input.charAt(0) == '>' || input.charAt(1) == '>') {
                v = v / 2;
            } else {
                v = v * 2;
            }
        }

        System.out.println(v);
    }
}





