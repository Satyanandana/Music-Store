<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Music Store</title>
<link rel="stylesheet" href="<c:url value='/styles/main.css'/>">
<!-- Latest compiled and minified CSS -->

<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
	<header>

	<h1 id="title">MUSIC STORE</h1>
	<div id="header">
		<c:url var="login" value="/login.html?preUrl=/welcome.html" />
		<c:url var="register" value="/register.html?preUrl=/welcome.html" />
		<c:url var="logout" value="/logout.html" />
		<UL>
			<LI class="header"><A class="header" HREF="${login}">Login </A></LI>
			<LI class="header"><A class="header" HREF="${register}">Register</A></LI>
			<LI class="header"><A class="header" HREF="${logout}">Logout</A></LI>
		</UL>
	</div>

	</header>
	<main>