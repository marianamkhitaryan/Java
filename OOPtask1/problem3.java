import java.util.Scanner;

public class problem3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int rabbitRow = 0;
        int rabbitColumn = 0;
        
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                matrix[i][j] = sc.next().charAt(0);

                if (matrix[i][j] == 'r') {
                    rabbitRow = i;
                    rabbitColumn = j;
                }
            }
        }

        int targetRow = n / 2;
        int targetCol = n / 2;

        int rowDistance = Math.abs(targetRow - rabbitRow);
        int columnDistance = Math.abs(targetCol - rabbitColumn);

        int result = rowDistance + columnDistance;

        System.out.println(result);
    }
}
