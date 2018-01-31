package socialmonitoring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class ContactDao {
	
	public static Connection getConnection() {
		 Connection con = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/contact_book","root","hvarma7");
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		return con;
	}
	
	public static int addUsers(Contact c) {
		
		int status = 0;
			
		try {
			
			Connection con = ContactDao.getConnection();
			PreparedStatement st = con.prepareStatement("insert into contact values(?,?,?,?)");
			st.setString(1, c.getName());
			st.setString(2, c.getEmail());
			st.setString(3, c.getPhnno());
			st.setString(4, c.getUsername());
			
			status = st.executeUpdate();
			
			con.close();
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return status;
	}
	
	public static int deleteUsers(String username) {
		
		int status = 0;
		
		try {
			Connection con = ContactDao.getConnection();
			PreparedStatement pst = con.prepareStatement("delete from contact where username =?");
			pst.setString(1, username);
			status = pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static int updateOrEditUsers(Contact c) {
		
		int status = 0;
		
			try {
				
				Connection con = ContactDao.getConnection();
				PreparedStatement pst = con.prepareStatement("update contact set name=?,email=?,phnno=? where username=?");
				pst.setString(1, c.getName());
				pst.setString(2, c.getEmail());
				pst.setString(3, c.getPhnno());
				pst.setString(4, c.getUsername());
				
				pst.executeUpdate();
				
				con.close();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	
	public static List<Contact> getFirends() {
		
		List<Contact> myList = new ArrayList<Contact>();
		
		try {
			
			Connection con = ContactDao.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select Name from contact"); 
			
			
			while(rs.next()) {
				Contact c = new Contact();	
				c.setName(rs.getString("Name"));
				myList.add(c);
			
			}
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return myList;
	}
	
	public static List<Contact> getUserNames() {
		
		List<Contact> myList = new ArrayList<Contact>();
		
		try {
			
			Connection con = ContactDao.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select username from contact");
			
			while(rs.next()) {
				Contact c = new Contact();	
				c.setUsername(rs.getString("username"));
				myList.add(c);
			}
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return myList;
	}
	
	
	public static HashMap<String,String> getNamesAndUserNames(){
		
		HashMap<String,String> myMap = new HashMap<String,String>();
			
		try {
			
			Connection con = ContactDao.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select name,username from contact");
			Contact c = new Contact();
			while(rs.next()) {
				c.setName(rs.getString("name"));
				c.setUsername(rs.getString("username"));
				myMap.put(c.getName(), c.getUsername());
			}
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
	
			return myMap;
	
	}
		
	
	
}
