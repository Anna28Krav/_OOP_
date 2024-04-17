package ex07;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeasurementCalculatorApp extends JFrame {
    private JPanel panel;
    private JButton calculateButton;
    private JTextField binaryLengthField;
    private JTextField binaryWidthField;
    private JTextField binaryHeightField;

    public MeasurementCalculatorApp() {
        setTitle("Binary Measurement Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(400, 200);
        setLocationRelativeTo(null); // Center the window on the screen

        // Set up button click listener
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get binary values from text fields
                String binaryLength = binaryLengthField.getText();
                String binaryWidth = binaryWidthField.getText();
                String binaryHeight = binaryHeightField.getText();

                // Calculate perimeter, area, and volume
                int perimeter = calculatePerimeter(binaryLength, binaryWidth, binaryHeight);
                int area = calculateArea(binaryLength, binaryWidth);
                int volume = calculateVolume(binaryLength, binaryWidth, binaryHeight);

                // Display the results
                JOptionPane.showMessageDialog(null,
                        "Perimeter: " + perimeter + "\n" +
                                "Area: " + area + "\n" +
                                "Volume: " + volume);
            }
        });
    }

    // Calculate perimeter using binary length, width, and height
    private int calculatePerimeter(String binaryLength, String binaryWidth, String binaryHeight) {
        int length = binaryToDecimal(binaryLength);
        int width = binaryToDecimal(binaryWidth);
        int height = binaryToDecimal(binaryHeight);

        return 2 * (length + width + height);
    }

    // Calculate area using binary length and width
    private int calculateArea(String binaryLength, String binaryWidth) {
        int length = binaryToDecimal(binaryLength);
        int width = binaryToDecimal(binaryWidth);

        return length * width;
    }

    // Calculate volume using binary length, width, and height
    private int calculateVolume(String binaryLength, String binaryWidth, String binaryHeight) {
        int length = binaryToDecimal(binaryLength);
        int width = binaryToDecimal(binaryWidth);
        int height = binaryToDecimal(binaryHeight);

        return length * width * height;
    }

    // Convert binary string to decimal integer
    private int binaryToDecimal(String binaryString) {
        return Integer.parseInt(binaryString, 2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MeasurementCalculatorApp().setVisible(true);
            }
        });
    }
}
