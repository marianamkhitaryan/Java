
public class SudokuCell {

    int value;
    boolean fixed;

    public SudokuCell(int value, boolean fixed) {

        this.value = value;
        this.fixed = fixed;

    }

    public int getValue() {

        return value;

    }

    public void setValue(int value) {

        this.value = value;

    }

    public boolean isFixed() {

        return fixed;

    }

    public void setFixed(boolean fixed) {

        this.fixed = fixed;

    }

}
