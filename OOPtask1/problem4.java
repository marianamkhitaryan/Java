import java.util.Scanner;

public class problem4 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word: ");

        String word = input.next();
        input.close();

        if (word.length() < 14) {

            System.out.println("No changes: " + word);

        } else {

            char firstChar = word.charAt(0);
            char lastChar = word.charAt(word.length() - 1);
            int numChars = word.length() - 2;
            String ternary = getTernaryRepresentation(numChars);

            String modified = lastChar + ternary + firstChar;
            System.out.println("Modified word: " + modified);

        }
    }

    private static String getTernaryRepresentation(int num) {

        if (num == 0) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();

        while (num > 0) {
            int digit = num % 3;
            builder.insert(0, digit);
            num /= 3;
        }
        return builder.toString();
        
    }
}
