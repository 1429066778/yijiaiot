<%@ page language="java" import="java.util.*,Bean.Bean" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>添加设备</title>
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
  
  <body><br><br><br><br>
    <center><front color="white"><h1>敬告：请您务必输入正确的设备号，请输入您自己的设备号！</h1></front></center>
	<form action="addcheckid" method="post" id="registerForm">
		<div>
			<input type="text" name="checkid" placeholder="输入设备编号" oncontextmenu="return false" onpaste="return false" />
		</div>
		<button id="submit" type="submit">提 交</button>
	</form>
	<a href="login.jsp">
		<button type="button" class="register-tis">没有设备？点击购买</button>
	</a>
</div>
<center><br><br><br><br><br><br>
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