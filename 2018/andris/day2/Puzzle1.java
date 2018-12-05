package andris.day2;

import andris.day2.BoxScanner;

public class Puzzle1
{

    private static String testFilePath = "S:\\Projects\\AdventOfCode\\2018\\andris\\day2\\input_test.txt";
    private static String boxIDFilePath = "S:\\Projects\\AdventOfCode\\2018\\andris\\day2\\input_adj.txt";

    public static void main(String[] args)
    {
        System.out.println("Day 2: Puzzle 1");

        System.out.println("Creating BoxScanner...");
        // BoxScanner boxScanner = new BoxScanner(testFilePath);
        BoxScanner boxScanner = new BoxScanner(boxIDFilePath);

        System.out.println("Computing box ID checksum...");
        int checksum = boxScanner.ComputeChecksum();
        System.out.println(String.format("\tBox ID checksum: %d", checksum));
    }

}
