import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        double userUpperY = 180;
        double userLowerY = 179;
        double userLeftX = 359;
        double userRightX = 360;
        String writeThis = "";


        ArrayList<Location> outputLocations = new ArrayList<>();
        ArrayList<Location> allLocations = new ArrayList<>();
        openFile(allLocations);


        for (Location location : allLocations) {
            if ((location.getxValue() >= userLeftX && location.getxValue() <= userRightX) && (location.getyValue() >= userLowerY && location.getyValue() <= userUpperY)) {
                outputLocations.add(location);

            }
        }

        for (Location location : outputLocations) {
            writeThis += Double.toString(location.getxValue()) + "," + Double.toString(location.getyValue()) + "," + Double.toString(location.getData()) + "\n";

        }
        saveFile("query_results.txt", writeThis);
    }


    static void openFile(ArrayList<Location> allLocations) throws FileNotFoundException {
        File f = new File("sample_data.csv");
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split(",");
            Location location = new Location(Double.parseDouble(columns[0]), Double.parseDouble(columns[1]), Double.parseDouble(columns[2]));
            allLocations.add(location);
        }
    }

    static void saveFile(String fileName, String fileContent) throws IOException {
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(fileContent);
        fw.close();
    }
}
