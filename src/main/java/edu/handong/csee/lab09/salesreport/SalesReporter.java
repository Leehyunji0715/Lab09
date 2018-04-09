package edu.handong.csee.lab09.salesreport;
import java.util.Scanner;//to use Scanner, import this
/**
 * This class informs user number of sales associates and how much they earn. And compare among those salers.
 * This class has mhighestSales, maverageSales, numberOfAssociate, team, biggestPersonNum members.
 * mhighestSales is private modifier and double type. It has value of highest figure of sales.
 * maverageSales  is private modifier and double type. It has value of average about total sales.
 * numberOfAssociate is private modifier and integer type. It means number of associates.
 * team is private modifier and array of class named SalesAssociate
 * biggestPersonNum is index of salesAssociate who reaches the highest sales
 * This class has getData(), computeStats() and displayResults() methods
 * getData() returns nothing, and it gets data from user
 * computeStats() returns nothing, and it shows about average sales and the highest sales
 * displayResults() returns nothing, and it shows person who sales the most and following rest of salers.
 * 
 * @author leehyunji0715
 *
 */
public class SalesReporter {//This is public modifier class
	
	private double mhighestSales;//call variable that is private modifier and double type
	private double maverageSales;//call variable that is private modifier and double type
	private int numberOfAssociate;//call variable that is private modifier and integer type
	private SalesAssociate[] team;//call private modifier and array of SalesAssociate class.
	int biggestPersonNum;//call variable that is integer type.
	
	void getData() {//this returns nothing
		Scanner input = new Scanner(System.in);//instantiate Scanner naming 'input'
		System.out.print("Enter number of sales associates : ");//print out that enter number of sales associate
		numberOfAssociate = input.nextInt();//enter integer to numberOfAssociate
		input.nextLine();//remove blank by receiving it
		team = new SalesAssociate[numberOfAssociate];//instantiate 'team' array and its size is 'numberOfAssociate'
		for(int i=0;i<numberOfAssociate;i++) {//repeat 'numberOfAssociate' times
			System.out.println("Enter data for associate number "+(i+1));//informs that (current index+1) of loop
			System.out.print("Enter name of sales associate: ");//print out to enter name of sales associate
			team[i] = new SalesAssociate();//null pointer exception
			team[i].setmName(input.nextLine());//set a name of associate
			System.out.print("Enter associate's sales: ");
			team[i].setmSales(input.nextInt());
			input.nextLine();
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
			System.out.printf("The highest sales figure is $%.1f\n\n",currentBiggestComparecValue);
		mhighestSales = currentBiggestComparecValue;
	}
	
	void displayResults() {
		int j;
		SalesAssociate orderedTeam[] = new SalesAssociate[numberOfAssociate];
		System.out.println("The following had the highest sales ");
		System.out.printf("Name : %s\n",team[biggestPersonNum].getmName());
		System.out.printf("Sales : $%.1f \n",team[biggestPersonNum].getmSales());
		System.out.printf("$%.1f above the average\n\n",team[biggestPersonNum].getmSales()-maverageSales);
		for(int i=0;i<numberOfAssociate;i++) {
			orderedTeam[i] = new SalesAssociate();
			for(j=i+1;j<numberOfAssociate;j++) {
				if(team[i].getmSales()<team[j].getmSales()) {
					orderedTeam[i].setmSales(team[j].getmSales());
					orderedTeam[i].setmName(team[j].getmName());
					team[j].setmSales(team[i].getmSales());
					team[j].setmName(team[i].getmName());
					team[i].setmSales(orderedTeam[i].getmSales());
					team[i].setmName(orderedTeam[i].getmName());
				}
			}
			//orderedTeam[i].setmName(team[j].getmName());
		}
		System.out.println("The rest performed as follows : ");
		for(int i = 1;i<numberOfAssociate;i++) {
			System.out.printf("Name : %s\n",team[i].getmName());
			System.out.printf("Sales : $%.1f \n",team[i].getmSales());
			System.out.printf("$%.1f above the average\n",team[i].getmSales()-maverageSales);
		}
	}

}
