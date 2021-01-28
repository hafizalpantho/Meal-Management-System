package interfaces;

import java.lang.*;

import entity.*;

public interface IManagerRepo
{	
	public void insertInDB(Manager m);
	public void deleteFromDB(String manId);
	public void updateInDB(Manager m);
	public Manager searchMember(String manId);
	public String[][] getAllMember();
	
}
