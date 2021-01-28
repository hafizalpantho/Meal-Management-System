package interfaces;

import java.lang.*;
import entity.*;

public interface IBazarRepo
{
	public void insertBazer(Bazar e);
	public void deleteBazar(String date);
	public void updateBazar(Bazar e);
	public Bazar searchBazar(String date);
	public String[][] getAllBazar();
	
}