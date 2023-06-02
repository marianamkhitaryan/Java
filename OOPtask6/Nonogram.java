import java.util.Arrays;

public class Nonogram implements Comparable<Nonogram> {
    private String name;
    private boolean[][] board;
    private boolean[][] solution;
    private int[][] rowRules;
    private int[][] columnRules;

    public int width() {
        return board[0].length;
    }
    public int getWidth() {
        return width();
    }

    public int height() {
        return board.length;
    }

    public int getHeight() {
        return height();
    }
    public int columnRuleMaxSize() {
        int max = 0;
        for (int[] rule : columnRules) {
            max = Math.max(max, rule.length);
        }
        return max;
    }

    public int rowRuleMaxSize() {
        int max = 0;
        for (int[] rule : rowRules) {
            max = Math.max(max, rule.length);
        }
        return max;
    }

    public boolean getCell(int row, int column) {
        return board[row][column];
    }

    public int[] getRowRule(int i) {
        return rowRules[i];
    }

    public int[] getColumnRule(int i) {
        return columnRules[i];
    }

    public void flip(int row, int col) {
        board[row][col] = !board[row][col];
    }

    public void setCells(boolean[][] arr) {
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                board[i][j] = arr[i][j];
            }
        }
    }

    public void clear() {
        boolean[][] empty = new boolean[board.length][board[0].length];
        setCells(empty);
    }

    public void fillWithSolution() {
        setCells(solution);
    }

    public String toString() {
        return name;
    }

    public int compareTo(Nonogram nonogram) {
        int thisSize = width() + height();
        int otherSize = nonogram.width() + nonogram.height();
        return thisSize - otherSize;
    }

    public boolean checkIfSolved() {

        for (int i = 0; i < height(); i++) {
            int runLength = 0;
            boolean runStarted = false;
            for (int j = 0; j < width(); j++) {
                if (board[i][j]) {
                    if (!runStarted) {
                        runStarted = true;
                    }
                    runLength++;
                } else if (runStarted) {
                    int[] rowRule = getRowRule(i);
                    if (Arrays.binarySearch(rowRule, runLength) < 0) {
                        return false;
                    }
                    runStarted = false;
                    runLength = 0;
                }
            }
            if (runStarted) {
                int[] rowRule = getRowRule(i);
                if (Arrays.binarySearch(rowRule, runLength) < 0) {
                    return false;
                }
            }
        }

        for (int j = 0; j < width(); j++) {
            int runLength = 0;
            boolean runStarted = false;
            for (int i = 0; i < height(); i++) {
                if (board[i][j]) {
                    if (!runStarted) {
                        runStarted = true;
                    }
                    runLength++;
                } else if (runStarted) {
                    int[] columnRule = getColumnRule(j);
                    if (Arrays.binarySearch(columnRule, runLength) < 0) {
                        return false;
                    }
                    runStarted = false;
                    runLength = 0;
                }
            }
            if (runStarted) {
                int[] columnRule = getColumnRule(j);
                if (Arrays.binarySearch(columnRule, runLength) < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public Nonogram(String configuration) {
        String[] parts = configuration.split("\n");
        this.name = parts[0];
        int numColumns = Integer.parseInt(parts[1]);
        int numRows = Integer.parseInt(parts[2]);
        this.board = new boolean[numRows][numColumns];
        this.rowRules = new int[numRows][];
        this.columnRules = new int[numColumns][];
        this.solution = new boolean[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            String[] ruleParts = parts[3 + i].split(" ");
            int[] rowRule = new int[ruleParts.length];
            for (int j = 0; j < ruleParts.length; j++) {
                rowRule[j] = Integer.parseInt(ruleParts[j]);
            }
            this.rowRules[i] = rowRule;
        }
        for (int j = 0; j < numColumns; j++) {
            String[] ruleParts = parts[3 + numRows + j].split(" ");
            int[] columnRule = new int[ruleParts.length];
            for (int k = 0; k < ruleParts.length; k++) {
                columnRule[k] = Integer.parseInt(ruleParts[k]);
            }
            this.columnRules[j] = columnRule;
        }
        String[] solutionRows = parts[3 + numRows + numColumns].split(" ");
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                this.solution[i][j] = solutionRows[i].charAt(j) == '1';
            }
        }

        clear();
    }

}
