<%@ page import="Bean.AddProjectBean,java.util.List"%>
<%@ page import="DAO.AddProjectDao"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="../required/assets/images/favicon.png">
<title>Tester Details</title>
<!-- Custom CSS -->
<link rel="stylesheet" type="text/css"
	href="../required/assets/libs/select2/dist/css/select2.min.css">
<link rel="stylesheet" type="text/css"
	href="../required/assets/libs/jquery-minicolors/jquery.minicolors.css">
<link rel="stylesheet" type="text/css"
	href="../required/assets/libs/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
<link rel="stylesheet" type="text/css"
	href="../required/assets/libs/quill/dist/quill.snow.css">
<link href="../required/dist/css/style.min.css" rel="stylesheet">

<link href="../required/dist/css/AddUser.css" rel="stylesheet">
<link href="../required/dist/css/styleborder.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->


</head>
<body>
	<!-- ============================================================== -->
	<!-- Preloader - style you can find in spinners.css -->
	<!-- ============================================================== -->
	<div class="preloader">
		<div class="lds-ripple">
			<div class="lds-pos"></div>
			<div class="lds-pos"></div>
		</div>
	</div>
	<!-- ============================================================== -->
	<!-- Main wrapper - style you can find in pages.scss -->
	<!-- ============================================================== -->
	<div id="main-wrapper">
		<%@ include file="Header.jsp"%>
		<%@ include file="LeftNav.jsp"%>
		<!-- ============================================================== -->
		<!-- Page wrapper  -->
		<!-- ============================================================== -->
		<div class="page-wrapper">




			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="card" align="center"></div>
					</div>
				</div>
				<!-- ============================================================== -->
				<!-- Start Page Content -->
				<!-- ============================================================== -->
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-body"
								style="background: linear-gradient(to bottom left, #9DC183, transparent);">
								<form action="../AddProject_Action" method="post"
									style="margin-left: 120px; text-align: center">
									<fieldset class="col-md-10">
										<legend class="legend_border col-sm-3"
											style="padding-right: 5px;">Tester</legend>

										<div class="form-group row">
											<div class="col-sm-2">
												<label for="testid"></label>
											</div>
											<div class="col-sm-8">
												<input type="text" class="form-control" name="Test_Id"
													maxlength="50" placeholder="Test Id">
											</div>
										</div>
										<div class="form-group row">
											<div class="col-sm-2">
												<label for="TestCasename"></label>
											</div>
											<div class="col-sm-8">
												<input type="text" class="form-control"
													name="Test_Case_Title" maxlength="30"
													placeholder="Test Case Title">
											</div>
										</div>
										<div class="form-group row">
											<div class="col-sm-2">
												<label for="testcasetype"></label>
											</div>
											<div class="col-sm-8">
												<select class="abc" name="Test_Case_Type">
													<option value="">Test Case Type</option>
													<option value="Positive">Positive</option>
													<option value="Negative">Negative</option>

												</select>

											</div>
										</div>
										<div class="form-group row">
											<div class="col-sm-2">
												<label for="module"></label>
											</div>
											<div class="col-sm-4">
												<input type="text" class="form-control" name="Module"
													placeholder="Module">
											</div>
											<div class="col-sm-4">
												<input type="text" class="form-control" name="Fieled_Name"
													placeholder="Fieled Name">
											</div>
										</div>

										<div class="form-group row">
											<div class="col-sm-2">
												<label for="Precondition"></label>
											</div>
											<div class="col-sm-8">
												<input type="text" class="form-control" name="PreCondition"
													placeholder="PreCondition">

											</div>
										</div>

										<div class="form-group row">
											<div class="col-sm-2">
												<label for="Steps"></label>
											</div>
											<div class="col-sm-8">
												<input type="text" class="form-control" name="Steps"
													placeholder="Steps">
											</div>
										</div>

										<div class="form-group row">
											<div class="col-sm-2">
												<label for="TestData"></label>
											</div>
											<div class="col-sm-8">
												<input type="text" class="form-control" name="Test_Data"
													placeholder="Test Data">
											</div>
										</div>
										<div class="form-group row">
											<div class="col-sm-2">
												<label for="Browsertype"></label>
											</div>
											<div class="col-sm-8">
												<select class="abc" name="Test_Case_Type">
													<option value="">Browser Type</option>
													
													<option value="Mozilla">Mozilla</option>
													<option value="Chrome">Chrome</option>
													<option value="OperaMini">OperaMini</option>
													<option value="Safari">Safari</option>
													<option value="InternetExplorer">InternetExplorer</option>
													

												</select>

											</div>
										</div>
											<div class="form-group row">
											<div class="col-sm-2">
												<label for="Expectresult"></label>
											</div>
											<div class="col-sm-8">
												
													<textarea rows="1" cols="50" placeholder="Expect Result"></textarea>
											</div>
										</div>
										
											<div class="form-group row">
											<div class="col-sm-2">
												<label for="Actualresult"></label>
											</div>
											<div class="col-sm-8">
												
													<textarea rows="1" cols="50" placeholder="Actual Result"></textarea>
											</div>
										</div>
											<div class="border-top">
											<div class="card-body">
												<button class="btn btn-success btn-md"
													style="border-radius: 12px" type="submit">Submit</button>
												
											</div>
										</div>
									</fieldset>
								</form>
							</div>
						</div>
					</div>
				</div>



				<!--********deleteModal view ********* -->
				<div class="modal  displayDeletecontent" id="myModal" role="dialog">
				</div>
				<!--**********update modal view******* -->
				<div class="modal displayUpdatecontent" id="myModal1" role="dialog"></div>








				<!-- ============================================================== -->
				<!-- End PAge Content -->
				<!-- ============================================================== -->
				<!-- ============================================================== -->
				<!-- Right sidebar -->
				<!-- ============================================================== -->
				<!-- .right-sidebar -->
				<!-- ============================================================== -->
				<!-- End Right sidebar -->
				<!-- ============================================================== -->
			</div>
			<!-- ============================================================== -->
			<!-- End Container fluid  -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- footer -->
			<!-- ============================================================== -->

			<!-- ============================================================== -->
			<!-- End footer -->
			<!-- ============================================================== -->
		</div>
		<!-- ============================================================== -->
		<!-- End Page wrapper  -->
		<!-- ============================================================== -->
	</div>
	<!-- ============================================================== -->
	<!-- End Wrapper -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- All Jquery -->
	<!-- ============================================================== -->
	<script src="../required/dist/js/Defecttrackingtool.js"></script>
	<script src="../required/assets/libs/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap tether Core JavaScript -->
	<script src="../required/assets/libs/popper.js/dist/umd/popper.min.js"></script>
	<script
		src="../required/assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- slimscrollbar scrollbar JavaScript -->
	<script
		src="../required/assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script>
	<script src="../required/assets/extra-libs/sparkline/sparkline.js"></script>
	<!--Wave Effects -->
	<script src="../required/dist/js/waves.js"></script>
	<!--Menu sidebar -->
	<script src="../required/dist/js/sidebarmenu.js"></script>
	<!--Custom JavaScript -->
	<script src="../required/dist/js/custom.min.js"></script>
	<!-- This Page JS -->
	<script
		src="../required/assets/libs/inputmask/dist/min/jquery.inputmask.bundle.min.js"></script>
	<script src="../required/dist/js/pages/mask/mask.init.js"></script>
	<script
		src="../required/assets/libs/select2/dist/js/select2.full.min.js"></script>
	<script src="../required/assets/libs/select2/dist/js/select2.min.js"></script>
	<script
		src="../required/assets/libs/jquery-asColor/dist/jquery-asColor.min.js"></script>
	<script
		src="../required/assets/libs/jquery-asGradient/dist/jquery-asGradient.js"></script>
	<script
		src="../required/assets/libs/jquery-asColorPicker/dist/jquery-asColorPicker.min.js"></script>
	<script
		src="../required/assets/libs/jquery-minicolors/jquery.minicolors.min.js"></script>
	<script
		src="../required/assets/libs/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
	<script src="../required/assets/libs/quill/dist/quill.min.js"></script>
	<script>
		//***********************************//
		// For select 2
		//***********************************//
		$(".select2").select2();

		/*colorpicker*/
		$('.demo').each(function() {
			//
			// Dear reader, it's actually very easy to initialize MiniColors. For example:
			//
			//  $(selector).minicolors();
			//
			// The way I've done it below is just for the demo, so don't get confused
			// by it. Also, data- attributes aren't supported at this time...they're
			// only used for this demo.
			//
			$(this).minicolors({
				control : $(this).attr('data-control') || 'hue',
				position : $(this).attr('data-position') || 'bottom left',

				change : function(value, opacity) {
					if (!value)
						return;
					if (opacity)
						value += ', ' + opacity;
					if (typeof console === 'object') {
						console.log(value);
					}
				},
				theme : 'bootstrap'
			});

		});

		/*datwpicker*/
		jQuery('.mydatepicker').datepicker();
		jQuery('#datepicker-autoclose').datepicker({
			autoclose : true,
			todayHighlight : true
		});
		var quill = new Quill('#editor', {
			theme : 'snow'
		});
	</script>





</body>

</html>