
public class PredictorRunner {

	/**
	 * communicate with runner, return a String with all predicted information.
	 */
	public String toRunner() {
		DataController dc = new DataController("GSPC.csv");
		double[] priceData = dc.getPriceData();
		return dc.forecastControl(priceData,4,1,3,30);
	}
	
	/**
	 * two dataset we will use in the test: data1 is the Fibonacci Sequence, and we should get 233 for the next number;
     * data2 is the natural number with 1 increasing, and we should get 17 for the next number;
	 * main method used for test, myside.
	 * @param args
	 */
    public static void main(String[] args){
        DataController dc = new DataController("GSPC.csv");
        double[] priceData = dc.getPriceData();
        double[] testdata1 = new double[]{0,1,1,2,3,5,8,13,21,34,55,89,144};
        double[] testdata2 = new double[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        System.out.println(dc.forecastControl(testdata1,4,1,3,1));
        System.out.println(dc.forecastControl(testdata2,4,1,3,1));
        for(int i = 1; i <= 10; i++){
            for(int j = 1; j <= 10; j ++){
                System.out.println(dc.forecastControl(priceData,i,1,j,30));
            }
        }

    }
}
