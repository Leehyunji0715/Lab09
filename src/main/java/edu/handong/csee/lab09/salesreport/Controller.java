package edu.handong.csee.lab09.salesreport;
/**
 * This class is for operating SalesAssociate and SalesReporter class
 * This class has main() method
 * 
 * @author leehyunji0715
 *
 */
public class Controller {//This class is public modifier named Controller

	public static void main(String[] args) {//use main()
		SalesReporter salesReport = new SalesReporter();//instantiate SalesReporter class naming salesReport
		salesReport.getData();//operate getData()
		salesReport.computeStats();//operate computeStats()
		salesReport.displayResults();//operate diplayResults()
	}

}
