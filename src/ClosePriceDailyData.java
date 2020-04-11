
public class ClosePriceDailyData {
    private int year;
    private int month;
    private int day;
    private double closePrice;

    /**
     * data of the stock price, only date and closePrice will be used for the project.
     * @param year
     * @param month
     * @param day
     * @param closePrice
     */
    public ClosePriceDailyData(int year, int month, int day, double closePrice){
        this.year = year;
        this.month = month;
        this.day = day;
        this.closePrice = closePrice;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public double getClosePrice() {
        return closePrice;
    }
}
