import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The Riddler:
 * A puzzle by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Eisha Yadav
 */
public class Riddler {

    public String decryptOne(String encrypted) {
        String decrypted = "";
        // Turn String into array of chars so it's easier to work with
        char[] charArray = encrypted.toCharArray();
        // Iterate through all of the chars and shift them by the cipher value
        // Currently shifting all by 9 because that's what we determined as a class after determining "the" and "and"
        int cipherValue = 9;
        for (char c : charArray){
            // Ignore if special char
            if (!Character.isLetter(c)){ decrypted+= c; continue;}
            // set to lowercase
            c = Character.toLowerCase(c);
            // Calc new ascii value
            int shift = c + cipherValue;
            // if greater than z then start from a
            // ascii val for lowercase z is 122
            final int MAX_ASCII_Z = 122;
            int diff = shift - MAX_ASCII_Z;
            char cShift;
            final int MIN_ASCII_A = 96;
            if (diff > 0){cShift = (char) (diff + MIN_ASCII_A);}
            else{cShift = (char) shift;}
            // Add shifted char to the final decrypted string
            decrypted += cShift;
        }
        // Print out decrypted val to test if sol'n is correct
        System.out.println("1. " + decrypted + "\n");
        return decrypted;
    }

    public String decryptTwo(String encrypted) {
        String decrypted = "";
        // Get a array of individual numbers from the space seperated numbers
        String[] intArr = encrypted.split(" ");
        // For each num in the array of nums convert to a char based on ascii val
        for(String num : intArr){decrypted += (char) Integer.parseInt(num);}
        // Print out decrypted val to test if sol'n is correct
        System.out.println("2. " + decrypted + "\n");
        return decrypted;
    }

    public String decryptThree(String encrypted) {
        String decrypted = "";
        // Iterate over each 8 bit sequence and convert to char from binary sequence
        // Get len of input
        int len = encrypted.length();
        final int BIT_SEQ_LEN = 8;
        for(int i = 0; i < len; i += BIT_SEQ_LEN){
            // Get 8 bit seq
            String seq = encrypted.substring(i, i+8);
            // Make it an int and append to decrypted
            // Radix should be 2 to convert from binary
            // Radix for decimal would be 10, which is assumed as default
            // Hence we didn't need to explicitly name it during the previous puzzle
            decrypted += (char) Integer.parseInt(seq, 2);
        }
        System.out.println("3. " + decrypted + "\n");
        return decrypted;
    }

    public String decryptFour(String encrypted) {
        String decrypted = "";
        char[] charArr = encrypted.toCharArray();
        // Used when trying to decipher to visualize array numerically
        // All values were really large, so i found the minimum and subtracted it, and then added 96 (the min ascii char val for a)
        List<Integer> numList = new ArrayList<>();
        for (char c : charArr){numList.add((int) c);}
        // Find min (only need to do once) -> got 9951
        // System.out.println(Collections.min(numList));
        final int MIN = 9951;
        // For each number subtract the minimum
        // Convert it to lowercase IF it is a letter
        // For spaces, hyphens, commas, and capital letters there is a different cipher
        // It is shifted over an additional 32
        // This was found by googling the poem based on the lowercase and trying to get "," to "L"
        final int SPECIAL_CHAR_SHIFT = 32;
        for(int num : numList){
            char newChar = (char) (num - MIN);
            if(Character.isLetter(newChar)){decrypted += Character.toLowerCase(newChar);}
            else{decrypted += (char) (newChar + SPECIAL_CHAR_SHIFT);}
        }
        System.out.println("4. " + decrypted + "\n");
        return decrypted;
    }
}
