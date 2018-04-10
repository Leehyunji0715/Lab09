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
		input.nextLine();//remove 'enter' by receiving it
		team = new SalesAssociate[numberOfAssociate];//instantiate 'team' array and its size is 'numberOfAssociate'
		for(int i=0;i<numberOfAssociate;i++) {//repeat 'numberOfAssociate' times
			System.out.println("Enter data for associate number "+(i+1));//informs that (current index+1) of loop
			System.out.print("Enter name of sales associate: ");//print out to enter name of sales associate
			team[i] = new SalesAssociate();//null pointer exception
			team[i].setmName(input.nextLine());//set a name of associate of worker in current index
			System.out.print("Enter associate's sales: ");//print out to set amount of sales of worker
			team[i].setmSales(input.nextInt());//set amount of sales of worker in current index
			input.nextLine();//remove 'enter' by receiving it
		}
	}
	void computeStats() {//returns nothing
		double sum = 0,currentBiggestComparecValue=0;//initiate double type 'sum' and 'currentBiggestComparecValue' to 0, currentBiggestComparecValue is for comparing current index of sale value
		int i;//call integer 'i'
		for(i=0;i<numberOfAssociate;i++) {//repeat numberOfAssociate times
			sum += team[i].getmSales();//add mSales to previous value of 'sum'
		}
		maverageSales = (sum/numberOfAssociate);//calculate average
		System.out.println("Average sales per associate is $"+maverageSales);//print out 'maverageSales' of total associates
		for(i=0;i<numberOfAssociate;i++) {//repeat numberOfAssociate times
			if(team[i].getmSales()>currentBiggestComparecValue) {//if current index of associate's sale is bigger than currentBiggestComparecValue
				currentBiggestComparecValue = team[i].getmSales();//input value to currentBiggestComparecValue
				biggestPersonNum = i;//and save the index of this associate
			}
		}
			System.out.printf("The highest sales figure is $%.1f\n\n",currentBiggestComparecValue);// print out the highest sales figure
		mhighestSales = currentBiggestComparecValue;//save value of highest sales to mhighestSales
	}
	
	void displayResults() {//returns nothing
		int j;//call integer 'j'
		SalesAssociate tempTeam[] = new SalesAssociate[numberOfAssociate];//instantiate SalesAssociate in array named tempTeam
		System.out.println("The following had the highest sales ");//informs that will show highest sales
		System.out.printf("Name : %s\n",team[biggestPersonNum].getmName());//print out name which person sales the most
		System.out.printf("Sales : $%.1f \n",team[biggestPersonNum].getmSales());//print out sales that sell the most
		System.out.printf("$%.1f above the average\n\n",team[biggestPersonNum].getmSales()-maverageSales);//print out value above average
		for(int i=0;i<numberOfAssociate;i++) {//repeat numberOfAssociate times
			tempTeam[i] = new SalesAssociate();//initiate SalesAssociate array named tempTeam 
			for(j=i+1;j<numberOfAssociate;j++) {//loop in loop, repeat (numberOfAssociate-i-1) times
				if(team[i].getmSales()<team[j].getmSales()) {//if current sale figure is smaller than rest
					tempTeam[i].setmSales(team[j].getmSales());//save value to tempTeam temporaily
					tempTeam[i].setmName(team[j].getmName());//save String value to tempTeam temporaily
					team[j].setmSales(team[i].getmSales());//input sales value to which has bigger value
					team[j].setmName(team[i].getmName());//input String name to which has bigger value
					team[i].setmSales(tempTeam[i].getmSales());//input j index value to current one
					team[i].setmName(tempTeam[i].getmName());;//input j index String value to current one
				}
			}
		}
		System.out.println("The rest performed as follows : ");//informs that print out following associate according to figure of sales
		for(int i = 1;i<numberOfAssociate;i++) {//repeat numberOfAssociate-1 times
			System.out.printf("Name : %s\n",team[i].getmName());//print out Name
			System.out.printf("Sales : $%.1f \n",team[i].getmSales());//print out sales figure
			System.out.printf("$%.1f above the average\n",team[i].getmSales()-maverageSales);//print out how much value above average
		}
	}

}
