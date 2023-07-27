package DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DataBaseConnection 
{
         public static DataBaseConnection singleInstance;
         public static DataBaseConnection getInstance()
         {
        	 if(singleInstance==null)
        	 {
        		 singleInstance = new DataBaseConnection();
        	 }	 
        	 return singleInstance;
         }
         private Connection c;
          Statement s;
         private DataBaseConnection()
         {
        	 try
        	 {
        	      Class.forName("com.mysql.jdbc.Driver");
        	      System.out.println("Driverloded");
        	      c = DriverManager.getConnection("jdbc:mysql://localhost:3306/medicine","root","sukh@123456");
        	 }
        	 catch(Exception e)
        	 {
        		 e.printStackTrace();
        	 }
         }
         public Connection getConnection()
         {
        	 System.out.println("Connection stab...");
              return c;
         }
         public Statement getStatement()
         {
        	 try
        	 {
        	   s = c.createStatement();
        	   return s; 
        	 }
        	 catch(Exception e)
        	 {
        		 e.printStackTrace();
        		 System.out.println("Exception caught while creating statement");
     			 JOptionPane.showMessageDialog(null,"Database Failure.");
     			return null;
        	 }
        	 
        
         }
         public ResultSet executeQuery(String query)
     	 {
     		try
     		{
     			ResultSet rs = s.executeQuery(query);
     			return rs;
     		}
     		catch(Exception e)
     		{
     			System.out.println("Exception caught while execyting query");
     			JOptionPane.showMessageDialog(null,"Database Failure.");
     			return null;
     		}
     		
     	}
         
}

