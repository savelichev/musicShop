<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="resources/css/shop_style.css" rel="stylesheet" type="text/css" />
		<title>New/Edit Band</title>
	</head>
	<body>
	
		<div id="top_menu">
	  		<ul>
	          	<li><a href="index" class="current fast">Home</a></li>
	            <li><a href="listSong" target="_parent">Songs</a></li>
	            <li><a href="listArtist" target="_parent">Artists</a></li>
	            <li><a href="listBand" target="_parent">Bands</a></li>
	            <li><a href="#">About</a></li>
	            <li><a href="#">Contact</a></li>
	       </ul>
		</div> <!-- end of menu -->
	
	    <div align="center">
	        <h1>Add or edit Band</h1><br/>
	        <form:form action="saveBand" method="post" modelAttribute="band">
		        <table>
		            <form:hidden path="bandId"/>
		            <tr>
		                <td>Band name:</td>
		                <td><form:input path="bandName" /></td>
		            </tr>
		            
		            <tr>
		                <td colspan="2" align="center"><input type="submit" value="Save"></td>
		            </tr>
		        </table>
	        </form:form>
	    </div>
	</body>
</html>