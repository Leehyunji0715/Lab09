package edu.handong.csee.lab09.salesreport;//This package name is 'edu.handong.csee.lab09.salesreport'
import java.util.Scanner;//to use Scanner, import this
import java.util.ArrayList;//to use arrayList, import this
/**
 * This class informs user number of sales associates and how much they earn. And compare among those salers.
 * This class has mhighestSales, maverageSales, team, biggestPersonNum, forArrayList members.
 * mhighestSales is private modifier and double type. It has value of highest figure of sales.
 * maverageSales is private modifier and double type. It has value of average about total sales.
 * team is private modifier and array of class named SalesAssociate
 * biggestPersonNum is index of salesAssociate who reaches the highest sales
 * forArrayList is SalesAssociate class variable to input value of SalesAssociate
 * done
 * This class has getData(), computeStats() and displayResults() methods
 * getData() returns nothing, and it gets data from user
 * computeStats() returns nothing, and it shows about average sales and the highest sales
 * displayResults() returns nothing, and it shows person who sales the most and following rest of salers.
 * 
 * @author leehyunji0715
 */
public class SalesReporter {//This is public modifier class
	
	private double mhighestSales;//call variable that is private modifier and double type
	private double maverageSales;//call variable that is private modifier and double type
	private int numberOfAssociate;//call variable that is private modifier and integer type
	private ArrayList<SalesAssociate> team = new ArrayList<SalesAssociate>();//call private modifier and arrayList of SalesAssociate class.
	int biggestPersonNum;//call variable that is integer type.
	boolean done=false;//boolean type named 'done' 

	void getData() {//this returns nothing
		Scanner input = new Scanner(System.in);//instantiate Scanner naming 'input'
		double sale;// call double type variable named sale
		String name;//call String class type to input name
		while(!done) {//repeat loop while done would be true
			System.out.print("Enter name of sales associate: ");//print out to enter name of sales associate
			name = input.nextLine();//input name
			System.out.print("Enter the number of sales the saler made : ");//print out to enter the number of sales
			sale = input.nextInt();//input sales
			input.nextLine();//remove 'enter' by receiving it
			team.add(new SalesAssociate(name,sale));//add new arrayList node to team
			System.out.print("Do you want to get additional data?(Y or N) : ");//ask whether to add more node
			String ans = input.nextLine ();//user answer whether he will add new node
            if (!ans.equalsIgnoreCase ("Y"))//if user do not write 'Y'
                done = true;// termination condition, 'done' would be 'true'
		}	
	}
	void computeStats() {//returns nothing
		double sum = 0,currentBiggestComparecValue=0;//initiate double type 'sum' and 'currentBiggestComparecValue' to 0, currentBiggestComparecValue is for comparing current index of sale value
		int i;//call integer 'i'
		for(i=0;i<team.size();i++) {//repeat loop arrayList size times
			sum += team.get(i).getmSales();//add mSales to previous value of 'sum'
		}
		maverageSales = (sum/team.size());//calculate average
		System.out.println("Average sales per associate is $"+maverageSales);//print out 'maverageSales' of total associates
		for(i=0;i<team.size();i++) {//repeat loop arrayList size times
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
			for(j=i+1;j<team.size();j++) {//repeat loop the number of nodes times
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
