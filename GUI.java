/**
 * This is my code! Its goal is to display the tables
 * of passengers in a GUI
 * CS312 - Assignment 8 (Extra Credit)
 * @author Molly O'Hare
 * @version 1
 */
import javax.swing.*;

public class GUI extends JPanel
{
    private String content;

    public GUI(String content)
    {
        this.content = content;

        // Create and setup window
        JFrame frame = new JFrame("Seating Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the label
        JLabel label = new JLabel(content);
        frame.getContentPane().add(label);

        frame.setSize(300, 300);
        frame.setResizable(false);

        // Display window
        frame.pack();
        frame.setVisible(true);
    }
}
