package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Bean.AddUserBean;
import Bean.AssginProjectBean;
import DBConnection.DbConnection;


public class AddUserDao 
{ 
	static Connection con ;
	public static int insert(AddUserBean obj) 
	{
		int status=0;
		try 
		{
			System.out.println("in insert function");
			con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO user_details(User_Name,Contact_Number,Email,Alias_Name) VALUES(?,?,?,?)");
			ps.setString(1,obj.getName());
			ps.setString(2,obj.getContact());
			ps.setString(3,obj.getEmail());
			ps.setString(4,obj.getAliesname());
			status=ps.executeUpdate();
		
			System.out.println("for selecting id");
			Statement  st = con.createStatement(); 
			ResultSet rt = st.executeQuery("select UD_Id from user_details");
			int i=0;
			while(rt.next())
			{
				i=rt.getInt(1);
			}
			
			System.out.println("for insert value in login table");
			PreparedStatement ps1=con.prepareStatement("insert into user_master(UD_Id ,User_Name , Password,Role) values(?,?,?,?)");
			ps1.setInt(1, i);
			ps1.setString(2,obj.getEmail());
			ps1.setString(3,obj.getContact());
			ps1.setString(4,obj.getRole());
			status = ps1.executeUpdate();
			
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public static List<AddUserBean> getUserDetail()
	{
		ArrayList<AddUserBean> ls = new ArrayList<AddUserBean>();
		PreparedStatement ps;
		try
		{
			ps = DbConnection.getConnection().prepareStatement("SELECT u.UD_Id ,s.Role , u.User_Name , u.Contact_Number  FROM user_details AS u INNER JOIN user_master AS s  ON u.UD_Id = s.UD_Id WHERE (u.Status=1 AND s.Status=1)");
			ResultSet rt = ps.executeQuery();
			while(rt.next())
			{
				AddUserBean a = new AddUserBean();
				a.setUD_Id(rt.getInt(1));
				a.setRole(rt.getString(2));
				a.setName(rt.getString(3));
			//	System.out.println("name:"+rt.getString(1));
				a.setContact(rt.getString(4));
			//	a.setEmail(rt.getString(4));
				ls.add(a);
			}
		} 
		catch(Exception e) 
		{
		
			e.printStackTrace();
		}
		
		return ls;
		
	}
	
	
	public static int delete(int id)
	{
		con=DbConnection.getConnection();
		try
		{
			PreparedStatement ps1=con.prepareStatement("Update user_details set Status=0 where UD_Id=?");
			ps1.setInt(1,id);
			ps1.executeUpdate();
			
			PreparedStatement ps2=con.prepareStatement("update user_master set Status=0 where UD_Id=?");
			ps2.setInt(1,id);
			ps2.executeUpdate();
			
		
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return id;
		
	}

	public static int UpdateAddUser(AddUserBean obj) {
		int id=obj.getUD_Id();
		int status=0;
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement ps1=con.prepareStatement("UPDATE  user_details SET User_Name=? ,Contact_Number=? ,Email=? , Alias_Name=? ,UD_Id=? WHERE UD_id="+id);
			ps1.setString(1,obj.getName());
			ps1.setString(2,obj.getContact());
			ps1.setString(3,obj.getEmail());
			ps1.setString(4,obj.getAliesname());
			ps1.setInt(5,obj.getUD_Id());
		//	ps1.setString(5,obj.getRole());
			status=ps1.executeUpdate();
			PreparedStatement ps=con.prepareStatement("UPDATE user_master SET UD_Id=?, Role=? WHERE UD_Id="+id);
			ps.setInt(1,obj.getUD_Id());
			ps.setString(2,obj.getRole());
			
			status=ps.executeUpdate();
			
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return status;
			 
			

		}
	public static List<AddUserBean> getUserById(int uid) 
	{
		System.out.println("in Dao id:"+uid);

	List<AddUserBean> list=new ArrayList<AddUserBean>();
		try {
			System.out.println("in Dao id:"+uid);
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT u.UD_Id , u.User_Name , u.Contact_Number ,u.Email , u.Alias_Name,s.Role from user_details AS u INNER JOIN user_master AS s ON u.UD_Id = s.UD_Id WHERE u.Status=1 AND u.UD_Id="+uid);
			//ps.setInt(1, uid);
	        ResultSet rs=ps.executeQuery();  
	        
	        while(rs.next()){  
	        	AddUserBean obj=new AddUserBean();
	        	
			obj.setUD_Id(rs.getInt(1));
			obj.setName(rs.getString(2));
			obj.setContact(rs.getString(3));
			obj.setEmail(rs.getString(4));
			obj.setAliesname(rs.getString(5));
			obj.setRole(rs.getString(6));
			System.out.println("After pre statement setrole"+rs.getString(6));
			list.add(obj);
	        }
		}
	        
		catch(Exception ex)
		{
	        	ex.printStackTrace();
	    }  
	        
	        return list;  
	    }  
	public static List<AddUserBean> getUserById1(int id)
	{
		System.out.println("delete page:"+id);
		ArrayList<AddUserBean> l=new ArrayList<AddUserBean>();
		con=DbConnection.getConnection();
		try {
			String sql="select user_details.User_Name ,user_master.Role, user_details.Email from user_details inner join user_master on "
					+ "user_details.UD_Id=user_master.UD_Id where user_details.Status=1 and user_master.Status=1 and "
					+ "user_details.UD_Id="+id;
			PreparedStatement ps2=con.prepareStatement(sql);
			ResultSet rt = ps2.executeQuery();
			System.out.println("print");
			while(rt.next())
				{
				AddUserBean rb= new AddUserBean();
				rb.setName(rt.getString(1));
				System.out.println("*********Name:"+rt.getString(1));
				rb.setRole(rt.getString(2));
				System.out.println("**** Role:"+rt.getString(2));
				rb.setEmail(rt.getString(3));
				l.add(rb);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
		
	}	
	
	public static int UpdateToEmail(AddUserBean beanObj)
	{
		int status=0;
		System.out.println("in updateEmail to method");
		try {
			System.out.println("in updateEmail to method try block");

			//AddUserBean rb= new AddUserBean();
			PreparedStatement ps = DbConnection.getConnection().prepareStatement("UPDATE user_details SET Email=? where UD_Id = ?");
			System.out.println("email in dao " + beanObj.getEmail());
			ps.setString(1,beanObj.getEmail());
			ps.setInt(2, beanObj.getUD_Id());
			status = ps.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}
	
	public static int selectUserId(int id)
	{
		//PreparedStatement ps;
		int j=0;
		//String name1= ub.getName();
		System.out.println("name1:"+id);
		/*
		 * try {
		 * ps=con.prepareStatement("SELECT UD_Id FROM user_details WHERE User_Name="+"'"
		 * +name1+"'"); ResultSet rt1 = ps.executeQuery();
		 * System.out.println("After executing query"); while(rt1.next()) {
		 * AssginProjectBean pb = new AssginProjectBean(); j = rt1.getInt(1);
		 * System.out.println("id in AssginProjectDao:"+rt1.getInt(1)); }
		 * 
		 * 
		 * ps =con.
		 * prepareStatement("SELECT m.Role ,u.User_Name , u.Email FROM user_master As m INNER JOIN user_details AS u ON m.status=1 AND u.status=1 WHERE m.UD_Id="
		 * +j+" AND u.UD_Id="+j); ResultSet rt = ps.executeQuery(); while(rt1.next()){
		 * ub.setRole(rt.getString(1)); ub.setName(rt.getString(2));
		 * ub.setRole(rt.getString(3)); } }catch (Exception e) { e.printStackTrace(); }
		 */
		return j;
		
	}
	
	
	}