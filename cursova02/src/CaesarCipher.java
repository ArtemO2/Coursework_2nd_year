public class CaesarCipher {
    public static String encrypt(String message, int key) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);

            if (Character.isLetter(currentChar)) {
                char base = Character.isLowerCase(currentChar) ? 'a' : 'A';
                char encryptedChar = (char) ((currentChar - base + key) % 26 + base);
                encryptedMessage.append(encryptedChar);
            } else {
                encryptedMessage.append(currentChar);
            }
        }

        return encryptedMessage.toString();
    }

    public static String decrypt(String encryptedMessage, int key) {
        StringBuilder decryptedMessage = new StringBuilder();

        for (int i = 0; i < encryptedMessage.length(); i++) {
            char currentChar = encryptedMessage.charAt(i);

            if (Character.isLetter(currentChar)) {
                char base = Character.isLowerCase(currentChar) ? 'a' : 'A';
                char decryptedChar = (char) ((currentChar - base - key + 26) % 26 + base);
                decryptedMessage.append(decryptedChar);
            } else {
                decryptedMessage.append(currentChar);
            }
        }

        return decryptedMessage.toString();
    }
}
