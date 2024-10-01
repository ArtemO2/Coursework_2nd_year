import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VigenereEncoder {
    private static JTextField vigenereTextInput;
    private static JTextField vigenereKeyWordInput;
    private static JTextField vigenereField3;

    public static void runEncryptionDecryptionUI() {
        JFrame typeFrame = new JFrame("Select operation");
        typeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel typePanel = new JPanel(new FlowLayout());

        JButton encryptionButton = new JButton("Encryption");
        JButton decryptionButton = new JButton("Decryption");

        encryptionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runEncryptionUI();
            }
        });

        decryptionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runDecryptionUI();
            }
        });

        typePanel.add(encryptionButton);
        typePanel.add(decryptionButton);
        typeFrame.getContentPane().add(typePanel);
        typeFrame.setSize(200, 100);
        typeFrame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                runEncryptionDecryptionUI();
            }
        });
    }

    public static void runEncryptionUI() {
        JFrame vigenereFrame = new JFrame("Vigenère encryption");
        vigenereFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel vigenerePanel = new JPanel(new FlowLayout());

        JLabel vigenereTextInputAttention = new JLabel("Enter text:   ");
        vigenereTextInput = new JTextField(15);

        JLabel vigenereKeyWordInputAttention = new JLabel("Enter key word");
        vigenereKeyWordInput = new JTextField(12);

        JButton encryptButton = new JButton("Encrypt");

        vigenereField3 = new JTextField(20);

        encryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = vigenereTextInput.getText();
                String keyWord = vigenereKeyWordInput.getText();

                // Вызываем метод для шифрования
                String encryptedText = VigenereCipher.encrypt(text, keyWord);
                vigenereField3.setText(encryptedText);
            }
        });

        vigenerePanel.add(vigenereTextInputAttention);
        vigenerePanel.add(vigenereTextInput);
        vigenerePanel.add(vigenereKeyWordInputAttention);
        vigenerePanel.add(vigenereKeyWordInput);
        vigenerePanel.add(encryptButton);
        vigenerePanel.add(vigenereField3);

        vigenereFrame.getContentPane().add(vigenerePanel);
        vigenereFrame.setSize(300, 200);
        vigenereFrame.setVisible(true);
    }

    public static void runDecryptionUI() {
        JFrame vigenereDecryptionFrame = new JFrame("Decoding Vigenère");
        vigenereDecryptionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel vigenereDecryptionPanel = new JPanel(new FlowLayout());

        JLabel vigenereDecryptionTextInputAttention = new JLabel("Enter text:");
        JTextField vigenereDecryptionTextInput = new JTextField(15);

        JLabel vigenereDecryptionKeyWordInputAttention = new JLabel("Enter key word");
        JTextField vigenereDecryptionKeyWordInput = new JTextField(12);

        JButton decryptButton = new JButton("Decrypt");

        JTextField vigenereDecryptionField3 = new JTextField(20);

        decryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = vigenereDecryptionTextInput.getText();
                String keyWord = vigenereDecryptionKeyWordInput.getText();

                // Вызываем метод для дешифрования
                String decryptedText = VigenereCipher.decrypt(text, keyWord);
                vigenereDecryptionField3.setText(decryptedText);
            }
        });

        vigenereDecryptionPanel.add(vigenereDecryptionTextInputAttention);
        vigenereDecryptionPanel.add(vigenereDecryptionTextInput);
        vigenereDecryptionPanel.add(vigenereDecryptionKeyWordInputAttention);
        vigenereDecryptionPanel.add(vigenereDecryptionKeyWordInput);
        vigenereDecryptionPanel.add(decryptButton);
        vigenereDecryptionPanel.add(vigenereDecryptionField3);

        vigenereDecryptionFrame.getContentPane().add(vigenereDecryptionPanel);
        vigenereDecryptionFrame.setSize(300, 200);
        vigenereDecryptionFrame.setVisible(true);
    }


}
