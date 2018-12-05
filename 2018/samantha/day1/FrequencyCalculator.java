package samantha.day1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import sun.jvm.hotspot.utilities.IntArray;

public class FrequencyCalculator
{
    public static void main(String[] args){
        // Initialize variables
        int frequency = 0;
        List<Integer> freqList = new ArrayList<Integer>();
        String curLine;
        int nextNumber;
        boolean repeatFound = false;
        Scanner scan;

        //Add the initial frequency to the list
        freqList.add(frequency);

        //Read through the text file
        File input = new File("C:\\Users\\Samantha\\Documents\\Coding\\AdventOfCode\\2018\\samantha\\day1\\input_SEJ.txt");
        try {
            while (!repeatFound) {
                scan = new Scanner(input);
                while (scan.hasNextLine() && (!repeatFound)) {
                    
                    //Parse the next line into the operator and the number
                    curLine = scan.nextLine();
                    nextNumber =  Integer.parseInt(curLine);
                    frequency = frequency + nextNumber;

                    //Determine if frequency has repeated
                    if (freqList.contains(frequency)) {
                        System.out.format("First Repeated Frequency: %d\n", frequency);
                        repeatFound = true;
                    } else {
                        freqList.add(frequency);
                    }
                }
                scan.close();
            }
        } 
        catch (FileNotFoundException err) {
            err.printStackTrace();
        } 
    }

}
