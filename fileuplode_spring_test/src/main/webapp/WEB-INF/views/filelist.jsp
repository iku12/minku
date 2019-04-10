<%@page import="com.hk.fdto.FileDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html;charset=utf-8");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일목록</title>
</head>
<% List<FileDto>list =(List<FileDto>)request.getAttribute("list"); %>


<body>

<h1>파일목록</h1>

<table border="1">
	<tr>
	<th>번호</th>
	<th>원본파일명</th>
	<th>저장파일명</th>
	<th>파일사이즈</th>
	<th>업로드날짜ㅓ</th>
	<th>삭제여부</th>
	</tr>
	
	<%
	
		for(FileDto dto:list){
			%>
			<tr>
			<td><%=dto.getSeq()%></td>
			<td><a href="download.do?seq=<%=dto.getSeq()%>"><%=dto.getOrigin_fname()%></a></td>
			<td><%=dto.getStored_fname()%></td>
			<td><%=dto.getFile_size()%></td>
			<td><%=dto.getF_regdate()%></td>
			<td><%=dto.getF_delflag()%></td>
			
			</tr>
			<% 
		}
	%>
	
</table>







</body>
</html>