<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<body style="font-family: arial">
	<h2 id="banner">Welcome to Spring Security 4 MongoDB</h2>

	<h2>Your user info</h2>
	<h6>
		<a href="/SpringMVCSecurity4Mongo/logout"><b>Click here to logout</b>
	</h2>
	</a>
	</h6>
	<sec:authorize access="isAuthenticated()">
		<b>Your Username: </b>
		<sec:authentication property="principal.username" />
		<b>Your Role: </b>
		<sec:authentication property="principal.authorities" />
	</sec:authorize>

	<h1 id="banner">MENU</h1>
	<p class="message"></p>
	<a href="/SpringMVCSecurity4Mongo/listUsers">Users</a>

	<p class="message"></p>
	<a href="/SpringMVCSecurity4Mongo/listCampaigns">Campaigns</a>


	<p class="message"></p>
	<a href="/SpringMVCSecurity4Mongo/logout">Log-out</a>
</body>
</html>