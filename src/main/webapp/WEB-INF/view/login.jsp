<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<sec:csrfMetaTags/>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>
<body>
	<div id="login-box">
		<h1 id="banner" style="font-family: arial">Spring 4 Security MongoDB</h1>
		<form name="f" action="<c:url value='j_spring_security_check'/>" method="POST">
		   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<table style="font-family: arial">
				<tr>
					<td>Username:</td>
					<td><input type='text' name='username' /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password'></td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan='2'><input value="Send" name="submit"
						type="submit">&nbsp; <input value="Reset" name="reset"
						type="reset"></td>
				</tr>
			</table>
		</form>
	</div>
</body>

</html>