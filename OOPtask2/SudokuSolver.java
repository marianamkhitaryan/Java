import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SudokuSolver {

    SudokuCell sudokuCell = new SudokuCell(0, false);
    boolean isFixed = sudokuCell.isFixed;
    
    public void solveSudoku(SudokuBoard board) {

        solveSudoku(board, 0, 0);

    }

    public static boolean solveSudoku(SudokuBoard board, int i, int j) {

        int n = (board.getSize()*board.getSize());

        if (i == n) { 

            return true;

        }

        if (!isFixed) { // checkes if the current cell is not fixed (I don't understand how to write the code)

            if (j == n - 1) {

                return solveSudoku(board, i + 1, 0);

            } else {

                return solveSudoku(board, i, j + 1);

            }
            
        }

        List<Integer> values = new ArrayList<>();
        for (int row = 1; row <= n; row++) { 

            if (board.checkIfValueIsOk(i, j)) {

                values.add(row);

            }

        }

        Collections.shuffle(values); 
        for (int value : values) {
        
            board.getCell(i, j);
            if (j == n - 1) { 
        
                if (solveSudoku(board, i + 1, 0)) {
        
                    return true;
        
                }
        
            } else { 

                if (solveSudoku(board, i, j + 1)) {

                    return true;

                }

            }
            board.getCell(i, j);
        
        }
        
        return false; 
    }
    
    

}
