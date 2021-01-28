package entity;

import java.lang.*;

public class Manager
{
	private String manId;
	private String name;
	private String designation;
	private double totalAmount;
	
	
	public Manager(){}
	public Manager(String manId, String name, String designation, double totalAmount)
	{
		this.manId = manId;
		this.name = name;
		this.designation = designation;
		this.totalAmount = totalAmount;
	}
	
	public void setManId(String manId){this.manId = manId;}
	public void setName(String name){this.name = name;}
	public void setDesignation(String designation){this.designation = designation;}
	public void setTotalAmount(double totalAmount){this.totalAmount = totalAmount;}
	
	public String getManId(){return manId;}
	public String getName(){return name;}
	public String getDesignation(){return designation;}
	public double getTotalAmount(){return totalAmount;}
	
}
