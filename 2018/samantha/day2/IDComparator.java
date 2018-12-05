import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IDComparator
{
    public static void main(String[] args) {
        // Initialize variables
        String filepath = "C:\\Users\\Samantha\\Documents\\Coding\\AdventOfCode\\2018\\samantha\\day2\\input_SEJ.txt";
        ArrayList<String> fileCopy = new ArrayList<String>();
        String curID = "";
        int idNum = 0;
        int length = 0;
        int comparator = 0;
        boolean matchFound = false;

        //Copy the file
        fileCopy = readFile(filepath);
        
        //Pull each ID and compare it with the remaining IDs in the list
        while (!matchFound && idNum < fileCopy.size()) {
            curID = fileCopy.get(idNum);
            length = curID.length();
            for (String i : fileCopy) {
                for (int j = 0; j<length; j++) {
                    if (curID.charAt(j) != i.charAt(j)) {
                        comparator++;
                    }                   
                }
                if (comparator == 1){
                    matchFound = true;
                    System.out.println("First ID: " + curID + "\nSecond ID: " + i);
                }
                comparator = 0;
            }
            idNum++;
        }

        
    }
    public static ArrayList<String> readFile (String filepath) {
        ArrayList<String> fileCopy = new ArrayList<String>();
        File input = new File(filepath);
        try {       
            Scanner scan = new Scanner(input);
            while (scan.hasNextLine()) {
                fileCopy.add(scan.nextLine());
            }
            scan.close();
        } 
        catch (FileNotFoundException err) {
            err.printStackTrace();
        }

        return fileCopy;
    }
    
}