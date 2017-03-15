<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<script type="text/javascript">
  function login(){
	  document.getElementById("from").style.display='block';
  }
</script>
</head>
<body>
 <%
  String msg = null;
  msg = (String)request.getAttribute("msg");
  String name = null;
  name = (String)request.getSession().getAttribute("name");
  if(msg==null&&name==null){
  	out.print("<font color='red'>请点击登陆</font><br>");//第一次进入
  	%>
  	<button onclick="login()">登陆</button>
    <% 
  }else if(msg==null&&name!= null){
  	out.print("<font color='red'>欢迎您！"+name+"</font><br>");//登录成功
  }else{
  	out.print("<font color='red'>"+msg+"</font><br>");//登录失败
  %>
     <button onclick="login()">登陆</button>
  <%
  }
  %>
<button onclick=<%="location.href='"+request.getContextPath()+"/ServletTest?action=filmList'"%> >电影列表 </button>
<button onclick=<%="location.href='"+request.getContextPath()+"/ServletTest?action=filmList'"%> >新增电影 </button>
<button onclick=<%="location.href='"+request.getContextPath()+"/ServletTest?action=filmList'"%> >删除电影 </button>
<button onclick=<%="location.href='"+request.getContextPath()+"/ServletTest?action=filmList'"%> >编辑电影 </button>

<form id="from" action=<%=request.getContextPath()+"/ServletTest?action=loginCheck"%> method="post" style="display: none">
<table>
<tr>
<td>用户名：</td><td><input type="text" name="name"></td>
</tr>
<tr>
<td><input type="submit" value="提交"></td><td><input type="reset" value="重置"></td>
</tr>
</table>
</form>
</body>
</html>
