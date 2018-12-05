package andris.day2;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class BoxScanner
{

    private List<String> boxIDList;

    public BoxScanner(String filePath)
    {
        boxIDList = ReadStringsFromFile(filePath);
    }

    private List<String> ReadStringsFromFile(String filePath)
    {
        List<String> stringList = new ArrayList<String>();
        try
        {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
    
            while (sc.hasNextLine())
            {
                stringList.add(sc.nextLine());
            }
            sc.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("ERROR: Unable to find file: " + filePath);
            e.printStackTrace();
        }
        return stringList;
    }

    public int ComputeChecksum()
    {
        int duplicates = 0;
        int triplicates = 0;
        for (String boxID : boxIDList)
        {
            int idx = 0;
            boolean hasDuplicate = false;
            boolean hasTriplicate = false;
            
            while (idx < boxID.length())
            {
                char curChar = boxID.charAt(idx);
                int numOccurrences = CountCharacterOccurrences(boxID, curChar);

                if (numOccurrences == 2)
                {
                    hasDuplicate = true;
                }
                if (numOccurrences == 3)
                {
                    hasTriplicate = true;
                }

                idx++;
            }

            if (hasDuplicate)
            {
                duplicates++;
            }
            if (hasTriplicate)
            {
                triplicates++;
            }
        }

        return duplicates * triplicates;
    }

    private int CountCharacterOccurrences(String str, char c)
    {
        return str.length() - str.replaceAll("" + c, "").length();
    }

    public List<String> FindPrototypeFabricBoxes()
    {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < boxIDList.size(); i++)
        {
            for (int j = 0; j < boxIDList.size(); j++)
            {
                if (countCharacterDifferences(boxIDList.get(i), boxIDList.get(j)) == 1)
                {
                    result.add(boxIDList.get(i));
                    result.add(boxIDList.get(j));
                    return result;
                }
            }
        }
        return result;
    }

    private int countCharacterDifferences(String a, String b)
    {
        int differences = 0;
        for (int idx = 0; idx < a.length(); idx++)
        {
            if (a.charAt(idx) != b.charAt(idx))
            {
                differences++;
            }
        }
        return differences;
    }

}
