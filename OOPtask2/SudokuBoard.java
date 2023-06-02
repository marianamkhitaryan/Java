
public class SudokuBoard {

    int size;
    SudokuCell[][] grid;

    public SudokuBoard(int[][] initialBoard) {

        size = (int) Math.sqrt(initialBoard.length);
        grid = new SudokuCell[size*size][size*size];
        for (int i = 0; i < size*size; i++) {
            for (int j = 0; j < size*size; j++) {
                grid[i][j] = new SudokuCell(initialBoard[i][j], initialBoard[i][j] != 0);
            }
        }

    }

    public int getSize() {

        return size;

    }

    public SudokuCell getCell(int i, int j) {

        return grid[i][j];

    }

    public boolean checkIfValueIsOk(int i, int j) {

        int value = grid[i][j].getValue();

        for (int row = 0; row < size*size; row++) {

            if (row != i && grid[row][j].getValue() == value) {

                return false;

            }

        }

        for (int col = 0; col < size*size; col++) {

            if (col != j && grid[i][col].getValue() == value) {

                return false;

            }

        }

        for (int row = i; row < i + size; i++) {

            for (int column = j; column < j + size; j++) {

                if ((row != i || column != j) && grid[row][column].getValue() == value) {
                    
                    return false;
                
                }

            }

        }

        return true;

    }

    public boolean checkIfIsSolved(int i, int j) {

        if (grid[i][j].getValue() == 0) {

            return false;

        }

        for (int row = 0; row < size*size; row++) {

            boolean[] foundValuesInRow = new boolean[size*size + 1];
            boolean[] foundValuesInColumn = new boolean[size*size + 1];

            for (int column = 0; column < size*size; column++) {

                int valueInRow = grid[i][j].getValue();
                if (foundValuesInRow[valueInRow]) {

                    return false;

                }
                foundValuesInRow[valueInRow] = true;
                
                int valueInColumn = grid[j][i].getValue();
                if (foundValuesInColumn[valueInColumn]) {

                    return false;

                }
                foundValuesInColumn[valueInColumn] = true;

            }

        }

        int valueBoxRow = i - i % size;
        int valueBoxColumn = j - j % size;

        for (int row = valueBoxRow; row < valueBoxRow + size; row++) {

            for (int column = valueBoxColumn; column < valueBoxColumn + size; column++) {
                
                if (grid[row][column].getValue() == grid[i][j].getValue()) {

                    return false;

                }

            }

        }

        return true;

    }

    public void print() {

        int cellWidth = (int) Math.ceil(Math.log10(size * size));
        String horizontalLine = "+".concat("-".repeat(cellWidth * size + size - 1)).concat("+");
    
        System.out.println(horizontalLine);
    
        for (int row = 0; row < size * size; row++) {
            for (int column = 0; column < size * size; column++) {

                String cellValue = (grid[row][column].getValue() == 0) ? " " : Integer.toString(grid[row][column].getValue());
                System.out.printf("| %-" + cellWidth + "s ", cellValue);
    
                if ((column + 1) % size == 0) {

                    System.out.print("|");
                
                }
            
            }
            System.out.println();
    
            if ((row + 1) % size == 0) {
            
                System.out.println(horizontalLine);
            
            }
        
        }
    
    }
 
}
