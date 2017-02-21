<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2 class="text-center">My Insurance Company</h2>
		<div class="well">
			<form>
				<div class="row">
					<div class="col-lg-7">
						<div class="form-group col-sm-8 col-md-8 col-lg-8">
							<label for="firstName">First Name</label>
							<input type="text" class="form-control" id="firstName">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-7">
						<div class="form-group col-sm-8 col-md-8 col-lg-8">
							<label for="lastName">Last Name</label>
							<input type="text" class="form-control" id="lastName">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-7">
						<div class="form-group col-sm-8 col-md-8 col-lg-8">
							<label for="id">ID</label>
							<input type="text" class="form-control" id="id">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-7">
						<div class="form-group col-sm-8 col-md-8 col-lg-8">
							<label for="age">Age</label>
							<input type="text" class="form-control" id="age">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-7">
						<div class="form-group col-sm-8 col-md-8 col-lg-8">
							<label for="policyType">Policy Type</label>
							<select class="form-control" id="policyType">
								<option value="Bike">Bike</option>
								<option value="Jewelry">Jewelry</option>
								<option value="Electronics">Electronics</option>
								<option value="Sports_Equipment">Sports Equipment</option>
							</select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-7">
						<div class="form-group col-sm-8 col-md-8 col-lg-8">
							<label for="coverageAmount">Coverage Amount</label>
							<select class="form-control" id="coverageAmount">
								<option value="500">500</option>
								<option value="1500">1500</option>
								<option value="3000">3000</option>
							</select>
						</div>
					</div>
				</div>
				<button id="submit" type="button" class="btn btn-default">Submit</button>
			</form>
		</div>
	</div>
	
	<!-- Modal -->
	  <div class="modal fade" id="myModal" role="dialog">
	    <div class="modal-dialog">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Insurance Policy</h4>
	        </div>
	        <div class="modal-body">
	          <p id="result"></p>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        </div>
	      </div>
	      
	    </div>
	  </div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<script>
		$(document).ready(function(){
			$( "#policyType" ).change(function() {
				var val = $(this).val();
				if('Jewelry' === val){
					$('#coverageAmount option:eq(0)').text('2000');
					$('#coverageAmount option:eq(1)').text('5000');
					$('#coverageAmount option:eq(2)').text('10000');
					
					$('#coverageAmount option:eq(0)').val('2000');
					$('#coverageAmount option:eq(1)').val('5000');
					$('#coverageAmount option:eq(2)').val('10000');
				} else if('Electronics' === val){
					$('#coverageAmount option:eq(0)').text('1000');
					$('#coverageAmount option:eq(1)').text('3000');
					$('#coverageAmount option:eq(2)').text('6000');
					
					$('#coverageAmount option:eq(0)').val('1000');
					$('#coverageAmount option:eq(1)').val('3000');
					$('#coverageAmount option:eq(2)').val('6000');
				} else if('Sports_Equipment' === val){
					$('#coverageAmount option:eq(0)').text('5000');
					$('#coverageAmount option:eq(1)').text('10000');
					$('#coverageAmount option:eq(2)').text('20000');
					
					$('#coverageAmount option:eq(0)').val('5000');
					$('#coverageAmount option:eq(1)').val('10000');
					$('#coverageAmount option:eq(2)').val('20000');
				} else if('Bike' === val){
					$('#coverageAmount option:eq(0)').text('500');
					$('#coverageAmount option:eq(1)').text('1500');
					$('#coverageAmount option:eq(2)').text('3000');
					
					$('#coverageAmount option:eq(0)').val('500');
					$('#coverageAmount option:eq(1)').val('1500');
					$('#coverageAmount option:eq(2)').val('3000');
				}
			});
			
			$('#submit').click(function(event) {
				event.preventDefault();
				
				var data = {
					firstName     : $("#firstName").val(),
					lastName      : $("#lastName").val(),
					coverageAmount: $("#coverageAmount").val(),
					id            : $("#id").val(),
					age           : $("#age").val(),
					policyType    : $("#policyType").val()
				}
				
				$("#submit").prop("disabled", true);

				$.ajax({
		             type: "POST",
		             contentType: "application/json",
		             url: "/user/calculate-tariff",
		             data: JSON.stringify(data),
		             dataType: 'json',
		             timeout: 600000,
		             success: function (data) {
		             	console.log('data', data);
		             	var policy = '';
		             	$(data["insurancePolicy"]).each(function( index ) {
						  policy += "type : " + data["insurancePolicy"][index]['type'] + 
						  			" coverage : " + data["insurancePolicy"][index]['coverage'] + 
						  			" tariff : " + data["insurancePolicy"][index]['tariff'] + "<br>";
						});
		             	var text = "Insurance Policy of " + data['firstName'] + " " + data['lastName'] + ", age " + data['age'] + 
		             		"<br>" + policy;
		             	$("#result").html(text);
		             	$("#myModal").modal();
		                $("#submit").prop("disabled", false);
		             },
		             error: function (e) {
		                 $("#submit").prop("disabled", false);
		                 $("#result").html(e['responseText']);
		                 $("#myModal").modal();
		             }
				});
				
  			});
			
		});
	</script>
</body>
</html>
