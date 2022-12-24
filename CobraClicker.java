import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CobraClicker extends JComponent implements Runnable {
    int curX; // current mouse x coordinate
    int curY; // current mouse y coordinate
    int oldX; // previous mouse x coordinate
    int oldY; // previous mouse y coordinate
    String key;


    JButton enterButton; // button to enter information
    JTextField strTextField; // text field for input

    CobraClicker clicker; // variable of the type SimplePaint

    public CobraClicker() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // set oldX and oldY coordinates to beginning mouse press
                oldX = e.getX();
                oldY = e.getY();
            }
        });


        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // set current coordinates to where mouse is being dragged
                curX = e.getX();
                curY = e.getY();

                // draw the line between old coordinates and new ones

                // refresh frame and reset old coordinates
                repaint();
                oldX = curX;
                oldY = curY;

            }
        });
    }


    public void run() {
        JFrame frame = new JFrame("CobraClicker");
        Container content = frame.getContentPane();




        content.setLayout(new BorderLayout());
        clicker = new CobraClicker();
        content.add(clicker, BorderLayout.CENTER);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);


        // stuff for top panel
        // choose buttons for autoclicker
        String[] keys = {"M1" , "M3" , "M4" , "F1"};
        JComboBox<String> pickKey = new JComboBox<>(keys);
        JLabel text = new JLabel();
        text.setText("Key");
        JLabel cps = new JLabel();
        cps.setText("CPS");

        strTextField = new JTextField(10);
        enterButton = new JButton("Enter");
        JPanel topPanel = new JPanel();
        topPanel.add(text);
        topPanel.add(pickKey);
        topPanel.add(cps);
        topPanel.add(strTextField);
        topPanel.add(enterButton);
        JCheckBox toggle =new JCheckBox("Toggle");
        JCheckBox hold =new JCheckBox("Hold");
        topPanel.add(toggle);
        content.add(topPanel, BorderLayout.NORTH);

        // stuff for middle






        // stuff for bottom

        toggle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (toggle.isSelected()) {
                    System.out.print("toggle");

                }
            }
        });
        pickKey.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                key = (String)pickKey.getSelectedItem();
                System.out.println(key);

            }
        });
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int cps = Integer.valueOf(strTextField.getText());
                System.out.println(key);

            }
        });


    }

    public void setCps(int cps) {
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new CobraClicker());
    }
}
