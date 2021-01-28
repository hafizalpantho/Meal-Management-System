package interfaces;

import java.lang.*;

import entity.*;

public interface IAllMembersRepo
{	
	public void insertInDB(AllMembers e);
	public void deleteFromDB(String memId);
	public void updateInDB(AllMembers e);
	public AllMembers searchMember(String memId);
	public String[][] getAllMembers();
}