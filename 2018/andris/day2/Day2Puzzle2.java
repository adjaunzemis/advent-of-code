package andris.day2;

import andris.day2.BoxScanner;

import java.util.List;

public class Day2Puzzle2
{

    private static String testFilePath = "S:\\Projects\\AdventOfCode\\2018\\andris\\day2\\inputDay2_test2.txt";
    private static String boxIDFilePath = "S:\\Projects\\AdventOfCode\\2018\\andris\\day2\\inputDay2_adj.txt";

    private static String FindCommonCharacters(String a, String b)
    {
        String result = "";
        for (int idx = 0; idx < a.length(); idx++)
        {
            if (a.charAt(idx) == b.charAt(idx))
            {
                result += a.charAt(idx);
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        System.out.println("Day 2: Puzzle 2");

        System.out.println("Creating BoxScanner...");
        // BoxScanner boxScanner = new BoxScanner(testFilePath);
        BoxScanner boxScanner = new BoxScanner(boxIDFilePath);

        System.out.println("Finding prototype fabric boxes...");
        List<String> prototypeBoxIDs = boxScanner.FindPrototypeFabricBoxes();
        if (!prototypeBoxIDs.isEmpty())
        {
            for (String id : prototypeBoxIDs)
            {
                System.out.println("\t" + id);
            }

            String commonChars = FindCommonCharacters(prototypeBoxIDs.get(0), prototypeBoxIDs.get(1));
            System.out.println("Common characters: " + commonChars);
        }

    }

}
