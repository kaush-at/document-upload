<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document Upload</title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data"> <!-- enctype => encrypt type | when we upload document we need to use multipart/form-data-->
<!-- multipart/form-data this tells to the server along with the form data there is another attachment or file that are come in-->

Id : <input type="text" name="id"/>
Document : <input type="file" name="document"/>
<br>
<input type="submit" name="submit" value="Upload">
<br>
<br>
<table>
		<thead>
			<tr>
				<td>Id</td>
				<td>Document Name</td>
				<td>Link</td>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="document" items="${documents}">
				<tr>
					<td>${document.id}</td>
					<td>${document.name}</td>
					<td><a href="download?id=${document.id}">Download</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</form>
</body>
</html>