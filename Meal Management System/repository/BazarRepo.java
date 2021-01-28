package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class BazarRepo implements IBazarRepo
{
	DatabaseConnection dbc;
	
	public BazarRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertBazer(Bazar e)
	{
		String query = "INSERT INTO bazar VALUES ('"+e.getDate()+"','"+e.getbName()+"','"+e.getbId()+"',"+e.getAmount()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteBazar(String date)
	{
		String query = "DELETE from bazar WHERE date='"+date+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateBazar(Bazar e)
	{
		String query = "UPDATE bazar SET bName='"+e.getbName()+"', bId = '"+e.getbId()+"', amountOfBazar = "+e.getAmount()+" WHERE date='"+e.getDate()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Bazar searchBazar(String date)
	{
		Bazar emp = null;
		String query = "SELECT `bName`, `bId`, `amountOfBazar` FROM `bazar` WHERE `date`='"+date+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String bName = dbc.result.getString("bName");
				String bId = dbc.result.getString("bId");
				double amount = dbc.result.getDouble("amountOfBazar");
				
				emp = new Bazar();
				emp.setDate(date);
				emp.setbName(bName);
				emp.setbId(bId);
				emp.setAmount(amount);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return emp;
	}
	public String[][] getAllBazar()
	{
		ArrayList<Bazar> ar = new ArrayList<Bazar>();
		String query = "SELECT * FROM bazar;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String date = dbc.result.getString("date");
				String bName = dbc.result.getString("bName");
				String bId = dbc.result.getString("bId");
				double amount = dbc.result.getDouble("amountOfBazar");
				
				Bazar e = new Bazar(date,bName,bId,amount);
				ar.add(e);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Bazar)obj[i]).getDate();
			data[i][1] = ((Bazar)obj[i]).getbName();
			data[i][2] = ((Bazar)obj[i]).getbId();
			data[i][3] = (((Bazar)obj[i]).getAmount())+"";
		}
		return data;
	}
}












































