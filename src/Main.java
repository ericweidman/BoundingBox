import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Location> allLocations = new ArrayList<>();
        openFile(allLocations);


        System.out.println("X Value = " + allLocations.get(0).xValue);
        System.out.println("Y Value = " + allLocations.get(0).yValue);
        System.out.println("The data for this location = " + allLocations.get(0).data);

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
