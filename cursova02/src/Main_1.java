import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout());

        JLabel label = new JLabel("Choose type of Encoder");
        JButton caesarButton = new JButton("Caesar");

        caesarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CaesarEncoder.runEncryptionDecryptionUI();
            }
        });

        JButton vigenereButton = new JButton("Vigenère");
        vigenereButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VigenereEncoder.runEncryptionDecryptionUI();
            }
        });

        panel.add(label);
        panel.add(caesarButton);
        panel.add(vigenereButton);

        frame.getContentPane().add(panel);
        frame.setSize(225, 150);
        frame.setVisible(true);
    }
}
