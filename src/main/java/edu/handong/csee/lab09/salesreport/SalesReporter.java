package edu.handong.csee.lab09.salesreport;
import java.util.Scanner;
public class SalesReporter {
	private double mhighestSales;
	private double maverageSales;
	private int numberOfAssociate;
	private SalesAssociate[] team;
	int biggestPersonNum;
	
	void getData() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of sales associates : ");
		numberOfAssociate = input.nextInt();
		team = new SalesAssociate[numberOfAssociate];
		for(int i=0;i<numberOfAssociate;i++) {
			System.out.println("Enter data for associate number "+(i+1));
			System.out.print("Enter name of sales associate: ");
			team[i] = new SalesAssociate();
			team[i].setmName(input.next());//salesMan[i].setmName(input.next());
			System.out.print("Enter associate's sales: ");
			team[i].setmSales(input.nextInt());
		}
	}
	void computeStats() {
		double sum = 0,currentBiggestComparecValue=0;
		int i;
		for(i=0;i<numberOfAssociate;i++) {
			sum += team[i].getmSales();
		}
		maverageSales = (sum/numberOfAssociate);
		System.out.println("Average sales per associate is $"+maverageSales);
		for(i=0;i<numberOfAssociate;i++) {
			if(team[i].getmSales()>currentBiggestComparecValue) {
				currentBiggestComparecValue = team[i].getmSales();
				biggestPersonNum = i;
			}
		}
		//for(i=0;i<numberOfAssociate;i++) {
			System.out.printf("The highest sales figure is $%.1f",currentBiggestComparecValue);
		//}
		mhighestSales = currentBiggestComparecValue;
	}
	
	void displayResults() {
		int j;
		SalesAssociate orderedTeam[] = new SalesAssociate[numberOfAssociate];
		for(int i=0;i<numberOfAssociate;i++) {
			orderedTeam[i] = new SalesAssociate();
			for(j=i+1;j<numberOfAssociate;j++) {
				if(team[i].getmSales()<team[j].getmSales()) {
					orderedTeam[i].setmSales(team[j].getmSales());
				}
			}
			orderedTeam[i].setmName(team[j].getmName());
		}
		System.out.println("The following had the highest sales: ");
		System.out.printf("Name : %s",team[biggestPersonNum].getmName());
		System.out.printf("Sales : $%.1f \n",team[biggestPersonNum].getmSales());
		System.out.printf("$%f above the average\n",team[biggestPersonNum].getmSales()-maverageSales);
		System.out.println("The rest performed as follows : ");
		for(int i = 1;i<numberOfAssociate;i++) {
			System.out.printf("Name : %s",orderedTeam[i].getmName());
			System.out.printf("Sales : $%f \n",orderedTeam[i].getmSales());
			System.out.printf("$%f above the average\n",orderedTeam[i].getmSales()-maverageSales);
		}
	}

}
