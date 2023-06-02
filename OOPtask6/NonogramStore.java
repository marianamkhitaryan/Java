import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NonogramStore {
    private ArrayList<Nonogram> nonograms;

    public NonogramStore(String path) {
        nonograms = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(path));
            int numPuzzles = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < numPuzzles; i++) {
                String puzzleConfig = "";
                String name = scanner.nextLine();
                int numColumns = scanner.nextInt();
                int numRows = scanner.nextInt();
                scanner.nextLine();
                puzzleConfig += name + "\n" + numColumns + "\n" + numRows + "\n";
                for (int j = 0; j < numRows; j++) {
                    puzzleConfig += scanner.nextLine() + "\n";
                }
                Nonogram nonogram = new Nonogram(puzzleConfig);
                nonograms.add(nonogram);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Nonogram> getNonogramsSorted() {
        ArrayList<Nonogram> copy = new ArrayList<>(nonograms);
        Collections.sort(copy);
        return copy;
    }
}
