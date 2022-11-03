<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맛집,음식 등록</title>
</head>
<body>
	<form method="post" action="/food/insert_proc" enctype="multipart/form-data">
		제목  : <input type="text" name="name" /><br/>
		이미지 : <input type="file" name="img" /><br/> 
		설명 : <textarea name="content"></textarea>
		<button type="submit">등록</button>
	</form>
</body>
</html>