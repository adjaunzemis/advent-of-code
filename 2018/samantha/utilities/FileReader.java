import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class FileReader {

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