package andris.day1;


import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class TimeTravelDevice
{

    public List<Integer> frequencyChangeList;

    private int frequency;

    public TimeTravelDevice()
    {
        frequency = 0;
    }

    public TimeTravelDevice(int initFreq)
    {
        frequency = initFreq;
    }

    public int GetFrequency()
    {
        return frequency;
    }

    public void UpdateFrequency(int freqChange)
    {
        frequency += freqChange;
    }

    public void UpdateFrequency(List<Integer> freqChanges)
    {
        for (int df : freqChanges)
        {
            UpdateFrequency(df);
        }
    }

    public void LoadFrequencyChangeList(String filePath)
    {
        frequencyChangeList = new ArrayList<Integer>();
        try
        {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
    
            while (sc.hasNextLine())
            {
                int freqChange = Integer.parseInt(sc.nextLine());
                frequencyChangeList.add(freqChange);
            }
            sc.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("ERROR: Unable to find file: " + filePath);
            e.printStackTrace();
        }
    }

    public void CalibrateFrequency()
    {
        List<Integer> uniqueFrequencies = new ArrayList<Integer>();

        int idx = 0;
        int fileLoopCounter = 0;
        boolean repeatFrequencyReached = false;
        while (!repeatFrequencyReached)
        {
            UpdateFrequency(frequencyChangeList.get(idx));
            
            if (uniqueFrequencies.contains(frequency))
            {
                repeatFrequencyReached = true;
            }
            else
            {
                uniqueFrequencies.add(frequency);

                idx += 1;
                if (idx >= frequencyChangeList.size())
                {
                    idx = 0;
                    fileLoopCounter += 1;
                }
            }
        }

        System.out.println("Frequency calibration converged!");
        System.out.println("\tIterations: " + String.format("%d", (fileLoopCounter * frequencyChangeList.size()) + idx));
    }

}
