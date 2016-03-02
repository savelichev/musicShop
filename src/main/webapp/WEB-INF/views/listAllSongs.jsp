<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Songs list</title>
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
				<h3><a href="newSong">New Song</a></h3>
			    <h1>Songs List</h1>
			<br/>			   
				<table border="2">
						    <th>Song ID</th>
						    <th>Title</th>
						    <th>Artist ID</th>
						    <th>Modify</th>
	
				    <c:forEach var="song" items="${listSong}" varStatus="status">
						<tr>
							<td>${song.songId}</td>
							<td>${song.songTitle}</td>
							<td>${song.artistId}</td>
							<td>
							    <a href="editSong?id=${song.songId}">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="deleteSong?id=${song.songId}">Delete</a>
							</td>
						</tr>
					</c:forEach>             
				</table>
				
			</div>
		</div>
	</body>
</html>