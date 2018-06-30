<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎注册</title>
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
 <div class="register-container">
	<h1>欢迎注册！</h1>	
	<div id="xinxi" class="connect">
		<p>科技引领智能，智能改变生活!</p>
	</div>
	<%
	String u="";
    if(request.getParameter("use")!=null)
     u=new String(request.getParameter("use")); 
     if(u.equals("1")){
     	u="系统原因注册失败，请重新注册";
     }else if(u.equals("2")){
    	u="注册失败，用户名已经存在！";
     }
     %> 
 <h4><font color="red">  <%=u %></font></h4>
	<form onsubmit="return false" action="##" method="post"id="registerForm">
		<div>
			<input type="text" name="username" class="username" placeholder="用户名" autocomplete="off"/>
		</div>
		<div>
			<input type="password" name="password" class="password" placeholder="输入密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input type="password" name="confirm_password" class="confirm_password" placeholder="再次输入密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input type="text" name="phone_number" class="phone_number" placeholder="手机号" autocomplete="off" id="number"/>
		</div>
		<div>
			<input type="text" name="name" class="username" placeholder="姓名" autocomplete="off"/>
		</div>
		<div>
			<input type="email" name="mail" class="email" placeholder="邮箱地址" oncontextmenu="return false" onpaste="return false" />
		</div>

		<button id="submit" onclick="zuce()" type="submit">注 册</button>
	</form>
	<a href="login.jsp">
		<button type="button" class="register-tis">已经有账号？</button>
	</a>

</div>
<center>
<span id=xitongshijian></span>
    <script type="text/javascript">
function reloadCode()
{
  var time=new Date().getTime();
  document.getElementById("imagecode").src="<%= request.getContextPath()%>/ImageServlet?d="+time;
}
function showLocale(objD)
{
var str,colorhead,colorfoot;
var yy = objD.getYear();
if(yy<1900) yy = yy+1900;
var MM = objD.getMonth()+1;
if(MM<10) MM = '0' + MM;
var dd = objD.getDate();
if(dd<10) dd = '0' + dd;
var hh = objD.getHours();
if(hh<10) hh = '0' + hh;
var mm = objD.getMinutes();
if(mm<10) mm = '0' + mm;
var ss = objD.getSeconds();
if(ss<10) ss = '0' + ss;
var ww = objD.getDay();
if ( ww==0 ) colorhead="<font color=\"#000000\">";
if ( ww > 0 && ww < 6 ) colorhead="<font color=\"#000000\">";
if ( ww==6 ) colorhead="<font color=\"#000000\">";
if (ww==0) ww="星期日";
if (ww==1) ww="星期一";
if (ww==2) ww="星期二";
if (ww==3) ww="星期三";
if (ww==4) ww="星期四";
if (ww==5) ww="星期五";
if (ww==6) ww="星期六";
colorfoot="</font>"
str = colorhead + yy + "-" + MM + "-" + dd + " " + hh + ":" + mm + ":" + ss + " " + ww + colorfoot;
return(str);
}
function tick()
{
var today;
today = new Date();
document.getElementById("xitongshijian").innerHTML = showLocale(today);
window.setTimeout("tick()", 1000);
}
tick();
</script>

  </center>
</body>
<script src="js/jquery.min.js"></script>
<script src="js/common.js"></script>
<!--背景图片自动更换-->
<script src="js/supersized.3.2.7.min.js"></script>
<script src="js/supersized-init.js"></script>
<!--表单验证-->
<script src="js/jquery.validate.min.js?var1.14.0"></script>
</html>