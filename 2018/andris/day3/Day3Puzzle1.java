import FileReader;
import Claim;
import InvalidClaimException;

import java.util.List;
import java.util.ArrayList;

public class Day3Puzzle1
{

    private static int ComputeOverlappingArea(List<Claim> claims, int xMax, int yMax)
    {
        int areaCovered = 0;
        int x = 0;
        while (x <= xMax)
        {
            int y = 0;
            while (y <= yMax)
            {
                int coverageCount = 0;
                int cIdx = 0;
                while ((coverageCount <= 1) && (cIdx < claims.size()))
                {
                    if (claims.get(cIdx).isCovered(x, y)) {
                        coverageCount++;
                        if (coverageCount >= 2) {
                            areaCovered++;
                        }
                    }
                    cIdx++;
                }
                y++;
            }
            x++;
        }
        return areaCovered;
    }

    public static void main(String[] args)
    {
        System.out.println("Day 3 - Puzzle 1");

        // String filePath = "S:\\Projects\\AdventOfCode\\2018\\andris\\day3\\inputDay3_test.txt";
        String filePath = "S:\\Projects\\AdventOfCode\\2018\\andris\\day3\\inputDay3_adj.txt";
        List<String> fileStrings = FileReader.ParseStrings(filePath);

        System.out.println("Reading claims...");
        List<Claim> claims = new ArrayList<Claim>(fileStrings.size());
        for (int idx = 0; idx < fileStrings.size(); idx++)
        {
            try
            {
                claims.add(new Claim(fileStrings.get(idx)));
            }
            catch (InvalidClaimException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("\tParsed " + claims.size() + " claims");

        System.out.println("Determining overlap...");
        int areaOverlap = ComputeOverlappingArea(claims, 1000, 1000);
        System.out.println("\tOverlap: " + areaOverlap + " sq. in.");
    }

}
