<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="com.hand.beans.*,java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<LanguageBean> languagelist = null;
languagelist = (ArrayList<LanguageBean> )request.getAttribute("languagelist");
%>

<form action=<%=request.getContextPath()+"/ServletTest?action=add"%> method="post">
Title<input type="text"   name="title" id="title" ><br>
Description<textarea cols="150" rows="1" style="font-size: 10;"  name="description" ></textarea><br>
Language:
<%for(int i=0;i<languagelist.size();i++){ 
	if(languagelist.get(i).getLanguage_id()==1){
    out.print(languagelist.get(i).getName());
%>
<input type="radio" checked="checked" name="language_id"  value="<%=languagelist.get(i).getLanguage_id() %>" >
<%} else{
	out.print(languagelist.get(i).getName());
%>
<input type="radio"  id="language_id" value="<%=languagelist.get(i).getLanguage_id() %>" >
<%}}%>
<br>

<input type="submit" value="确认修改" >&nbsp;<input type="reset" value="重新填写">
</form>
</body>
</html>