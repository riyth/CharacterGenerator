package CharacterGenerator;


import java.lang.System;
import java.util.Properties;
import java.sql.*;



public class Database {
	
	
		
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		PreparedStatement stmt3 = null;
		PreparedStatement stmt4 = null;
        
	
       
        
    /**
	 * Database Main
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		
		try
		{
			// Invoke the Database constructor, passing in User Name and Password.
			Database players = new Database();
				
			
			//
		}
		catch (SQLException exSQL)
		{
		    System.out.println("main SQLException: " + exSQL.getMessage());
		    System.out.println("main SQLState: " + exSQL.getSQLState());
		    System.out.println("main VendorError: " + exSQL.getErrorCode());
		    exSQL.printStackTrace();
		}
	} 
	
	/**
	 * Constructor for Class Database
	 * @param String userName for connecting to Database schema
	 * @param String passWord for connecting to Database schema
	 */
	public Database() throws SQLException
	{		
		// Go create a connection to my "players" database.
		// "conn" is a data member of JDBC type Connection.
		// See Database::getConnection method below.
		conn = DriverManager.getConnection("jdbc:sqlite:ClassGenerator.db");
		if (conn == null)
		{
			System.out.println("getConnection failed.");
			return;
		}
		
			
	}	// End of Database Constructor.
		
	
	
	public String getRace() throws SQLException {
		
		String getQuery = "select race from race order random() limit 1";
		stmt = conn.prepareStatement(getQuery);
		
		ResultSet rs = stmt.executeQuery();
		
		String race = null;
		
		
		
		
		while (rs.next()){
			race = rs.getString(1);
			
						
		}
		return race;
	}
	
	
	public String getClassX() throws SQLException {
		
		String getQuery = "select class from class order random() limit 1";
		stmt = conn.prepareStatement(getQuery);
		
		ResultSet rs = stmt.executeQuery();
		
		String classX = null;
		
		
		
		
		while (rs.next()){
			classX = rs.getString(1);
			
						
		}
		return classX;
	}
	
	public String getSubClass(String classX) throws SQLException {
		
		String getQuery = "select subclass from class where class = '" + classX + "' order random() limit 1";
		stmt = conn.prepareStatement(getQuery);
		
		ResultSet rs = stmt.executeQuery();
		
		String subClass = null;
		
		
		
		
		while (rs.next()){
			subClass = rs.getString(1);
			
						
		}
		return subClass;
	}
	
public String getBackground() throws SQLException {
		
		String getQuery = "select Background from Background where Background is not null order random() limit 1";
		stmt = conn.prepareStatement(getQuery);
		
		ResultSet rs = stmt.executeQuery();
		
		String background = null;
		
		
		
		
		while (rs.next()){
			background = rs.getString(1);
			
						
		}
		return background;
	}

public String getAlignment() throws SQLException {
	
	String getQuery = "select Alignment from Alignment where Alignment is not null order random() limit 1";
	stmt = conn.prepareStatement(getQuery);
	
	ResultSet rs = stmt.executeQuery();
	
	String alignment = null;
	
	
	
	
	while (rs.next()){
		alignment = rs.getString(1);
		
					
	}
	return alignment;
}
		
	}
	
	

	
