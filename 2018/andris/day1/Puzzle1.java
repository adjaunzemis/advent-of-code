package andris.day1;

import andris.day1.TimeTravelDevice;

public class Puzzle1 {

    public static void main(String[] args)
    {
        System.out.println("Day 1 - Puzzle 1");

        System.out.println("Creating TimeTravelDevice");
        TimeTravelDevice device = new TimeTravelDevice();

        System.out.println("Loading frequency change list...");
        String inputFilePath = "S:\\Projects\\AdventOfCode\\2018\\andris\\day1\\input_adj.txt";
        device.LoadFrequencyChangeList(inputFilePath);

        System.out.println("Computing final frequency...");
        System.out.println("\tInitial: " + String.format("%d", device.GetFrequency()));
        device.UpdateFrequency(device.frequencyChangeList);
        System.out.println("\tFinal: " + String.format("%d", device.GetFrequency()));
    }

}
