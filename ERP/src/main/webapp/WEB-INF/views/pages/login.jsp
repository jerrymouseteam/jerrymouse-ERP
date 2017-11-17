<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

	<nav id="header" class="navbar navbar-fixed-top navbar-inverse">
	<div id="header-container" class="container navbar-container">
		<div class="navbar-header">
			<h1 style="color: white" align="center">Jerry Mouse</h1>
			<!-- <a id="brand" class="navbar-brand" href="#">Jerry Mouse</a>-->
		</div>


	</div>
	<!-- /.container --> </nav>
	<div class="container well " style="width: 65%; margin-top: 150px">
		<div class="row">

			<div class="col-md-6 col-md-offset-3">

				<div style="padding: 20px;" id="form-login">
					<h4 style="border-bottom: 1px solid #c5c5c5;">
						<i class="glyphicon glyphicon-log-in"> </i> . Please Login to
						Continue .
					</h4>
					<br>

					<form action="" method="post" class="form-horizontal">
						<c:if test="${param.error != null}">
							<div class="alert alert-danger">
								<p>Invalid username and password ${loginUrl}.</p>
							</div>
						</c:if>
						<c:if test="${param.logout != null}">
							<div class="alert alert-success">
								<p>You have been logged out successfully.</p>
							</div>
						</c:if>

						<fieldset>

							<div class="form-group input-group">
								<span class="input-group-addon"> @ </span> <input
									class="form-control" id="username" placeholder="Username/Email"
									name="ssoId" type="text" required="" autofocus="">
							</div>
							<div class="form-group input-group">
								<span class="input-group-addon"> <i
									class="glyphicon glyphicon-lock"> </i>
								</span> <input class="form-control" id="password"
									placeholder="Password" name="password" type="password" value=""
									required=""> <a id="showHide" title="Show Password"
									style="cursor: pointer; color: gray; margin-top: -2.5rem"
									class="errspan" onclick="showPassword(this)"> <span><i
										class="fa fa-eye" aria-hidden="true" id="imageOpen"></i></span>
								</a> <input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</div>


							<label class="checkbox" style="margin-left: 24px;"> <input
								type="checkbox" name="remember-me" value="true" id="remember-me">
								<form:checkboxes path=remember-me items="remember-me" />Remember
								me

							</label>



							<div class="form-group">


								<button type="submit" class="btn btn-primary btn-block">Login</button>

								<p class="help-block">
									<a class="pull-right text-muted" href="#" id="forgotPassword"><small>Forgot
											your password?</small></a>
								</p>
							</div>
							<div id="postResultDiv"></div>
						</fieldset>
					</form>
				</div>
				<div style="display: none;" id="form-login">
					<h4 class="">Forgot your password?</h4>
					<form action="forgotPassword" method="GET" class="form-horizontal" id="formm">

						<fieldset>
							<span class="help-block"> Kindly enter email address or
								phone number. <br> We'll send you a link with instructions
								to reset a new password.
							</span> 
							<div class="form-group input-group">
								<span class="input-group-addon"> @ </span> <input
									class="form-control" placeholder="Email" name="email"
									type="email" required=""id="emailId"  items="${users}" >
							</div>
							
							<p class="help-block">
							<a href="#" id="ss" class="btn btn-success custom-width">edit</a>
				       
								<a class="text-muted" href="dashboard" id="accessLogin"><small>Account
										Login</small></a>
							</p>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>

