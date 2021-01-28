package entity;

import java.lang.*;

public class Bazar
{
	private String date;
	private String bName;
	private String bId;
	private double amount;
	
	public Bazar(){}
	
	public Bazar(String date,String bName, String bId,  double amount)
	{
		this.date = date;
		this.bName = bName;
		this.bId = bId;
		this.amount = amount;
		
	}
	
	public void setDate(String date){this.date = date;}
	public void setbName(String bName){this.bName = bName;}
	public void setbId(String bId){this.bId = bId;}
	public void setAmount(double amount){this.amount = amount;}
	
	public String getDate(){return date;}
	public String getbName(){return bName;}
	public String getbId(){return bId;}
	public double getAmount(){return amount;}
	
	
}