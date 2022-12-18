import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            HashMap<Integer, String> rucksacks;
            rucksacks = importData();
            char[] dupes = dupeFinder(rucksacks);
            int sum = counter(dupes);
            System.out.println(sum);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static HashMap<Integer, String> importData() throws FileNotFoundException {
        HashMap<Integer, String> rucksacks = new HashMap<>();
        FileInputStream fis = new FileInputStream("Rucksacks.txt");
        Scanner scan = new Scanner(fis);
        int i = 0;
        while (scan.hasNextLine()) {
            rucksacks.put(i, scan.nextLine());
            i++;
        }
        return rucksacks;
    }

    public static char[] dupeFinder(HashMap<Integer, String> rucksacks) {
        char[] dupes = new char[rucksacks.size()];
        for (int i = 0; i < 298; i += 3) {
            HashMap<Character, Integer> rucksack2 = new HashMap<>();
            HashMap<Character, Integer> rucksack3 = new HashMap<>();
            String[] orderedSacks = sortSacksBigToSmall(rucksacks.get(i), rucksacks.get(i + 1), rucksacks.get(i + 2));
            char[] rucksack1 = new char[orderedSacks[0].length()];
            //not dry, but breaking it into its own method adds another loop :(
            for (int j = 0; j < orderedSacks[0].length(); j++) {
                rucksack1[j] = (orderedSacks[0].charAt(j));
            }
            for (int j = 0; j < orderedSacks[1].length(); j++) {
                rucksack2.put(orderedSacks[1].charAt(j), 1);
            }
            for (int j = 0; j < orderedSacks[2].length(); j++) {
                rucksack3.put(orderedSacks[2].charAt(j), 1);
            }
            for (int j = 0; j < rucksack1.length; j ++) {
                if (rucksack2.containsKey(rucksack1[j]) && rucksack3.containsKey(rucksack1[j])) {
                    dupes[i] = rucksack1[j];
                }
            }
        }
        return dupes;
    }

    public static int counter(char[] dupes) {
        int sum = 0;
        for (int i = 0; i < dupes.length; i++) {
            switch (dupes[i]) {
                case 'a':  sum += 1; break;
                case 'b':  sum += 2; break;
                case 'c':  sum += 3; break;
                case 'd':  sum += 4; break;
                case 'e':  sum += 5; break;
                case 'f':  sum += 6; break;
                case 'g':  sum += 7; break;
                case 'h':  sum += 8; break;
                case 'i':  sum += 9; break;
                case 'j':  sum += 10; break;
                case 'k':  sum += 11; break;
                case 'l':  sum += 12; break;
                case 'm':  sum += 13; break;
                case 'n':  sum += 14; break;
                case 'o':  sum += 15; break;
                case 'p':  sum += 16; break;
                case 'q':  sum += 17; break;
                case 'r':  sum += 18; break;
                case 's':  sum += 19; break;
                case 't':  sum += 20; break;
                case 'u':  sum += 21; break;
                case 'v':  sum += 22; break;
                case 'w':  sum += 23; break;
                case 'x':  sum += 24; break;
                case 'y':  sum += 25; break;
                case 'z':  sum += 26; break;
                case 'A':  sum += 27; break;
                case 'B':  sum += 28; break;
                case 'C':  sum += 29; break;
                case 'D':  sum += 30 ;break;
                case 'E':  sum += 31; break;
                case 'F':  sum += 32; break;
                case 'G':  sum += 33; break;
                case 'H':  sum += 34; break;
                case 'I':  sum += 35; break;
                case 'J':  sum += 36; break;
                case 'K':  sum += 37; break;
                case 'L':  sum += 38; break;
                case 'M':  sum += 39; break;
                case 'N':  sum += 40; break;
                case 'O':  sum += 41; break;
                case 'P':  sum += 42; break;
                case 'Q':  sum += 43; break;
                case 'R':  sum += 44; break;
                case 'S':  sum += 45; break;
                case 'T':  sum += 46; break;
                case 'U':  sum += 47; break;
                case 'V':  sum += 48; break;
                case 'W':  sum += 49; break;
                case 'X':  sum += 50; break;
                case 'Y':  sum += 51; break;
                case 'Z':  sum += 52; break;
            }
        }
        return sum;
    }

    public static String[] sortSacksBigToSmall(String firstSack, String secondSack, String thirdSack) {
        String[] orderedSacks = new String[3];
        if (firstSack.length() > secondSack.length() && firstSack.length() > thirdSack.length()) {
            orderedSacks[0] = firstSack;
            if (secondSack.length() > thirdSack.length()) {
                orderedSacks[1] = secondSack;
                orderedSacks[2] = thirdSack;
            } else {
                orderedSacks[1] = thirdSack;
                orderedSacks[2] = secondSack;
            }
        } else if (secondSack.length() > thirdSack.length()) {
            orderedSacks[0] = secondSack;
            if (firstSack.length() > thirdSack.length()) {
                orderedSacks[1] = firstSack;
                orderedSacks[2] = thirdSack;
            } else {
                orderedSacks[1] = thirdSack;
                orderedSacks[2] = firstSack;
            }
        } else {
            orderedSacks[0] = thirdSack;
            if (firstSack.length() > secondSack.length()) {
                orderedSacks[1] = firstSack;
                orderedSacks[2] = secondSack;
            } else {
                orderedSacks[1] = secondSack;
                orderedSacks[2] = firstSack;
            }
        }
        return orderedSacks;
    }
}