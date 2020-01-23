package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Bean.*;
import DBConnection.DbConnection;

public class AssginProjectDao 
{

	static PreparedStatement ps;
	static Connection con=DbConnection.getConnection();
	public static int insert(AssginProjectBean pb1 , AddUserBean ub)
	{
		int i=0 ,id=0;
		System.out.println("in AssginProjectDao insert function");
		/*String name=pb1.getProject_Name();
		System.out.println("project name i dao:"+name);
		try {
			ps = con.prepareStatement("SELECT PM_Id FROM project_master WHERE Project_Name="+"'"+name+"'");
			ResultSet rt = ps.executeQuery();
			System.out.println("After executing query");
			while(rt.next())
			{
				AssginProjectBean pb = new AssginProjectBean();
				 i = rt.getInt(1);
					pb.setPM_Id(i);
				System.out.println("id in AssginProjectDao:"+rt.getInt(1));
			}*/
			try {
			int j=0;
			String name1= ub.getName();
			System.out.println("name1:"+name1);
			ps=con.prepareStatement("SELECT UD_Id FROM user_details WHERE User_Name="+"'"+name1+"'");
			ResultSet rt1 = ps.executeQuery();
			System.out.println("After executing query");
			while(rt1.next())
			{
				AssginProjectBean pb = new AssginProjectBean();
				 j = rt1.getInt(1);
					pb.setUD_Id(j);
				System.out.println("id in AssginProjectDao:"+rt1.getInt(1));
			}
			
			
			
			ps = con.prepareStatement("INSERT into project_assign_details(PM_Id , UD_Id) values(?,?)");
			ps.setInt(1, pb1.getPM_Id());
			System.out.println("project in aasgin:"+pb1.getPM_Id());
			ps.setInt(2, j);
			id = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
		
	}
	
	
	

}
