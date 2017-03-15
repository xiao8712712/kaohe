<%@ page language="java" contentType="text/html; charset=UTF-8" 
    import="com.hand.beans.FilmBean,java.util.List,java.util.ArrayList"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
List<FilmBean> filmlist = null;
filmlist=(List<FilmBean>)request.getAttribute("filmList");

%>


<center><button onclick=<%="location.href='"+request.getContextPath()+"/ServletTest?action=filmAdd'"%>>新增电影</button></center>
<table width="1300">
	<tr><th>film_id</th><th>title</th><th>description</th><th>languag</th><th>operation</th>
	</tr>
<%
if(filmlist!=null){
for(int i=0;i<filmlist.size();i++){%>
<tr>
<td><%=filmlist.get(i).getFilm_id() %></td>
<td><%=filmlist.get(i).getTitle() %></td>
<td><%=filmlist.get(i).getDescription() %></td>
<td><%=filmlist.get(i).getLanguage() %></td>
<td width="200"><button onclick=<%="location.href='"+request.getContextPath()+"/ServletTest?action=filmDel&film_id="+filmlist.get(i).getFilm_id()+"'"%>>删除电影</button>
	/<button onclick=<%="location.href='"+request.getContextPath()+"/ServletTest?action=filmUpdate&film_id="+filmlist.get(i).getFilm_id()+"'"%>>编辑电影</button>
</td>

</tr>
<%}}%>
</table>
</body>
</html>