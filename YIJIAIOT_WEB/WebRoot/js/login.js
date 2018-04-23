function getXMLHttpRequest(){
	var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		return xmlhttp;
}

function buttonOnclick(data) {
		if(data=="1")
			alert("您确定要打开电灯吗？");
		if(data=="2")
			alert("您确定要关闭电灯吗？");
		if(data=="3")
			alert("您确定要打开风扇吗？");
		if(data=="4")
			alert("您确定要关闭风扇吗？");
		if(data=="5")
			alert("您确定要打开电视吗？");
		if(data=="6")
			alert("您确定要关闭电视吗？");
		if(data=="7")
			alert("您确定要打开空调吗？");
		if(data=="8")
			alert("您确定要关闭空调吗？");			
    $.ajax({            
    //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/YIJIAIOT_WEB/Server",//url
        data: {m:data},             
        success: function (result) {          
            //document.getElementById("xinxi").innerHTML=JSON.stringify(result);
            var bd="无设备,请先购买添加设备！！！";
                document.getElementById("username").innerHTML=result[0].user;
                document.getElementById("wendu").innerHTML=result[0].wendu;
                document.getElementById("shidu").innerHTML=result[0].shidu;
                document.getElementById("guangqiang").innerHTML=result[0].guangqiang;
                document.getElementById("PM25").innerHTML=result[0].PM25;
                document.getElementById("PM10").innerHTML=result[0].PM10;
                document.getElementById("jiaquan").innerHTML=result[0].jiaquan;
                document.getElementById("message").innerHTML=result[0].message;
                if(result[0].message==bd){
                	alert(result[0].message);
                }
            if (result.resultCode == 200) {

            }
            ;
        },
        error : function(error) {
            alert("异常！"+error);
        }
    }); 
}

function login() {
    $.ajax({
    //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/YIJIAIOT_WEB/Login" ,//url
        data: $('#loginForm').serialize(),              
        success: function (result) { 
         result[0].message;        
          var f="no";
          var t="yes";
          if(t==result[0].message)
          {
          	location.href="main.jsp";
          }
          if(f==result[0].message)
          {
          	document.getElementById("xinxi").innerHTML="用户名或密码错误！";
          }  
            if (result.resultCode == 200) {
                alert("SUCCESS");
            };
        },
        error : function(error) {
            alert("异常！"+error);                 
        }
    });
}


function zuce() {
    $.ajax({
    //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/YIJIAIOT_WEB/zuce" ,//url
        data: $('#registerForm').serialize(),              
        success: function (result) { 
         result[0].message;        
          var f="no";
          var t="yes";
          var c="error";
          if(t==result[0].message)
          {
          	location.href="login.jsp";
          }
          if(f==result[0].message)
          {
          	document.getElementById("xinxi").innerHTML="注册失败！";
          }  
          if(c==result[0].message)
          {
          	document.getElementById("xinxi").innerHTML="用户名已经存在！";
          }  
            if (result.resultCode == 200) {
                alert("SUCCESS");
            };
        },
        error : function(error) {
            alert("异常！"+error);                 
        }
    });
}
