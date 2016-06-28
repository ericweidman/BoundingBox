import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        double userUpperY = 180;
        double userLowerY = 0;
        double userLeftX = 0;
        double userRightX= 360;

        ArrayList<Location> outputLocations = new ArrayList<>();
        ArrayList<Location> allLocations = new ArrayList<>();
        openFile(allLocations);


        for (Location location : allLocations) {
            if((location.getxValue() >= userLeftX && location.getxValue() <= userRightX) && (location.getyValue() >= userLowerY && location.getyValue() <= userUpperY )){
             outputLocations.add(location);
            }
        }
        System.out.println(outputLocations.size());

    }

    static void openFile(ArrayList<Location> allLocations) throws FileNotFoundException {
        File f = new File("sample_data.csv");
        Scanner fileScanner = new Scanner(f);
        while(fileScanner.hasNext()){
            String line = fileScanner.nextLine();
            String[] columns = line.split(",");
            Location location = new Location(Double.parseDouble(columns[0]), Double.parseDouble(columns[1]), Double.parseDouble(columns[2]));
            allLocations.add(location);
        }
    }
}
