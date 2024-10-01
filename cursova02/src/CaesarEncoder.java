import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaesarEncoder {
    public static void runEncryptionDecryptionUI() {
        JFrame typeFrame = new JFrame("Select operation");
        typeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel typePanel = new JPanel(new FlowLayout());

        JButton encryptionButton = new JButton("Encryption");
        JButton decryptionButton = new JButton("Decryption");

        encryptionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame caesarFrame = new JFrame("Caesar encryption");
                caesarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel caesarPanel = new JPanel(new FlowLayout());

                JLabel caesarLabel_inputText_attention1 = new JLabel("Enter text:   ");
                JTextField caesarField = new JTextField(15);

                JLabel caesarInputNumbersattention = new JLabel("Enter shift  (1-25):");
                JTextField caesarField2InputNumbers = new JTextField(11);

                JTextField caesarField3 = new JTextField(20);

                JButton encryptButton = new JButton("Encrypt");
                encryptButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String text = caesarField.getText();
                        int shift = Integer.parseInt(caesarField2InputNumbers.getText());

                        String encryptedText = CaesarCipher.encrypt(text, shift);

                        caesarField3.setText(encryptedText);
                    }
                });

                caesarPanel.add(caesarLabel_inputText_attention1);
                caesarPanel.add(caesarField);
                caesarPanel.add(caesarInputNumbersattention);
                caesarPanel.add(caesarField2InputNumbers);
                caesarPanel.add(encryptButton);
                caesarPanel.add(caesarField3);

                caesarFrame.getContentPane().add(caesarPanel);
                caesarFrame.setSize(300, 200);
                caesarFrame.setVisible(true);

                typeFrame.dispose();
            }
        });


        decryptionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame caesarFrame = new JFrame("Decoding Caesar");
                caesarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel caesarPanel = new JPanel(new FlowLayout());

                JLabel caesarLabel_inputText_attention1 = new JLabel("Enter text    :");
                JTextField caesarField = new JTextField(15);

                JLabel caesarInputNumbersattention = new JLabel("Enter shift  (1-25):");
                JTextField caesarField2InputNumbers = new JTextField(11);

                JTextField caesarField3 = new JTextField(20);

                JButton decryptButton = new JButton("Decrypt");

                decryptButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String text = caesarField.getText();
                        int shift = Integer.parseInt(caesarField2InputNumbers.getText());

                        String decryptedText = CaesarCipher.decrypt(text, shift);

                        caesarField3.setText(decryptedText);
                    }
                });

                caesarPanel.add(caesarLabel_inputText_attention1);
                caesarPanel.add(caesarField);
                caesarPanel.add(caesarInputNumbersattention);
                caesarPanel.add(caesarField2InputNumbers);
                caesarPanel.add(decryptButton);
                caesarPanel.add(caesarField3);

                caesarFrame.getContentPane().add(caesarPanel);
                caesarFrame.setSize(300, 200);
                caesarFrame.setVisible(true);

                typeFrame.dispose();
            }
        });

        typePanel.add(encryptionButton);
        typePanel.add(decryptionButton);
        typeFrame.getContentPane().add(typePanel);
        typeFrame.setSize(200, 100);
        typeFrame.setVisible(true);
    }
}
