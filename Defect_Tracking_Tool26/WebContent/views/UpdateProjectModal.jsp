 <style>
.f{
background-color:#d1e0e0;
font-family:inherit;
text-align:center;
background-position:center;
}
.a{
margin-bottom: 20px;
padding-right: 100px;
    
    }
</style>
<%@page import="DAO.AddProjectDao"%>
<%@page import="Bean.AddProjectBean,java.util.List" %>
<form action="../UpdateProjectAction" method="POST">
<%
   Object obj= session.getAttribute("id");
   int PM_Id=Integer.parseInt(obj.toString());
   List<AddProjectBean> list1=AddProjectDao.ProjectDetails(PM_Id);
   for(AddProjectBean beanobj: list1)
   {
	   %>
 <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header f">
        <h5 class="modal-title">Update Project</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
     <input type="hidden" name="uid" value="<%=beanobj.getPM_Id() %>">
      <div class="from-group row">
     <label for="ProjectName" class="col-md-4 text-right control-label col-from-label">ProjectName</label>
     <input type="text" class="from-control" id="projectname" value="<%=beanobj.getProject_Name() %>" name="Project_Name" placeholder="Project Name">
     </div><br>
      
     <div class="from-group row ">
     <label for="SoftTools" class="col-md-4 text-right control-label col-from-label">SoftwareTools</label>
     <input type="text" class="from-control" id="softtools" value="<%=beanobj.getSoft_Tools() %>"  name="Soft_Tools" placeholder="Software Tools">
     </div><br>
     
     
     
     <div class="from-group row">
     <label for="StartDate" class="col-md-4 text-right control-label col-from-label">Start Date</label>
     <input type="text" class="from-control" id="startdate"value="<%=beanobj.getStart_Date() %>" name="Start_Date" placeholder="Start Date">
     </div><br>
     <%} %>
      <% List<AddProjectBean> moduleName = AddProjectDao.getModuleName(PM_Id) ;
     
     	for(AddProjectBean beanObj1:moduleName){
     	
     %>
     <div class="from-group row">
     <label for="NoOfModules" class="col-md-4 text-right control-label col-from-label">NameOfModule</label>
    
     <input type="text" class="from-control" id="noofmodules" value="<%=beanObj1.getModule_Name()%>" name="Module_Name" placeholder="No Of Modules"><br>&nbsp;&nbsp;&nbsp;
     
     </div>
 
     <%	
     	} %>
    
      </div><br>
      <div class="modal-footer f">
      <button type="submit" class="btn btn-success">Update</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
  
</form>