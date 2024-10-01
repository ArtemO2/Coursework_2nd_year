public class VigenereCipher {
    private static String message;
    private static String mappedKey;

    public static String encrypt(String message, String key) {
        message = message.toUpperCase();
        key = key.toUpperCase();
        mappedKey = generateMappedKey(message, key);
        return performCipher(message, mappedKey, true);
    }

    public static String decrypt(String encryptedText, String key) {
        encryptedText = encryptedText.toUpperCase();
        key = key.toUpperCase();
        mappedKey = generateMappedKey(encryptedText, key);
        return performCipher(encryptedText, mappedKey, false);
    }

    private static String performCipher(String message, String mappedKey, boolean encrypt) {
        int[][] table = createVigenereTable();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);

            if (Character.isLetter(currentChar)) {
                int rowIndex = currentChar - 'A';
                int colIndex = mappedKey.charAt(i) - 'A';

                if (!encrypt) {

                    int colValue = table[colIndex][0];
                    for (int j = 1; j < 26; j++) {
                        if (table[colIndex][j] == rowIndex + 'A') {
                            colValue = j;
                            break;
                        }
                    }
                    result.append((char) ('A' + colValue));
                } else {
                    result.append((char) table[rowIndex][colIndex]);
                }
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    private static String generateMappedKey(String message, String key) {
        StringBuilder mappedKey = new StringBuilder();

        for (int i = 0, j = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            if (Character.isLetter(currentChar)) {
                mappedKey.append(key.charAt(j));
                j = (j + 1) % key.length();
            } else {
                mappedKey.append(" ");
            }
        }
        return mappedKey.toString();
    }

    private static int[][] createVigenereTable() {
        int[][] tableArr = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                int temp;
                if ((i + 'A') + j > 'Z') {
                    temp = ((i + 'A') + j) - 26;
                    tableArr[i][j] = temp;
                } else {
                    temp = (i + 'A') + j;
                    tableArr[i][j] = temp;
                }
            }
        }
        return tableArr;
    }
}
