import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GUIPuzzle extends JFrame {
    private GamePanel gamePanel;
    private NonogramStore store;
    public GUIPuzzle() {
        super("Nonogram");
        store = new NonogramStore("path to the Nonogram.txt file");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1024,768);
        add(createConfigurationsPanel(), BorderLayout.WEST);
        add(createControlPanel(), BorderLayout.SOUTH);
        add(createGamePanel(), BorderLayout.CENTER);
    }
    private void addBorder(JComponent component, String title) {
        Border etch = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        Border tb = BorderFactory.createTitledBorder(etch, title);
        component.setBorder(tb);
    }
    private JPanel createGamePanel() {
        JPanel gamePanelContainer = new JPanel(new BorderLayout());
        addBorder(gamePanelContainer, "Game Panel");
        Nonogram nonogram = store.getNonogramsSorted().get(0);
        gamePanel = new GamePanel(nonogram);
//        gamePanelContainer.add(gamePanel, BorderLayout.CENTER);
        return gamePanelContainer;
    }
    private JPanel createConfigurationsPanel() {
        JPanel conf = new JPanel();
        addBorder(conf, "Puzzles");

        DefaultListModel<Nonogram> nonogramListModel = new DefaultListModel<>();
        ArrayList<Nonogram> nonogramsSorted = store.getNonogramsSorted();
        for (Nonogram nonogram : nonogramsSorted) {
            nonogramListModel.addElement(nonogram);
        }

        JList<Nonogram> nonogramList = new JList<>(nonogramListModel);
        nonogramList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        nonogramList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Nonogram selectedNonogram = nonogramList.getSelectedValue();
                    gamePanel.setNonogram(selectedNonogram);
                    gamePanel.getNonogram().clear();
                    GamePanel.showIfIsSolved = false;
                    GamePanel.isSolved = false;
                    repaint();
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(nonogramList);
        conf.add(scrollPane, BorderLayout.CENTER);

        return conf;
    }
    private JPanel createControlPanel() {
        JPanel ctrl =  new JPanel();
        addBorder(ctrl, "Controls");

        JButton isSolvedButton = new JButton("Is Solved");
        isSolvedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GamePanel.showIfIsSolved = true;
                repaint();
            }
        });

        JButton showSolutionButton = new JButton("Show Solution");
        showSolutionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fillWithSolution();   //from Nonogram
                repaint();
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clear();    //from Nonogram
                repaint();
            }
        });

        JButton saveAsImageButton = new JButton("Save As Image");
        saveAsImageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Nonogram n = new Nonogram();
                int width = n.getWidth();
                int height = n.getHeight();
                BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                image.setRGB(10, 10, new Color(49, 119, 115).getRGB());

                try {
                    ImageIO.write(image, "png", new File("Path where you want to save the file" + name of the file +".png"));
                } catch (IOException e) {

                }
            }
        });

        JTextField imageNameField = new JTextField();
        JLabel imageNameLabel = new JLabel("Name the image you want to save:");


        JPanel topRow = new JPanel();
        topRow.add(isSolvedButton);
        topRow.add(showSolutionButton);
        topRow.add(clearButton);

        JPanel bottomRow = new JPanel();
        bottomRow.add(imageNameLabel);
        bottomRow.add(imageNameField);
        bottomRow.add(saveAsImageButton);

        ctrl.setLayout(new GridLayout(2,1));
        ctrl.add(topRow);
        ctrl.add(bottomRow);

        return ctrl;
    }
}
