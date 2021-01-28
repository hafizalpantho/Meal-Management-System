package entity;

import java.lang.*;

public class AllMembers
{
	private String memId;
	private String month;
	private double totalMeal;
	
	public AllMembers(){}
	public AllMembers(String memId, String month, double totalMeal)
	{
		this.memId = memId;
		this.month = month;
		this.totalMeal = totalMeal;
		
	}
	
	public void setMemId(String memId){this.memId = memId;}
	public void setMonth(String month){this.month = month;}
	public void setTotalMeal(double totalMeal){this.totalMeal = totalMeal;}
		
	public String getMemId(){return memId;}
	public String getMonth(){return month;}
	public double getTotalMeal(){return totalMeal;}
}