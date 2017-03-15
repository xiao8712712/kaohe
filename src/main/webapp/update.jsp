<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="com.hand.beans.*,java.util.*"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
FilmBean film =null;
film = (FilmBean)request.getAttribute("film");
List<LanguageBean> languagelist = null;
languagelist = (ArrayList<LanguageBean> )request.getAttribute("languagelist");

if(film!=null){
%>
<form action=<%=request.getContextPath()+"/ServletTest"%> method="post">
<input hidden="true"  type="text" value=<%=film.getFilm_id()%> name="film_id" id="film_id" ><br>
Title<input type="text"  value="<%=film.getTitle()%>" name="title" id="title" ><br>
Description<textarea cols="150" rows="1" style="font-size: 10;"  name="description" ><%=film.getDescription()%></textarea><br>
last_update<input  type="text"  name="last_update" id="last_update" value="<%=film.getLast_update()%>" ><br>
Language:

Language:<select name="language_id">
<%for(int i=0;i<languagelist.size();i++){ 
	if(languagelist.get(i).getLanguage_id()==film.getLanguage_id()){
%>
<option selected="selected" value="<%=languagelist.get(i).getLanguage_id() %>"><%=languagelist.get(i).getName() %></option>
<%} else{
	out.print(languagelist.get(i).getName());
%>
<option value="<%=languagelist.get(i).getLanguage_id() %>"><%=languagelist.get(i).getName() %></option>
<%}}%>
</select>
<br>
<input type="submit" value="确认修改" >&nbsp;<input type="reset" value="重新填写">
</form>
<%} %>
</body>
</html>