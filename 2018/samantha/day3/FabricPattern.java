package samantha.day3;
import samantha.utilities;
import java.util.ArrayList;


public class FabricPattern {

    public static void main(String[] args) {
        //Read input file
        String filepath = "C:\\Users\\Samantha\\Documents\\Coding\\AdventOfCode\\2018\\samantha\\day3\\input_SEJ.txt";        
        ArrayList<String> fileCopy = FileReader.readFile(filepath);
        
        // Create fabric template
        int fabWidth = 1000;
        int fabLength = 1000;
        int [] [] fabric = new int [fabWidth] [fabLength];

        String delim = "[ ,x:]+";
        String[] tokens;
        int id;
        int fromLeft, fromTop, width, length;
        //Parse input lines to extract each piece of information
        for (String i : fileCopy) {
            tokens = i.split(delim);
            id = Integer.parseInt(tokens[0].substring(1));
            fromLeft = Integer.parseInt(tokens[2]);
            fromTop = Integer.parseInt(tokens[3]);
            width = Integer.parseInt(tokens[4]);
            length = Integer.parseInt(tokens[5]);
            
            //Add 1 to the areas that would be cut
            for (int x = fromLeft; x < (fromLeft + width); x++) {
                for (int y = fromTop; y < (fromTop + length); y++) {
                    fabric[x][y]++;
                }
            }
        }

        //Calculate total square inches used by multiple claims and the dimensions of the unique claim
        int total = 0;
               
        for (int x = 0; x < fabWidth; x++) {
            for (int y = 0; y < fabLength; y++) {
                if (fabric[x][y] > 1) {
                    total++;
                }
            }
        }
        System.out.println("Total square inches: " + total);

        //Search for the unique claim
        boolean found = false;
        int uniqueTotal;

        int i = 0;
        while (i < fileCopy.size() && !found) {
            tokens = fileCopy.get(i).split(delim);
            id = Integer.parseInt(tokens[0].substring(1));
            fromLeft = Integer.parseInt(tokens[2]);
            fromTop = Integer.parseInt(tokens[3]);
            width = Integer.parseInt(tokens[4]);
            length = Integer.parseInt(tokens[5]);

            uniqueTotal = 0;
            for (int x = fromLeft; x < (fromLeft + width); x++) {
                for (int y = fromTop; y < (fromTop + length); y++) {
                    if (fabric[x][y] == 1) {
                        uniqueTotal++;
                    } 
                }
            }

            if (uniqueTotal == width * length) {
                System.out.println("Unique ID: " + id);
            }  
            
            i++;
        }
    }
}