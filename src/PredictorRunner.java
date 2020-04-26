
public class PredictorRunner {

	
	private DataController dc;
	String forcastPrintInfomation;
	private String symbol;

	public PredictorRunner(String symbol) {
		this.symbol = symbol;
		dc = new DataController(symbol);
		forcastPrintInfomation = dc.forecastPrintInformation();
	}
	/**
	 * communicate with runner, return a String with all predicted information.
	 */
	public String printInformation() {
		return forcastPrintInfomation;
	}
	
	public void lineChart() {
		PredictLineChart plc = new PredictLineChart(symbol);
		plc.show();
	}


	/**
	 * two dataset we will use in the test: data1 is the Fibonacci Sequence, and we should get 233 for the next number;
     * data2 is the natural number with 1 increasing, and we should get 17 for the next number;
	 * main method used for test, myside.
	 * @param args
	 */
//    public static void main(String[] args){
//        DataController dc = new DataController("src/GSPC.csv");
//        double[] priceData = dc.getPriceData();
//        double[] testdata1 = new double[]{0,1,1,2,3,5,8,13,21,34,55,89,144};
//        double[] testdata2 = new double[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
//        System.out.println(dc.forecastControl(testdata1,4,1,3,1));
//        System.out.println(dc.forecastControl(testdata2,4,1,3,1));
//        
//        Double minRMS = Double.MAX_VALUE;
//        Double minVariance = Double.MAX_VALUE;
//        for(int i = 1; i <= 5; i++) {
//            for (int j = 1; j <= 1; j++) {
//                for (int k = 1; k <= 5; k++) {
//                    System.out.println(i + ";" + j + ";" + k + ":");
//                    System.out.println(dc.forecastControl(priceData, i, j, k, 7));
//                    ArrayList<double[]> res = dc.forecastData(priceData, i, j, k, 7);
//                    minRMS = Math.min(minRMS, Math.abs(res.get(3)[0]));
//                    minVariance = Math.min(minVariance, Math.abs(res.get(4)[0]));
//                }
//            }
//        }
//        System.out.println(minRMS);
//        System.out.println(minVariance);
//
//    }
}
