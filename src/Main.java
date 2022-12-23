import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            HashMap<Integer, String> rucksacks;
            rucksacks = importData();
            System.out.println(dupeFinder(rucksacks));
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

    public static int dupeFinder(HashMap<Integer, String> rucksacks) {
        int sum = 0;
        for (int i = 0; i < 298; i += 3) {
            HashMap<Character, Character> rucksack1 = new HashMap<>();
            HashMap<Character, Character> rucksack2 = new HashMap<>();
            HashMap<Character, Character> rucksack3 = new HashMap<>();
            int[] orderedSacks = sortSacksBigToSmall(i, rucksacks);
            rucksackPuter(rucksack1, rucksacks.get(orderedSacks[0]));
            rucksackPuter(rucksack2, rucksacks.get(orderedSacks[1]));
            rucksackPuter(rucksack3, rucksacks.get(orderedSacks[2]));
            for (int j = 65; j < 123; j ++) {
                if (j > 90 && j < 97) {
                    continue;
                }
                char c = (char) j;
                if (rucksack1.containsValue(c) && rucksack2.containsValue(c) && rucksack3.containsValue(c)) {
                    if (Character.isUpperCase(c)) {
                        sum += j - 38;
                    } else {
                        sum += j - 96;
                    }
                    break;
                }
            }
        }
        return sum;
    }

    public static int[] sortSacksBigToSmall(int i, HashMap<Integer, String> rucksacks) {
        int[] orderedSacks = new int[3];
        if (rucksacks.get(i).length() > rucksacks.get(i + 1).length() && rucksacks.get(i).length() > rucksacks.get(i + 2).length()) {
            orderedSacks[0] = i;
            if (rucksacks.get(i + 1).length() > rucksacks.get(i + 2).length()) {
                orderedSacks[1] = i + 1;
                orderedSacks[2] = i + 2;
            } else {
                orderedSacks[1] = i + 2;
                orderedSacks[2] = i + 1;
            }
        } else if (rucksacks.get(i + 1).length() > rucksacks.get(i + 2).length()) {
            orderedSacks[0] = i + 1;
            if (rucksacks.get(i).length() > rucksacks.get(i + 2).length()) {
                orderedSacks[1] = i;
                orderedSacks[2] = i + 2;
            } else {
                orderedSacks[1] = i + 2;
                orderedSacks[2] = i;
            }
        } else {
            orderedSacks[0] = i + 2;
            if (rucksacks.get(i).length() > rucksacks.get(i + 1).length()) {
                orderedSacks[1] = i;
                orderedSacks[2] = i + 1;
            } else {
                orderedSacks[1] = i + 1;
                orderedSacks[2] = i;
            }
        }
        return orderedSacks;
    }

    public static void rucksackPuter(HashMap<Character, Character> currentRucksack, String stringOfSack) {
        for (int j = 0; j < stringOfSack.length(); j++) {
            currentRucksack.put(stringOfSack.charAt(j), stringOfSack.charAt(j));
        }
    }
}