package samantha.day2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

import sun.jvm.hotspot.utilities.IntArray;

public class ChecksumAlgorithm
{
    public static void main(String[] args){
        // Initialize variables
        Scanner scan;
        String curLine;
        int length;
        char curLetter;
        int letterNum;
        int [] alphabetCount = new int[26];  
        int numDoubles = 0;
        int numTriples = 0;

        //Read through the text file
        File input = new File("C:\\Users\\Samantha\\Documents\\Coding\\AdventOfCode\\2018\\samantha\\day2\\input_SEJ.txt");
        try {       
            scan = new Scanner(input);
            while (scan.hasNextLine()) {
                //Pull the next ID
                curLine = scan.nextLine();
                length = curLine.length();
                
                //Add ID letters to corresponding location in alphabetCount array 
                for (int i = 0; i<length; i++) {
                    curLetter = curLine.charAt(i);
                    letterNum = curLetter;
                    if (letterNum>=65 && letterNum<=90) {
                        letterNum = letterNum - 65;
                    } else if (letterNum>=97 && letterNum<=122) {
                        letterNum = letterNum - 97;
                    } else {
                        throw new java.lang.RuntimeException("Error: IDs should only contain alphabetic characters.");
                    }
                    alphabetCount[letterNum]++;
                }

                //Check for doubles or triples and update total counts
                if (doubles(alphabetCount)) {
                    numDoubles++;
                } 
                if (triples(alphabetCount)) {
                    numTriples++;
                }

                //Clear alphabetCount array
                Arrays.fill(alphabetCount,0);
            }
            scan.close();
            
        } 
        catch (FileNotFoundException err) {
            err.printStackTrace();
        }

        //Find checksum
        int checksum = numDoubles * numTriples;
        System.out.format("IDs with double letters present: %d\nIDs with triple letters present: %d\n\nChecksum: %d", numDoubles, numTriples, checksum);
        
    }
    public static boolean doubles (int[] alphabet) {
        for (int i : alphabet) {
            if (i == 2) {
                return true;
            }
        }

        return false;
    }

    public static boolean triples (int[] alphabet) {
        for (int i : alphabet) {
            if (i == 3) {
                return true;
            }
        }

        return false;
    }
}