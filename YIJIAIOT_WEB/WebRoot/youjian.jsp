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
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	.border{
		width:300px;
		height:300px;
		border:0px solid black;
	}
	img{
		width:100%;
	}
	</style>
	<script type="text/javascript">
		function showImg(){
		$("#content img").each(function(index,element){
		var width=$(element).width();
		var bili=6/10;
		$(element).css("height",width*bili);
		});
		}
	</script>
<link rel="stylesheet" href="css/style.css">
  </head>
  
  <body onload="showImg()">
<br><br><br><br><h1><font color="white">  如果您在使用过程中遇到任何问题，或者有更好的建议，请联系我！</font></h1>

<div class="login-container">
	
</div>
<div id="content">
	<div class="border" style="float:left;"></div>
<div class="border" style="float:left;"><img src="images/qq.jpg"/><h2><font color="white
	">QQ</font></h2></div>
	<div class="border" style="float:left;"></div>
	<div class="border" style="float:left;"></div>
<div class="border" style="float:left;"><img src="images/weixin.jpg"/><h2><font color="white
	">微信</font></h2></div>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/common.js"></script>
<!--背景图片自动更换-->
<script src="js/supersized.3.2.7.min.js"></script>
<script src="js/supersized-init.js"></script>
<!--表单验证-->
<script src="js/jquery.validate.min.js?var1.14.0"></script>


</body>

</html>