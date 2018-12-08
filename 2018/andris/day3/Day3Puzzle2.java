import FileReader;
import Claim;
import InvalidClaimException;

import java.util.List;
import java.util.ArrayList;

public class Day3Puzzle2
{

    private static int FindNonOverlappingClaim(List<Claim> claims)
    {
        for (int cIdx = 0; cIdx < claims.size(); cIdx++)
        {
            Claim claim = claims.get(cIdx);
            boolean overlapFound = false;
            for (int oIdx = 0; oIdx < claims.size(); oIdx++)
            {   
                if (cIdx != oIdx)
                {
                    Claim other = claims.get(oIdx);
                    for (int x = 0; x < claim.getWidth(); x++)
                    {
                        for (int y = 0; y < claim.getHeight(); y++)
                        {
                            if (other.isCovered(claim.getMarginLeft() + x, claim.getMarginTop() + y))
                            {
                                overlapFound = true;
                            }
                        }
                    }
                }
            }
            if (!overlapFound) {
                return claim.getIdentifier();
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        System.out.println("Day 3 - Puzzle 2");

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

        System.out.println("Finding non-overlapping claim...");
        int claimID = FindNonOverlappingClaim(claims);
        System.out.println("\tClaim: " + claimID);
    }

}
