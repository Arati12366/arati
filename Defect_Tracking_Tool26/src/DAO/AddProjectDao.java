package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bean.AddProjectBean;
import Bean.AddUserBean;
import Bean.AssginProjectBean;
import DBConnection.DbConnection;

public class AddProjectDao {

	static Connection con = DbConnection.getConnection();

	public static int save(AddProjectBean beanObj) {
		int status = 0;
		System.out.println(
				" values in dao " + beanObj.getProject_Name() + beanObj.getSoft_Tools() + beanObj.getStart_Date());
		try {

			PreparedStatement ps = con
					.prepareStatement("insert into project_master(Project_Name,Soft_Tools, Start_Date) values(?,?,?)");
			ps.setString(1, beanObj.getProject_Name());
			ps.setString(2, beanObj.getSoft_Tools());
			ps.setDate(3, beanObj.getStart_Date());
			System.out.println("Before execute update,,,,,,,,,,,,");
			status = ps.executeUpdate();

			if (status != 0)
				System.out.println("Success");
			else
				System.out.println("Unsuccess");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static List<AddProjectBean> getProjectNames() {
		List<AddProjectBean> list = new ArrayList<AddProjectBean>();
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from project_master where Status=1");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AddProjectBean beanObj = new AddProjectBean();
				beanObj.setPM_Id(rs.getInt(1));
				beanObj.setProject_Name(rs.getString(2));
				beanObj.setSoft_Tools(rs.getString(3));
				beanObj.setStart_Date(rs.getDate(4));
				list.add(beanObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<AddProjectBean> ProjectDetails(int uid) {
		List<AddProjectBean> list = new ArrayList<AddProjectBean>();
		try {
			con = DbConnection.getConnection();

			PreparedStatement ps1 = con.prepareStatement(
					"select m.PM_Id ,m.Project_Name ,m.Soft_Tools ,m.Start_Date from project_master AS m INNER JOIN project_details AS d ON m.Status=1 AND d.Status=1 WHERE m.PM_Id="
							+ uid + " and d.PD_Id=" + uid);

			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				AddProjectBean beanObj1 = new AddProjectBean();
				beanObj1.setPM_Id(rs1.getInt(1));
				beanObj1.setProject_Name(rs1.getString(2));
				beanObj1.setSoft_Tools(rs1.getString(3));
				beanObj1.setStart_Date(rs1.getDate(4));
				list.add(beanObj1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<AddProjectBean> getModuleName(int pm_ID) {
		List<AddProjectBean> list = new ArrayList<AddProjectBean>();
		try {
			con = DbConnection.getConnection();

			PreparedStatement ps1 = con
					.prepareStatement("select PD_Id, Module_Name FROM project_details WHERE PM_Id=" + pm_ID);

			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				AddProjectBean beanObj1 = new AddProjectBean();
				beanObj1.setPD_ID(rs1.getInt(1));
				beanObj1.setModule_Name(rs1.getString(2));
				list.add(beanObj1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static int Delete_Project(int id) {
		int status = 0;
		try {
			con = DbConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("update project_details set Status=0 where PM_Id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			PreparedStatement ps1 = con.prepareStatement("update project_master set Status=0 where PM_Id=?");
			ps1.setInt(1, id);
			status = ps1.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int Update_Project(AddProjectBean beanObj) {
		int id = beanObj.getPM_Id();

		int status = 0;
		try {

			con = DbConnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update project_master set Project_Name=?,Soft_Tools=? where PM_Id=" + id);
			ps.setString(1, beanObj.getProject_Name());
			ps.setString(2, beanObj.getSoft_Tools());
			
			status= ps.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static List<AddProjectBean> SelectPname(int id) {
		List<AddProjectBean> list = new ArrayList<AddProjectBean>();
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps1 = con
					.prepareStatement("select Project_Name from project_master where Status=1 and PM_Id=" + id);

			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				AddProjectBean beanObj1 = new AddProjectBean();
				beanObj1.setProject_Name(rs1.getString(1));
				list.add(beanObj1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static int returnMaxID() {
		int i = 0;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select max(PM_Id) from project_master");

			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;

	}

	public static void saveModuleNames(AddProjectBean beanObj) {
		System.out.println("inside savemodule method");
		try {
			PreparedStatement ps = con.prepareStatement("insert into project_details(PM_Id,Module_Name) values(?,?)");

			ps.setInt(1, beanObj.getPM_Id());
			ps.setString(2, beanObj.getModule_Name());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int returnID() {
		int i = 0;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select PM_Id from project_master");

			while (rs.next()) {
				i = rs.getInt(1);
				System.out.println("@#$@$#$#@$ "+i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;

	}

	public static int Update_ProjectMN(AddProjectBean beanObj) 
	{
		int id = beanObj.getPM_Id();

		int status = 0;
		try {

			con = DbConnection.getConnection();
			System.out.println("int dao modulename           " + beanObj.getModule_Name());

			PreparedStatement ps1=con.prepareStatement("update project_details set Module_Name=? where PM_Id="+id);
		//	PreparedStatement ps1 = con.prepareStatement(
				//	"update project_master set project_master.Project_Name = project_details.Module_Name, project_master.Soft_Tools = project_details.PD_ID from project_master INNER JOIN project_details ON project_master.PM_Id = project_details.PM_Id="
						//	+ id);

			ps1.setString(1, beanObj.getModule_Name());

			status=ps1.executeUpdate();
			System.out.println("######STATUS VALUE#####      " +status);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	
	}
	
	public static List<AddProjectBean> projectName()
	  {
		  List<AddProjectBean> l= new ArrayList<AddProjectBean>();
		  try {
			PreparedStatement ps1 = con.prepareStatement("SELECT PM_Id , Project_Name FROM project_master");
			ResultSet rt =ps1.executeQuery();
			while(rt.next())
			{
				AddProjectBean rb=new AddProjectBean();
				rb.setPM_Id(rt.getInt(1));
				rb.setProject_Name(rt.getString(2));
				System.out.println("id:"+rt.getString(2));
				l.add(rb);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
		  
	  }

	
	public static int selectId(String name)
	{
		PreparedStatement ps;
		int id=0;
		System.out.println("nameeeeeeeeeee:"+name);
		try {
			ps =con.prepareStatement("SELECT PM_Id FROM project_master WHERE Project_Name="+"'"+name+"'");
			ResultSet rt = ps.executeQuery();
			System.out.println("query executed");
			while(rt.next()) {
				AddProjectBean rb = new AddProjectBean();
				 id=rt.getInt(1);
				 rb.setPM_Id(id);
				System.out.println("*********************:::::"+rt.getInt(1));

			}

			
		/*	ps =con.prepareStatement("SELECT m.Role ,u.User_Name , u.Email FROM user_master As m INNER JOIN user_details AS u ON m.status=1 AND u.status=1 WHERE m.UD_Id="+id+" AND u.UD_Id="+id); 
			ResultSet rt1 = ps.executeQuery();
			while(rt1.next())
			{
				AddUserBean ub = new AddUserBean();
				ub.setRole(rt1.getString(1));
				ub.setName(rt1.getString(2));
				ub.setRole(rt1.getString(3));
			}*/
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return id;
		
	}

	

}
