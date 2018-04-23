<%@ page language="java" import="java.util.*,Bean.Bean" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>信息查看修改</title>
    
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
	<%
    ArrayList userlist=(ArrayList)request.getAttribute("userlist");
   %>
<h1>您的信息</h1>
<form>
        <%for(int i=0;i<userlist.size();i++){
        Bean user=(Bean)userlist.get(i);%>
       <front color="white"> <h2><div>用户名：<%=user.Get_username()%></div><br>
        <div>设备ID：<%=user.Get_check_id() %></div><br>
        <div>手机号码：<%=user.Get_phone_number() %></div><br>
        <div>姓名：<%=user.Get_name() %></div><br>
        <div>邮箱：<%=user.Get_mail() %></div></h2><br>
        </front>
         <% 
        } %>
        <a href="infomodify1.jsp">
		<button type="button" class="register-tis">点击修改信息</button>
	</a>
	<a href="addcheckid.jsp">
		<button type="button" class="register-tis">点击添加设备</button>
	</a>
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