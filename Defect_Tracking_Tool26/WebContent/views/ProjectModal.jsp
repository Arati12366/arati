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

 <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header f "style="background: darkkhaki;">
        <h5 class="modal-title">Project Details</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
    	<div class="row">
			<div class="col-md-12" style="background:#9DC183;">
				<div class="card" align="center" style="background-color: inherit">
					<form action="../AssginProject_Modal" method="POST">
						<fieldset class="col-sm-12">
							<legend class="legend_border col-sm-4"
							style="padding-right: 5px;">USER DETAILS</legend>
							<div class="form-group row">
								<div class="col-sm-4">
									<label for="name">Project Name</label>
								</div>
								<div class="col-sm-8">
									<input type="text" class="form-control"
									placeholder="Full Name" maxlength="30" name="Project_Name"
									onkeypress="return alphaOnly(event);" id="projectname"
									style="text-transform: uppercase;" required>
								</div>
							</div>
		    
		    				<div class="form-group row">
								<div class="col-sm-4">
									<label for="name">Software Tools</label>
								</div>
								<div class="col-sm-8">
									<input type="text" class="form-control"
									placeholder="Full Name" maxlength="30" name="Soft_Tools"
									onkeypress="return alphaOnly(event);" id="softtools"
									style="text-transform: uppercase;" required>
								</div>
							</div>
		    
							<div class="from-group row">
								<div class="col-sm-4">
									<label for="name">Start Date</label>
								</div>
								<div class="col-sm-8">
									<input type="text" class="form-control mydatepicker"
									placeholder="Full Name" maxlength="30" name="Start_Date"
									onkeypress="return alphaOnly(event);" id="Start_DateID" style="height: 39px;" required>
								</div>
		     				</div><br>
		     				
		     				<div class="from-group row">
								<div class="col-sm-4">
									<label for="name">Name Of Module</label>
								</div>
								<div class="col-sm-8">
									<input type="text" class="form-control mydatepicker"
									placeholder="No Of Modules" maxlength="30" name="Module_Name"
									onkeypress="return alphaOnly(event);" id="noofmodules" style="height: 39px;" required>
								</div>
		     				</div>
		     		<div class="modal-footer f">
						<button type="submit" class="btn btn-success btn-md">Add</button>
					</div>
					 </fieldset>
				 </form>
					 		<script src="../required/dist/js/Defecttrackingtool.js"></script>
  
		   		</div>
		   	</div>
		 </div>
		</div>	    
		    <div class="modal-footer " style="background: darkkhaki;">
		    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
		    </div>
    </div>
  </div>
 
<script type="text/javascript">
function Start_Date(){
		var today=new Date(),
		      dd=today.getDate(),
		      mm=today.getMonth()+1,
		      yy=today.getFullYear();
		if(dd<10){
			dd='0'+dd;
		}if(mm<10){
			mm='0'+mm;
		}
		var a=mm+'/'+dd+'/'+yy;
		document.getElementById('Start_DateID').value=a;
	}
	
Start_Date();
</script>
	