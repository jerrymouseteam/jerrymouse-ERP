$(document).ready(function(){

    	$("#projectSide").click(function(){
		$("#dropdownProject").toggle();
		});
		$("#userSide").click(function(){
		$("#dropdownUser").toggle();
		});
		
		$("#projectSide").click(function(){
		$("#table1").hide();
		$("#projectMain").show();
		$("#divEditSearchProject").hide();
		$("#divClosedProject").hide();
		});
		
		$("#projectAdd").click(function(){
		$("#divAddProject").show(500);
		$("#projectMain").hide();
		$("#divEditSearchProject").hide();
		$("#divClosedProject").hide();
		});
		
		$("#projectSearch").click(function(){
		$("#divEditSearchProject").show(500);
		$("#projectMain").hide();
		$("#divAddProject").hide();
		$("#divClosedProject").hide();
		});
		
		
		$("#ClosedProject").click(function(){
		$("#divClosedProject").show(500);
		$("#projectMain").hide();
		$("#divAddProject").hide();
		$("#divEditSearchProject").hide();
		});
		
		
		
		 $('#datatable').dataTable();
    
     $("[data-toggle=tooltip]").tooltip();
		
		
		
		});
		