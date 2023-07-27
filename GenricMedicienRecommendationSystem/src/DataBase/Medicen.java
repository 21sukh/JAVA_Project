package DataBase;

import java.sql.ResultSet;
import java.sql.Statement;

public class Medicen 
{
    public static Medicen singleInstance;
    public static Medicen getInstance()
    {
    	if(singleInstance==null)
    	{	
    	singleInstance = new Medicen();
        }
        return singleInstance;
    } 
    ResultSet re;
    public ResultSet fetch_Data(String disease)
    {
    
    	String query = "Select Medicine_Name from Medicine where disease ='"+disease+"'";
       	try 
       	{
       	   Statement s = DataBaseConnection.getInstance().getConnection().createStatement();
       	   re = s.executeQuery(query);
       	}
       	catch(Exception e)
       	{
       	   e.printStackTrace();	
       	}
       	return re;
        
      
    }
}
