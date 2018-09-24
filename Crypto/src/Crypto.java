import java.util.Scanner;

public class Crypto {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter something you would like encrypted: ");
        String string =input.nextLine();
        System.out.print("Enter a number for the encryption key: ");
        Integer shift = input.nextInt();
        System.out.print("Enter a number to group the encrypted output by: ");
        Integer group = input.nextInt();
        System.out.println(encryptString(string, shift, group));

    }

    public static String normalizeText(String string) {
        string = string.replaceAll("\\W", "").toUpperCase();
        return string;
    }

    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    public static String ceasarify(String string, Integer shiftValue) {
        String baseString = shiftAlphabet(0);
        String compareString = shiftAlphabet(2);
        String outputString = "";

        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            int index = baseString.indexOf(letter);
            outputString += compareString.charAt(index);
        }
        return outputString;
    }

    public static String groupify(String string, Integer group) {
        String outputString = "";
        while (string.length() % group != 0) {
            string += "x";
        }
        int x = 1;
        for (int i = 0; i < string.length(); i++) {
            outputString += string.charAt(i);
            if (x == group) {
                outputString += " ";
                x = 0;
            }
            x++;
        }
        return outputString;
    }

    public static String encryptString(String string, Integer shiftValue, Integer groupSize) {
        String outputString = groupify(ceasarify(normalizeText(string), shiftValue), groupSize);
        return outputString;
    }
}



