import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        double userUpperY = 180;
        double userLowerY = 150;
        double userLeftX = 245;
        double userRightX = 360;
        String writeThis = "";


        ArrayList<Location> outputLocations = new ArrayList<>();
        ArrayList<Location> allLocations = new ArrayList<>();
        openFile(allLocations);


        outputLocations.addAll(allLocations.stream().filter(location -> (location.getxValue() >= userLeftX && location.getxValue()
                <= userRightX) && (location.getyValue() >= userLowerY && location.getyValue() <= userUpperY)).collect(Collectors.toList()));

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
