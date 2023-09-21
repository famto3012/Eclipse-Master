package com.femto.app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.femto.app.api.LoginAPI;
import com.mysql.cj.x.protobuf.MysqlxSession.AuthenticateContinue;

import java.sql.*;
import java.text.MessageFormat;

public class LoginRepository {
	
Connection con = null;
	
	public LoginRepository()
	
	{
		String url = "jdbc:mysql://localhost:3306/femto?verifyServerCertificate=false&useSSL=true";
		String username = "root";
		String password = "Dinesh@1019";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		   
	}
	
	
	public List<LoginAPI> getLoginAPIs()
	
	{
		List<LoginAPI> loginAPIs = new ArrayList<>();
		String sql = "select * from loginapi";
		try {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			System.out.println("{" + '\n' + "message:" + " " + "User details fetched," + '\n' + "payload:" + " " +
					"[");
			
			while(rs.next())
			{
				

		       LoginAPI v = new LoginAPI();
				
				v.setId(rs.getInt(1));
				v.setPhonenumber(rs.getString(2));
				v.setName(rs.getString(3));
				v.setAddress(rs.getString(4));
				
				loginAPIs.add(v);  
				

				
				int id = rs.getInt("id");
				String phonenumber = rs.getString("phonenumber");
				String name = rs.getString("name");
				String address = rs.getString("address");
			
				
				System.out.println("{" + '\n' + "id:" + " " + id + "," + '\n' + "phoneNumber:" + " " + phonenumber + "," + '\n' +
							"name:" + " " + name + "," + '\n' + "address:" + " " + address + '\n' + "}");
				
				
				
		    // 	System.out.println("Id:" + id+'\n'+"Phonenumber:" + phonenumber+'\n'+"Name:" +name+'\n'+"Address:" +address);
					
			//	System.out.println("{" + '\n' + "Message:" + " " + "User details," + '\n' + "Payload:" + " " +
			//	"[" + '\n' + "{" + '\n' + "id:" + " " + id + "," + '\n' + "Phonenumber:" + " " + phonenumber + "," + '\n' +
			//	"Name:" + " " + name + "," + '\n' + "Address:" + " " + address + '\n' + "}" + '\n' + "]" + '\n' + "}");
			}
			
			System.out.println("]" + '\n' + "}");
			
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		return loginAPIs;	
		
	}   
	
	public LoginAPI getLoginAPI(int id)
	
	{
		
		String sql = "select * from loginapi where id="+id;
		LoginAPI v = new LoginAPI();
		try {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{	
				
				v.setId(rs.getInt(1));
				v.setPhonenumber(rs.getString(2));
				v.setName(rs.getString(3));
				v.setAddress(rs.getString(4));
				
				int Id = rs.getInt("id");
				String phonenumber = rs.getString("phonenumber");
				String name = rs.getString("name");
				String address = rs.getString("address");
			
				
				System.out.println("{" + '\n' + "Message:" + " " + "User details," + '\n' + "Payload:" + " " +
							"[" + '\n' + "{" + '\n' + "id:" + " " + Id + "," + '\n' + "Phonenumber:" + " " + phonenumber + "," + '\n' +
							"Name:" + " " + name + "," + '\n' + "Address:" + " " + address + '\n' + "}" + '\n' + "]" + '\n' + "}");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		return v;
	}

	public void create(LoginAPI v1) {
		// TODO Auto-generated method stub
		String sql = "insert into loginapi values (?,?,?,?)";
		
		
try {
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, v1.getId());
			st.setString(2, v1.getPhonenumber());
			st.setString(3, v1.getName());
			st.setString(4, v1.getAddress());
			
			st.executeUpdate();			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
	}
	
	
	public void update(LoginAPI v1) {
		// TODO Auto-generated method stub
		String sql = "update loginapi set name=?, address=? where phonenumber=?";
		
		
try {
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, v1.getName());
			st.setString(2, v1.getAddress());
			st.setString(3, v1.getPhonenumber());
			
			st.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	public void delete(int id) {
		
		// TODO Auto-generated method stub
		
		String sql = "delete from loginapi where id =?";
		
		try {			
							
					PreparedStatement st = con.prepareStatement(sql);
					
		      	    st.setInt(1, id);
					
					st.executeUpdate();
					
					
					System.out.println("{" + '\n' + "message:" + "User deleted successfully" + '\n' + "}");
					
					
					con.close();
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
		
	}

}
