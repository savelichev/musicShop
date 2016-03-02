<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
	<head>
	        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	        <title>Artist list</title>
	        <link href="resources/css/shop_style.css" rel="stylesheet" type="text/css" />
	</head>
	
	   
	<body>
		<div id="main_container">
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
				<h3><a href="newArtist">New Artist</a></h3>
			    <h1>Artists List</h1>
			<br/> 
				<table border="2">
						    <th>Artist ID</th>
						    <th>Name</th>
						    <th>Role</th>
						    <th>Band_id</th>
						    <th>Modify</th>
	
				    <c:forEach var="artist" items="${listArtist}" varStatus="status">
						<tr>
							<td>${artist.artistId}</td>
							<td>${artist.artistName}</td>
							<td>${artist.artistRole}</td>
							<td>${artist.bandId}</td>
							<td>
							    <a href="editArtist?id=${artist.artistId}">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="deleteArtist?id=${artist.artistId}">Delete</a>
							</td>
						</tr>
					</c:forEach>             
				</table>
			</div>  
		</div>
	</body>
</html>