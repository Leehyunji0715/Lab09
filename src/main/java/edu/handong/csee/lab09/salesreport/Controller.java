package edu.handong.csee.lab09.salesreport;
public class Controller {

	public static void main(String[] args) {
		SalesReporter salesReport = new SalesReporter();
		salesReport.getData();
		salesReport.computeStats();
		salesReport.displayResults();
	}

}
