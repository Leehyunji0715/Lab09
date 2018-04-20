package edu.handong.csee.lab09.salesreport;
import java.util.Scanner;//to use Scanner, import this
import java.util.ArrayList;
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
	private ArrayList<SalesAssociate> team = new ArrayList<SalesAssociate>();//call private modifier and arrayList of SalesAssociate class.
	private SalesAssociate forArrayList = new SalesAssociate();
	int biggestPersonNum;//call variable that is integer type.
	boolean done=false;
	int i=0;
	void getData() {//this returns nothing
		Scanner input = new Scanner(System.in);//instantiate Scanner naming 'input'
		while(!done) {
			System.out.print("Enter name of sales associate: ");//print out to enter name of sales associate
			forArrayList.setmName(input.nextLine());
			System.out.print("Enter associate's sales: ");//print out to set amount of sales of worker
			forArrayList.setmSales(input.nextInt());
			input.nextLine();//remove 'enter' by receiving it
			team.add(forArrayList);
			System.out.print("Do you want to get additional data? : ");
			String ans = input.nextLine ();
            if (!ans.equalsIgnoreCase ("yes"))
                done = true;
			 i++;
		}
		
	}
	void computeStats() {//returns nothing
		double sum = 0,currentBiggestComparecValue=0;//initiate double type 'sum' and 'currentBiggestComparecValue' to 0, currentBiggestComparecValue is for comparing current index of sale value
		int i;//call integer 'i'
		for(i=0;i<team.size();i++) {
			sum += team.get(i).getmSales();//add mSales to previous value of 'sum'
			System.out.println(sum);
			System.out.println("size?"+team.size());
		}
		maverageSales = (sum/team.size());//calculate average
		System.out.println("Average sales per associate is $"+maverageSales);//print out 'maverageSales' of total associates
		//for(i=0;i<numberOfAssociate;i++) {//repeat numberOfAssociate times
		for(i=0;i<team.size();i++) {
			if(team.get(i).getmSales()>currentBiggestComparecValue) {//if current index of associate's sale is bigger than currentBiggestComparecValue
				currentBiggestComparecValue = team.get(i).getmSales();//input value to currentBiggestComparecValue
				biggestPersonNum = i;//and save the index of this associate
			}
		}
			System.out.printf("The highest sales figure is $%.1f\n\n",currentBiggestComparecValue);// print out the highest sales figure
		mhighestSales = currentBiggestComparecValue;//save value of highest sales to mhighestSales
	}
	
	void displayResults() {//returns nothing
		int j;//call integer 'j'
		SalesAssociate tempTeam = new SalesAssociate();//instantiate SalesAssociate in array named tempTeam
		System.out.println("The following had the highest sales ");//informs that will show highest sales
		System.out.printf("Name : %s\n",team.get(biggestPersonNum).getmName());//print out name which person sales the most
		System.out.printf("Sales : $%.1f \n",team.get(biggestPersonNum).getmSales());//print out sales that sell the most
		System.out.printf("$%.1f above the average\n\n",team.get(biggestPersonNum).getmSales()-maverageSales);//print out value above average
		for(int i=0;i<team.size();i++) {//repeat numberOfAssociate times
			tempTeam = new SalesAssociate();//initiate SalesAssociate array named tempTeam 
			for(j=i+1;j<team.size();j++) {
				if(team.get(i).getmSales()<team.get(j).getmSales()) {//if current sale figure is smaller than rest
					tempTeam.setmSales(team.get(j).getmSales());//save value to tempTeam temporaily
					tempTeam.setmName(team.get(j).getmName());//save String value to tempTeam temporaily
					team.get(j).setmSales(team.get(i).getmSales());//input sales value to which has bigger value
					team.get(j).setmName(team.get(i).getmName());//input String name to which has bigger value
					team.get(i).setmSales(tempTeam.getmSales());//input j index value to current one
					team.get(i).setmName(tempTeam.getmName());;//input j index String value to current one
				}
			}
		}
		System.out.println("The rest performed as follows : ");//informs that print out following associate according to figure of sales
		for(int i = 1;i<team.size();i++) {//repeat numberOfAssociate-1 times
			System.out.printf("Name : %s\n",team.get(i).getmName());//print out Name
			System.out.printf("Sales : $%.1f \n",team.get(i).getmSales());//print out sales figure
			System.out.printf("$%.1f above the average\n",team.get(i).getmSales()-maverageSales);//print out how much value above average
		}
	}

}
