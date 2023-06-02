import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class GamePanel {
    private Nonogram nonogram; //puzzle to draw
    private int rows; //number of rows of the puzzle
    private int columns; //number of columns
    private int extraNumberOfRows; //maximum size of any single column rule
    private int extraNumberOfColumns; //maximum size of any single row rule
    private int xPadding; //horizontal padding size
    private int yPadding; //vertical padding size
    private int singleCell; //dimensions of a single cell
    public static boolean showIfIsSolved; //whether a string should be drawn that says
    //if the board is solved
    public static boolean isSolved; //shows if the board is solved
    protected void paintComponent(java.awt.Graphics g) {
        // Paint the background white
        g.setColor(java.awt.Color.WHITE);
        g.fillRect(0, 0, nonogram.getWidth(), nonogram.getHeight());
        // Sample drawing statements
        g.setColor(Color.BLACK);
        g.drawRect(200, 200, 30, 30);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(140, 140, 30, 30);
        g.fillRect(260, 140, 30, 30);
        g.setColor(Color.BLACK);
        g.drawLine(150, 300, 280, 300);
        g.drawString("@@@", 135,120);
        Font font = g.getFont();
        g.setFont(font.deriveFont(2.0f * font.getSize()));
        g.drawString("@@@", 255,120);
    }

    public GamePanel(Nonogram n) {
        nonogram = n;
        rows = (nonogram.getHeight()/singleCell)-xPadding;
        columns = (nonogram.getWidth()/singleCell)-yPadding;
        extraNumberOfRows = nonogram.rowRuleMaxSize();
        extraNumberOfColumns = nonogram.columnRuleMaxSize();
        xPadding = 20;
        yPadding = 20;

        singleCell = (int)(Math.min(nonogram.getWidth(), nonogram.getHeight())/ (Math.max(rows+nonogram.rowRuleMaxSize(), columns+nonogram.columnRuleMaxSize()))*0.98);

        addMouseListener(new MouseAdapter(this) {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                int row = (y - yPadding) / singleCell;
                int col = (x - xPadding) / singleCell;

                if (row >= 0 && row < rows && col >= 0 && col < columns) {
                    nonogram.flip(row, col);
                    showIfIsSolved = false;
                    isSolved = nonogram.checkIfSolved();
                    repaint();
                }
            }
        });
    }
    public Nonogram getNonogram() {
        return nonogram;
    }

    public void setNonogram(Nonogram n) {
        nonogram = n;
        rows = (nonogram.getHeight()/singleCell)-xPadding;
        columns = (nonogram.getWidth()/singleCell)-yPadding;
        extraNumberOfRows = nonogram.rowRuleMaxSize();
        extraNumberOfColumns = nonogram.columnRuleMaxSize();
        repaint();
    }
}
