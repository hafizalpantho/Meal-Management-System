package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class ManagerRepo implements IManagerRepo
{
	DatabaseConnection dbc;
	
	public ManagerRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Manager m)
	{
		String query = "INSERT INTO manager VALUES ('"+m.getManId()+"','"+m.getName()+"','"+m.getDesignation()+"',"+m.getTotalAmount()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public void deleteFromDB(String manId)
	{
		String query = "DELETE from manager WHERE manId='"+manId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	
	public void updateInDB(Manager m)
	{
		String query = "UPDATE manager SET mName='"+m.getName()+"', designation = '"+m.getDesignation()+"', totalAmmount = "+m.getTotalAmount()+" WHERE manId='"+m.getManId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public Manager searchMember(String manId)
	{
		Manager m = null;
		String query = "SELECT `mName`, `designation`, `totalAmmount` FROM `manager` WHERE `manId`='"+manId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("mName");
				String designation = dbc.result.getString("designation");
				double totalAmount = dbc.result.getDouble("totalAmmount");
				
				m = new Manager();
				m.setManId(manId);
				m.setName(name);
				m.setDesignation(designation);
				m.setTotalAmount(totalAmount);
				
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return m;
	}
	
	public String[][] getAllMember()
	{
		ArrayList<Manager> ar = new ArrayList<Manager>();
		String query = "SELECT * FROM manager;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String manId = dbc.result.getString("manId");
				String name = dbc.result.getString("mName");
				String designation = dbc.result.getString("designation");
				double totalAmount = dbc.result.getDouble("totalAmmount");
				
				Manager ma = new Manager(manId,name,designation,totalAmount);
				ar.add(ma);
			}
		}
		catch(Exception ma){System.out.println(ma.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Manager)obj[i]).getManId();
			data[i][1] = ((Manager)obj[i]).getName();
			data[i][2] = ((Manager)obj[i]).getDesignation();
			data[i][3] = (((Manager)obj[i]).getTotalAmount())+"";
		}
		return data;
	}
	
	
	
	
	
	
	
	
	
}
