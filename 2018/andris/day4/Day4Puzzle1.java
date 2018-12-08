import FileReader;
import Record;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Day4Puzzle1
{

    public static void main(String[] args)
    {
        System.out.println("Day 4 - Puzzle 1:");

        String testFile = "S:\\Projects\\AdventOfCode\\2018\\andris\\day4\\inputDay4_test.txt";
        String inputFile = "S:\\Projects\\AdventOfCode\\2018\\andris\\day4\\inputDay4_adj.txt";

        System.out.println("Reading guard records...");
        List<String> recordStrs = FileReader.ParseStrings(inputFile);
        System.out.println(String.format("\tRecords: %d", recordStrs.size()));
        
        List<Record> records = new ArrayList<Record>();
        for (String recordStr : recordStrs)
        {
            Record rec = new Record(recordStr);
            records.add(rec);
            // System.out.println("\t\t" + rec.toString());
        }

        Collections.sort(records);
        System.out.println("\tSorted");
        for (Record rec : records)
        {
            System.out.println("\t\t" + rec.toString());
        }

    }

}