import java.util.*;
import java.io.*;

public class StockMarket {
    boolean debug = true;

    ArrayList<String[]> input = new ArrayList<String[]>();

    private void log(String s) {
        if (debug) {
          System.out.print(s);
        }      
    }  
       
    private boolean readData(String filename) {
        File f=new File(filename);
               
        int ct = 0;
        try {  
          Scanner fileReader=new Scanner(f);
          while(fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] values = line.split(",");
            input.add(values);
                               
            log(ct + ": ");
            if (ct == 0) {  // Get field names.
              for (String v : values) { log(v + " "); }
              log("\n");
            } else {
              for (String v : values) { log(v); }
              log("\n");
            }          
                               
            ct += 1;    
          }      
          fileReader.close();
                               
          log("Number of records read: " + ct + "\n");
          log("Input size: " + input.size() + "\n");


                 
          return true;
        } catch (FileNotFoundException e) {
          System.out.println("Error: " + e);
          return false;
        }      
       
    }  
       
    public static void main(String[] args) {
        StockMarket m = new StockMarket();
        m.readData("/Users/anna/Desktop/AAPL.csv");
    }  

}

	        

