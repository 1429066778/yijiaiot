<%@ page language="java" import="java.util.*,Bean.USE" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/login.js"></script>
    <script src="js/jquery.min.js"></script>
	<!--  <script src="js/common.js"></script>-->
    <title>YIJIA网页客户端</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script > window.onload= buttonOnclick();</script>
</head>
 <body style="background-image:url(images/4.jpg);background-size:cover;margin:0">
  <style type="text/css">
  form{
  	position:relative;
  	width:305px;margin:15px;
  }
  input{
  	width:270px;height:42px;
  	line-height:42px;margin-top:25px;
  	padding:0 15px;background:#2d2d2d;
  	background:rgba(45,45,45,.15);
  	-moz-border-radius:6px;
  	-webkit-border-radius:6px;
  	border-radius:6px;
  	border:1px solid #3d3d3d;
  	border:1px solid rgba(255,255,255,.15);
  	-moz-box-shadow:0 2px 3px 0 rgba(0,0,0,.1) inset;
  	-webkit-box-shadow:0 2px 3px 0 rgba(0,0,0,.1) inset;
  	box-shadow:0 2px 3px 0 rgba(0,0,0,.1) inset;
  	font-family:"Microsoft YaHei",Helvetica,Arial,sans-serif;
  	font-size:14px;color:#fff;text-shadow:0 1px 2px rgba(0,0,0,.1);
  	-o-transition:all .2s;
  	-moz-transition:all .2s;
  	-webkit-transition:all .2s;
  	-ms-transition:all .2s
  }
  input:-moz-placeholder{color:#fff}
  input:-ms-input-placeholder{color:#fff}
  input::-webkit-input-placeholder{color:#fff}
  input:focus{
    outline:0;-moz-box-shadow:0 2px 3px 0 rgba(0,0,0,.1) inset,0 2px 7px 0 rgba(0,0,0,.2);
    -webkit-box-shadow:0 2px 3px 0 rgba(0,0,0,.1) inset,0 2px 7px 0 rgba(0,0,0,.2);
    box-shadow:0 2px 3px 0 rgba(0,0,0,.1) inset,0 2px 7px 0 rgba(0,0,0,.2)
   }
  button{
  	width:270px;
  	height:42px;
  	line-height:42px;
  	margin-top:25px;
  	padding:0 15px;
  	background:#2d2d2d;
  	background:rgba(45,45,45,.15);
  	-moz-border-radius:6px;
  	-webkit-border-radius:6px;
  	border-radius:6px;
  	border:1px solid #3d3d3d;
  	border:1px solid rgba(255,255,255,.15);
  	-moz-box-shadow:0 2px 3px 0 rgba(0,0,0,.1) inset;
  	-webkit-box-shadow:0 2px 3px 0 rgba(0,0,0,.1) inset;
  	box-shadow:0 2px 3px 0 rgba(0,0,0,.1) inset;
  	font-family:"Microsoft YaHei",Helvetica,Arial,sans-serif;
  	font-size:14px;color:#fff;text-shadow:0 1px 2px rgba(0,0,0,.1);
  	-o-transition:all .2s;-moz-transition:all .2s;
  	-webkit-transition:all .2s;-ms-transition:all .2s
  }
  button:hover{
  	-moz-box-shadow:0 15px 30px 0 rgba(255,255,255,.15) inset,0 2px 7px 0 rgba(0,0,0,.2);
  	-webkit-box-shadow:0 15px 30px 0 rgba(255,255,255,.15) inset,0 2px 7px 0 rgba(0,0,0,.2);
  	box-shadow:0 15px 30px 0 rgba(255,255,255,.15) inset,0 2px 7px 0 rgba(0,0,0,.2)
  }
  button:active{
  	-moz-box-shadow:0 15px 30px 0 rgba(255,255,255,.15) inset,0 2px 7px 0 rgba(0,0,0,.2);
  	-webkit-box-shadow:0 15px 30px 0 rgba(255,255,255,.15) inset,0 2px 7px 0 rgba(0,0,0,.2);
  	box-shadow:0 5px 8px 0 rgba(0,0,0,.1) inset,0 1px 4px 0 rgba(0,0,0,.1);
  	border:0 solid #3d3d3d
  }
  a:link,a:visited{color:gray;}
   .a{font-size:20px;color:black;}
   .b{font-size:30px;color:white;}
   .c{font-size:20px;color:red;}
   .d{font-size:20px;color:gray;}
   .e{color:purple;}
   .f{color:white}
 </style>
 <table border="0" width="100%">
    <tbody border="0"> 
    <tr  border="0"><td width="%50" border="0">
	<iframe width="420" scrolling="no" height="60" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=12&color=%23FFFFFF&icon=1&num=5&site=12"></iframe></td>
	<td width="10%" border="0"></td>
  		<td width="10%" border="0"></td>
		<td width="10%" border="0"><center><a href="youjian.jsp" target="_blank" title="点击联系我">联系我</a></center></td>
		<td width="10%" border="0"><a href="zuce.jsp" target="_blank" title="点击注册">注册</a></td>
		<td id="name" width="10%" border="0"><a href="login.jsp" target="_blank" title="点击重新登录">重新登录</a></td>

		<td  width="10%" border="0"><a id="username" href="infomodify" title="点击查看修改您的信息"></a></td>
	</tbody>
	</table>
 		<img src="images/5.jpg" width="100%" height="200" border="0"/>
 		<hr color="gray">
 		<br/>
 		<center><strong><span class="b"><h1>室内环境状况显示</h1></span></strong></center>
		 <br/>
 		<span class="a">
 	<table width="100%">
   <tr><td  width="30%" height="60">温度：<span id="wendu"></span>C</td>
   <td  width="30%" height="60">湿度：<span id="shidu"></span>%</td>
   <td  width="30%" height="60">光强：<span id="guangqiang"></span>%</td></tr>
   <tr><td width="30%" height="60">PM2.5：<span id="PM25"></span>mg/m3</td>
   <td  width="30%" height="60">PM10：<span id="PM10"></span>mg/m3</td>
   <td  width="30%" height="60">甲醛：<span id="jiaquan"></span>mg/m3</td></tr>
 	</tbody>
</table>
</span>
<hr color="gray">
<center><strong><span class="b"><h1>遥控选项</h1></span></strong></center>
<br/>

<font size="4" color="white">反馈:</font><span id="message" class="c"></span><br/>
        
<form action="Server" onsubmit="return false" action="##" method="post">
 <table class="stress" border="0"  cellpadding="50" cellspacing="0" width="100%">
  <tbody>
   <tr>
   	<td width="33%"><button  onclick="buttonOnclick(1)">开灯</button></th>
   	<td width="33%"><button type="submit" onclick="buttonOnclick(2)">关灯</button></th>
   	<td width="33%"><button type="submit" onclick="buttonOnclick(3)">开风扇</button></th>
   
   <tr>
   	<td width="25%"><button type="submit" onclick="buttonOnclick(4)">关风扇</button></th>
  	<td width="25%"><button type="submit" onclick="buttonOnclick(5)">开电视</button></th>
 	<td width="25%"><button type="submit" onclick="buttonOnclick(6)">关电视</button></th>
 	<tr><td width="25%"><button type="submit" onclick="buttonOnclick(7)">开空调</button></th>
 	<td width="25%"><button type="submit" onclick="buttonOnclick(8)">关空调</button></th>
  </tbody>
</table>
</body>
</html>