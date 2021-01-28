package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class AllMembersRepo implements IAllMembersRepo
{
	DatabaseConnection dbc;
	
	public AllMembersRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(AllMembers e)
	{
		String query = "INSERT INTO allmember VALUES ('"+e.getMemId()+"','"+e.getMonth()+"',"+e.getTotalMeal()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String memId)
	{
		String query = "DELETE from allmember WHERE memId='"+memId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(AllMembers e)
	{
		String query = "UPDATE allmember SET month = '"+e.getMonth()+"', totalMeal = "+e.getTotalMeal()+" WHERE memId='"+e.getMemId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public AllMembers searchMember(String memId)
	{
		AllMembers emp = null;
		String query = "SELECT `month`, `totalMeal` FROM `allmember` WHERE `memId`='"+memId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String month = dbc.result.getString("month");
				double totalMeal = dbc.result.getDouble("totalMeal");
				
				emp = new AllMembers();
				emp.setMemId(memId);
				emp.setMonth(month);
				emp.setTotalMeal(totalMeal);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return emp;
	}
	public String[][] getAllMembers()
	{
		ArrayList<AllMembers> ar = new ArrayList<AllMembers>();
		String query = "SELECT * FROM allmember;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String memId = dbc.result.getString("memId");
				String month = dbc.result.getString("month");
				double totalMeal = dbc.result.getDouble("totalMeal");
				
				AllMembers e = new AllMembers(memId,month,totalMeal);
				ar.add(e);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][3];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((AllMembers)obj[i]).getMemId();
			data[i][1] = ((AllMembers)obj[i]).getMonth();
			data[i][2] = (((AllMembers)obj[i]).getTotalMeal())+"";
		}
		return data;
	}
}












































