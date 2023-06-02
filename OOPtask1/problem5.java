import java.util.Scanner;

public class problem5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        
        String modified = input.replaceAll("[aeiouAEIOU]", "&").replaceAll("[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]", "$0!");
        System.out.println(modified);
    }
}
