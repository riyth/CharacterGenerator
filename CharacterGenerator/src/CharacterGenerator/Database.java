package CharacterGenerator;


import java.lang.System;
import java.sql.*;



public class Database {
	
	
		
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		PreparedStatement stmt3 = null;
		PreparedStatement stmt4 = null;
		String alignmentIn = null;
        
	
       
        
 	

	public Database(String source, String alignment) throws SQLException
	{		
	
		//System.out.println("PreConnection");
		conn = DriverManager.getConnection("jdbc:sqlite::resource:CharacterGenerator/ClassGenerator.db");
		alignmentIn = alignment;
		System.out.println(alignmentIn);
		//System.out.println("PostConnection");
		if (conn == null)
		{
			System.out.println("getConnection failed.");
			return;
		}
		
			
	}	// End of Database Constructor.
		
	
	
	public String getRace() throws SQLException {
		
		String getQuery = "select race from race ORDER BY RANDOM() limit 1;";
		stmt = conn.prepareStatement(getQuery);
		
		ResultSet rs = stmt.executeQuery();
		
		String race = null;
		
		
		
		
		while (rs.next()){
			race = rs.getString(1);
			
						
		}
		return race;
	}
	
	
	public String getClassX() throws SQLException {
		
		String getQuery = "select class from class ORDER BY RANDOM() limit 1;";
		stmt = conn.prepareStatement(getQuery);
		
		ResultSet rs = stmt.executeQuery();
		
		String classX = null;
		
		
		
		
		while (rs.next()){
			classX = rs.getString(1);
			
						
		}
		return classX;
	}
	
	public String getSubClass(String classX) throws SQLException {
		
		String getQuery = "select RTRIM(subclass) from class where class = '" + classX + "' ORDER BY RANDOM() limit 1;";
		stmt = conn.prepareStatement(getQuery);
		
		ResultSet rs = stmt.executeQuery();
		
		String subClass = null;
		
		
		
		
		while (rs.next()){
			subClass = rs.getString(1);
			
						
		}
		return subClass;
	}
	
public String getBackground() throws SQLException {
		
		String getQuery = "select Background from Background where Background is not null ORDER BY RANDOM() limit 1;";
		stmt = conn.prepareStatement(getQuery);
		
		ResultSet rs = stmt.executeQuery();
		
		String background = null;
		
		
		
		
		while (rs.next()){
			background = rs.getString(1);
			
						
		}
		return background;
	}

public String getAlignment() throws SQLException {
	
	String getQuery = "select Alignment from Alignment where Alignment is not null AND Alignment in (" + alignmentIn + ")  ORDER BY RANDOM() limit 1;";
	stmt = conn.prepareStatement(getQuery);
	
	System.out.println(alignmentIn);
	ResultSet rs = stmt.executeQuery();
	
	String alignment = null;
	
	
	
	while (rs.next()){
		alignment = rs.getString(1);
		System.out.println(alignment);
					
	}
	return alignment;
}
		
	}
	
	

	
