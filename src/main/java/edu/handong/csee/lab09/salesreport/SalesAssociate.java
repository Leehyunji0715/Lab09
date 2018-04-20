package edu.handong.csee.lab09.salesreport;
/**
 * This class defines sales associate's name and how much they earn
 * This class has mName and mSales members
 * mName is private modifier and String class type and defines sales associate's name
 * mSales is private modifier and double type. It has value of how much they earn
 * This class has getmName(), setmName(), getmSales(), setmSales() and constructor methods
 * getmName() delivers current String 
 * setmName(), user can change mName to which user want
 * getmSales() delivers current value of sales
 * setmSales(), user can change mSales to which user want
 * @author leehyunji0715
 *
 */
public class SalesAssociate {//This is public class named SalesAssociate
	SalesAssociate(String name, double sales){//This is constructor which has 2 parameters
		setmName(name);//input value of parameter 'name' to mName
		setmSales(sales);//input value of parameter sales to mSales
	}
	SalesAssociate(){//This is constructor and it has no parmameter
		mName = "";//input nothing to mName for initialization
		mSales = 0;	//input 0 to mSales for initialization
	}
	private String mName;// call private modifier and String class type named mName 
	private double mSales;// call private modifier and double type named mSales
	
	public String getmName() {//call public method that return String
		return mName;//return current mName value
	}
	void setmName(String string) {//call public method which returns nothing and input String user wants to store
		this.mName = string;// save String value to mName
	}
	public double getmSales() {//call public method which returns nothing
		return mSales;//return current mSales value
	}
	public void setmSales(double sales) {//return nothing and input sales value
		this.mSales = sales;//save sales value to mSales
	}
}
