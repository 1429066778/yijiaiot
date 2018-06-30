<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>欢迎登录YIJIA</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/login.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/style.css">
  </head>
  <body>
  	<%
		String u="";
  		if(request.getParameter("use")!=null)
    	u=new String(request.getParameter("use")); 
     	if(u.equals("0")){
     		u="注册成功，请登录！";
     	}
   %> 
	<div class="login-container">
	<h1>欢迎登录YIJIAIOT</h1><br>
 	<h2 id="xinxi"><%=u %><font color="white">  </font></h2>
	<div class="connect">
		<p></p>
	</div>	
	<form id="loginForm" onsubmit="return false" action="##" method="post">
		<div>
			<input type="text" name="username" class="username" placeholder="用户名" autocomplete="off"/>
		</div>
		<div>
			<input type="password" name="password" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<button id="submit" type="submit" onclick="login()">登 录</button> 
		<!-- <input type="button" value="登录" onclick="login()"> -->
	</form>
	<a href="zuce.jsp">
		<button type="button" class="register-tis">还没有账号？</button>
	</a>
	</div>
<script src="js/jquery.min.js"></script>
<script src="js/common.js"></script>
<!--背景图片自动更换-->
<script src="js/supersized.3.2.7.min.js"></script>
<script src="js/supersized-init.js"></script>
<!--表单验证-->
<script src="js/jquery.validate.min.js?var1.14.0"></script>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
<p></p>
<p>Copyright &copy; 2018<a target="_blank" href="http://w-23028-28897-93380.47906461.sites.hk40.qifeiye.com/">田培贤</a></p>
</div>
</body>

</html>