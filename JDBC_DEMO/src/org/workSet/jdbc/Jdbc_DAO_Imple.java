package org.workSet.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.workSet.model.Triangle;


@Component
public class Jdbc_DAO_Imple {
	
	JdbcTemplate templet ;
	

	private DataSource dataSource ; 
	




	public Triangle getTriangle(int id ) {
		
		
		Connection conn =  null ; 
        Triangle tringle = null ; 


		try {
		
		String driver = "org.apache.derby.jdbc.ClientDriver"  ;
        Class.forName(driver).newInstance();
        
        conn =   getDataSource().getConnection();
        
        PreparedStatement st = conn.prepareStatement("SELECT * FROM Triangle where ID = ?");
        st.setInt( 1 , id); 
        
        ResultSet rs = st.executeQuery();
      
         if(rs.next()) {
        	 
        	 tringle = new Triangle( id  , rs.getString("NAME") );
         }
		
         rs.close();
         st.close();
         
		} 
		
		catch (Exception e) {  throw new RuntimeException(e);}
		
		
		
		
		
		finally {
		          	try {	conn.close();    } catch (Exception e2) {}
		        }
		
		 return tringle ;
		
	}


   public int records_count() {
	   
	  String sql =  "SELECT COUNT(*) FROM Triangle" ; 
	  return templet.queryForObject(sql , Integer.class);
	  
   }

	public DataSource getDataSource() {
		return dataSource;
	}


	public JdbcTemplate getTemplet() {
		return templet;
	}

    @Autowired
	public void setTemplet(JdbcTemplate templet) {
		this.templet = templet;
	}



 /* @Autowired
	public void setDataSource(DataSource dataSource) {
		this.templet = new JdbcTemplate(dataSource);
	
	}*/

}
