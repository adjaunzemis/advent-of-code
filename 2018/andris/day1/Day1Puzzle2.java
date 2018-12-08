package andris.day1;

import andris.day1.TimeTravelDevice;

public class Day1Puzzle2 {

    public static void main(String[] args)
    {
        System.out.println("Day 1 - Puzzle 2");

        System.out.println("Creating TimeTravelDevice");
        TimeTravelDevice device = new TimeTravelDevice();

        System.out.println("Loading frequency change list...");
        String inputFilePath = "S:\\Projects\\AdventOfCode\\2018\\andris\\day1\\inputDay1_adj.txt";
        device.LoadFrequencyChangeList(inputFilePath);

        System.out.println("Calibrating device frequency...");
        device.CalibrateFrequency();
        System.out.println("\tCalibrated Frequency: " + String.format("%d", device.GetFrequency()));
    }

}
