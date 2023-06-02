import java.util.Scanner;

public class problem1 {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String word = sc.next();

        String[] wordSequence = new String[n];

        for(int i = 0; i < n; i++) {
            wordSequence[i] = sc.next();
        }

        boolean exists = false;
        int count = 0;

        for(int i = 0; i < n; i++) {
            if (word.equals(wordSequence[i])) {
                count++;
                exists = true;
            }
        }

        for(int i = 0; i < n; i++) {
            if (word.equals(wordSequence[i])) {
                exists = true;
            }
        }

        System.out.println(count);
        System.out.println(exists);


    }
}