import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class FileReader
{
    
    public static List<String> ParseStrings(String filePath)
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

    public static List<Integer> ParseIntegers(String filePath)
    {
        List<Integer> intList = new ArrayList<Integer>();
        try
        {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
    
            while (sc.hasNextLine())
            {
                intList.add(Integer.parseInt(sc.nextLine()));
            }
            sc.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("ERROR: Unable to find file: " + filePath);
            e.printStackTrace();
        }
        return intList;
    }

} 
