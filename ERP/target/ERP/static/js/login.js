$(document).ready(function() {
  $('#forgotPassword').click(function(e) {
	  
    e.preventDefault();
    $('div#form-login').toggle('500');
  });
  $('#accessLogin').click(function(e) {
	 
    e.preventDefault();
    $('div#form-login').toggle('500');
  });
  
  
   $("#login-form").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxPost();
	});
    function ajaxPost(){
    	
    	// PREPARE FORM DATA
    	var loginData = {
    		username : $("#username").val(),
    		password :  $("#password").val()
    	}
   alert(loginData.username);
   alert(loginData.password);
  console.log(loginData.password);
  
  
  // DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : url + "/postcustomer",
			data : JSON.stringify(loginData),
			dataType : 'json',
			success : function(result) {
				if(result.status == "Done"){
					$("#postResultDiv").html("<strong>" + "Post Successfully! Customer's Info: FirstName = " 
							+ result.data.username + " ,LastName = " + result.data.username + "</strong>");
				}else{
					$("#postResultDiv").html("<strong>Error</strong>");
				}
				console.log(result);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
  
  
 
  
	} 
  
});

 function showPassword(){
	var inputType= $("#password").attr("type");	
	
	
	if(inputType=="password"){
		$("#password").removeAttr("type");
	    $("#password").attr("type","text");  
	    $("#imageOpen").removeAttr("class");
	    $("#imageOpen").attr("class","fa fa-eye-slash");
	}else{
	$("#password").removeAttr("type");
	    $("#password").attr("type","password"); 
	    $("#imageOpen").removeAttr("class");
	    $("#imageOpen").attr("class","fa fa-eye");
	}
};


