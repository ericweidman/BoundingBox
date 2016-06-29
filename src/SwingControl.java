import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by ericweidman on 6/26/16.
 */
public class SwingControl {


    JFrame mainFrame;
    JLabel headerLabel;
    JPanel controlPanel;


    public void prepareGUI() {
        mainFrame = new JFrame("User Input");
        mainFrame.setSize(500, 200);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerLabel = new JLabel("", JLabel.CENTER);


        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
    }

    public void showEvent() {


        headerLabel.setText("Please input coordinates");

        JTextField leftX = new JTextField("Left X", JLabel.CENTER);
        leftX.setPreferredSize(new Dimension(150, 20));
        JTextField rightX = new JTextField("Right X", JLabel.CENTER);
        rightX.setPreferredSize(new Dimension(150, 20));
        JTextField lowerY = new JTextField("Lower Y", JLabel.CENTER);
        lowerY.setPreferredSize(new Dimension(150, 20));
        JTextField upperY = new JTextField("Upper Y", JLabel.CENTER);
        upperY.setPreferredSize(new Dimension(150, 20));
        JButton submitButton = new JButton("Submit");

        controlPanel.add(leftX);
        controlPanel.add(rightX);
        controlPanel.add(lowerY);
        controlPanel.add(upperY);
        controlPanel.add(submitButton);

        mainFrame.setVisible(true);
    }
}
