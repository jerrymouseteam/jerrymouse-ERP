$(document)
		.ready(
				function() {
				
					
					
					$("#projectMenu").click(function(){
						$("#dash").hide();
		        		//$("#projectMenu").attr('href',"http://localhost:8080/ERP/project");
		        		//window.location.href="project#addProject"
		        		$("#dropdownProject").toggle();
		        		});
						
						$("#projectSide").click(function(){
						$("#projectMain").show(500);
						$("#divAddProject").hide();
						$("#divEditSearchProject").hide();
						$("#divClosedProject").hide();
						});
					$("#projectAdd").click(function() {
						alert("aa");
						$("#divAddProject").show(500);
						$("#projectMain").hide();
						$("#divEditSearchProject").hide();
						$("#divClosedProject").hide();

					});
					/*
					 * $("#projectSearch").click(function(){
					 * $("#divEditSearchProject").show(500);
					 * $("#projectMain").hide(); $("#divAddProject").hide();
					 * $("#divClosedProject").hide(); });
					 */

					$("#ClosedProject").click(function() {
						var dataa;
						$.ajax({
							type : "GET",
							contentType : "application/json",
							url : './closedproject',
							success : function(data) {
								alert("hi");
								console.log(data);
								dataa = data[0];
								console.log(dataa);
								$('#datatable1').DataTable({
									'processing' : true,

									"aaData" : data,
									"scrollX" : true,
									"aoColumns" : [

									{
										"mData" : 'projectName'
									}, {
										"mData" : 'subDivisionName'
									}, {
										"mData" : 'startDate'
									}, {
										"mData" : 'endDate'
									}, {
										"mData" : 'projectAddress'
									}, {
										"mData" : 'remarks'
									}, {
										"mData" : 'contactPersonName'
									}, {
										"mData" : 'contactPersonEmail'
									}, {
										"mData" : 'contactPersonPhone'
									}, {
										"mData" : 'projectClientName'
									}, {
										"mData" : 'projectClientEmail'
									}, {
										"mData" : 'projectClientPhone'
									}, {
										"mData" : 'architectName'
									}, {
										"mData" : 'architectEmail'
									}, {
										"mData" : 'architectPhone'
									}, {
										"mData" : 'structuralName'
									}, {
										"mData" : 'structuralEmail'
									}, {
										"mData" : 'structuralPhone'
									} ]

								});

							},
							error : function(e) {
								console.log("ERROR: ", e);
								// display(e);
							},
							done : function(e) {
								console.log("DONE");
							}
						});

						$("#divClosedProject").show(500);
						$("#projectMain").hide();
						$("#divAddProject").hide();
						$("#divEditSearchProject").hide();
					});

					$("[data-toggle=tooltip]").tooltip();
					$('#projectSearch').click(function() {
						var dataa;
						$.ajax({
							type : "GET",
							contentType : "application/json",
							url : './listproject',
							success : function(data) {

								console.log(data);
								dataa = data[0];
								console.log(dataa);
								$('#datatable').DataTable({
									'processing' : true,

									"aaData" : data,
									"scrollX" : true,
									"aoColumns" : [

									{
										"mData" : 'projectName'
									}, {
										"mData" : 'subDivisionName'
									}, {
										"mData" : 'startDate'
									}, {
										"mData" : 'endDate'
									}, {
										"mData" : 'projectAddress'
									}, {
										"mData" : 'remarks'
									}, {
										"mData" : 'contactPersonName'
									}, {
										"mData" : 'contactPersonEmail'
									}, {
										"mData" : 'contactPersonPhone'
									}, {
										"mData" : 'projectClientName'
									}, {
										"mData" : 'projectClientEmail'
									}, {
										"mData" : 'projectClientPhone'
									}, {
										"mData" : 'architectName'
									}, {
										"mData" : 'architectEmail'
									}, {
										"mData" : 'architectPhone'
									}, {
										"mData" : 'structuralName'
									}, {
										"mData" : 'structuralEmail'
									}, {
										"mData" : 'structuralPhone'
									} ]

								});

							},
							error : function(e) {
								console.log("ERROR: ", e);
								// display(e);
							},
							done : function(e) {
								console.log("DONE");
							}
						});
						// var V=JSON.parse(data);
						// console.log("sssssssssssssssssssssssssssssssssss"+JSON.parse(data));
						$("#divEditSearchProject").show(500);
						$("#projectMain").hide();
						$("#divAddProject").hide();
						$("#divClosedProject").hide();

					});
				});
