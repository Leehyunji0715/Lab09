package edu.handong.csee.lab09.salesreport;
/**
 * This class defines sales associate's name and how much they earn
 * This class has mName and mSales members
 * mName is private modifier and String class type and defines sales associate's name
 * mSales is private modifier and double type. It has value of how much they earn
 * This class has getmName(), setmName(), getmSales() and setmSales() methods
 * getmName() delivers current String 
 * setmName(), user can change mName to which user want
 * getmSales() delivers current value of sales
 * setmSales(), user can change mSales to which user want
 * @author leehyunji0715
 *
 */
public class SalesAssociate {//This is public class named SalesAssociate
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
