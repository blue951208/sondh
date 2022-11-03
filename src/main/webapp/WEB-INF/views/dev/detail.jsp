<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세</title>
</head>
<body>
	<a href="/dev/note_form?cmd=update&no=${note.no}">수정</a>
	<table border="1">
		<thead>
			<tr>
				<th>No</th>
				<th>제목</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody>			
			<tr>
				<td>${ note.no }</td>
				<td>${ note.title }</td>
				<td>${ note.content }</td>
			</tr>			
		</tbody>
	</table>
</body>
</html>