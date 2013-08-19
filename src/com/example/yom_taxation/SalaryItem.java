package com.example.yom_taxation;

public class SalaryItem {

	/**
	 * @param args
	 */
	
	protected static int salary;
	protected static int extrasalary;
	protected static int pfperc;		//1=0% 2=10%
	protected static int citperc;
	protected static int festivesal;
	protected static int gender;  //1=Male 2=Female
	protected static int marital;  //1=Married 2=Unmarried
	protected static int insurance;
	
	public static int getInsurance() {
		return insurance;
	}
	public static void setInsurance(int insurance) {
		SalaryItem.insurance = insurance;
	}
	public static int getGender() {
		return gender;
	}
	public static void setGender(int gender) {
		SalaryItem.gender = gender;
	}
	public static int getMarital() {
		return marital;
	}
	public static void setMarital(int marital) {
		SalaryItem.marital = marital;
	}
	public static int getSalary() {
		return salary;
	}
	public static void setSalary(int salary) {
		SalaryItem.salary = salary;
	}
	public static int getExtrasalary() {
		return extrasalary;
	}
	public static void setExtrasalary(int extrasalary) {
		SalaryItem.extrasalary = extrasalary;
	}
	public static int getPfperc() {
		return pfperc;
	}
	public static void setPfperc(int pfperc) {
		SalaryItem.pfperc = pfperc;
	}
	public static int getCitperc() {
		return citperc;
	}
	public static void setCitperc(int citperc) {
		SalaryItem.citperc = citperc;
	}
	public static int getFestivesal() {
		return festivesal;
	}
	public static void setFestivesal(int festivesal) {
		SalaryItem.festivesal = festivesal;
	}
	

}
