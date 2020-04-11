
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReader {
    private String filename;
    private ArrayList<ClosePriceDailyData> prices;

    public DataReader(String filename) {
        this.filename = filename;
        prices = new ArrayList<>();
    }

    /**
     * Read the data from csv file, and store the data in ArrayList.
     * @return
     */
    public ArrayList<ClosePriceDailyData> read(){
        File f = new File(filename);
        try {
            Scanner scan = new Scanner(f);
            scan.nextLine();
            while(scan.hasNext()) {
                String line = scan.nextLine();
                String[] lineElement = line.split(",");
                String[] date = lineElement[0].split("-");
                int year = Integer.parseInt(date[0]);
                int month = Integer.parseInt(date[1]);
                int day = Integer.parseInt(date[2]);
                double closePrice = Double.parseDouble(lineElement[3]);

                ClosePriceDailyData price = new ClosePriceDailyData(year, month, day, closePrice);
                prices.add(price);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return prices;
    }
}
