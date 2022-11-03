<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개발노트 등록화면</title>
</head>
<body>
	<form action="/${param.cmd}_proc" type="post">
		<input type="hidden" name="no" value="${note.no}"/>
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${note.title}"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content">${note.content}</textarea></td>
			</tr>
		</table>				
		<button type="submit">${ param.cmd eq 'insert' ? '등록' : '수정' }</button>
	</form>
</body>
</html>