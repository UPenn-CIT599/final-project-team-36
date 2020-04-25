

public class RunnerForTest_XU {

    /**
     * two dataset we will use in the test: data1 is the Fibonacci Sequence, and we should get 233 for the next number;
     * data2 is the natural number with 1 increasing, and we should ge 17, 18 for the next few number;
     */
    public static void main(String[] args){
    	PredictorRunner pr = new PredictorRunner();
    	System.out.println(pr.printInformation());
    	pr.lineChart();
    }
//        DataController dc = new DataController("src/GSPC.csv");
//        double[] priceData = dc.getPriceData();
//
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
//    }
}
