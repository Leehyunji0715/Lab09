package edu.handong.csee.lab09.salesreport;
import java.util.Scanner;
public class SalesReporter {
	private double mhighestSales;
	private double maverageSales;
	private SalesAssociate[] team;
	private int numberOfAssociate;
	
	void getData() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of sales associates");
		numberOfAssociate = input.nextInt();
		//SalesAssociate[]salesMan = new SalesAssociate[numberOfAssociate];
		team = new SalesAssociate[numberOfAssociate];
		for(int i=0;i<numberOfAssociate;i++) {
			System.out.println("Enter data for associate number "+i);
			System.out.print("Enter name of sales associate: ");
			team[i].setmName(input.next());//salesMan[i].setmName(input.next());
			System.out.print("Enter associate's sales: ");
			//salesMan[i].setmSales(input.nextInt());
			team[i].setmSales(input.nextInt());
		}
	}
	void computeStats() {
		double sum = 0,currentBiggestComparecValue=0;
		for(int i=0;i<numberOfAssociate;i++) {
			sum += team[i].getmSales();
		}
		maverageSales = sum/3.0;
		System.out.println("Average sales per associate is $"+maverageSales);
		for(int i=0;i<numberOfAssociate;i++) {
			if(team[i].getmSales()>currentBiggestComparecValue) {
				currentBiggestComparecValue = team[i].getmSales();
			}
		}
		for(int i=0;i<numberOfAssociate;i++) {
			System.out.println("The highest sales figure is $"+currentBiggestComparecValue);
		}
		mhighestSales = currentBiggestComparecValue;
	}
	
	void displayResults() {
		
	}

}
