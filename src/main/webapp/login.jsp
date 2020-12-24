<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'loginjsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	    <link href="css/login.css" rel="stylesheet">

  </head>
  
  <body>
   
<%--  <jsp:include page="/pages/header.jsp"/>--%>
 <div class="login">

    <form id="form1" role="form" action="/login" method="post">
            <!--<label for="name">用户名:</label>-->
            <input id="username" required type="text" class="form-control" name="username" style="height: 55px; margin-top: 30px;"
                   placeholder="请输入用户名" value="admin">
            <!--<label for="name"></label>-->
            <input id="password" type="password" required class="form-control" name="password" style="height: 55px;margin-top: 30px;"
                   placeholder="请输入密码" value="123456">
        <div style="height: 100px;width: 100%;margin-top: 30px;">
            <div style="float:left;width: 50%;padding: 20px;">
                <input id="b1" type="button" class="btn btn-primary" value="登陆"
                   style="margin:auto;width: 80%;height: 50px;padding: 13px;"></input>
            </div>
            <div style="float:right;width: 50%;padding: 20px;">
                <a href="regist.jsp" type="button" class="btn btn-primary"
                   style="margin:auto;width: 80%;height: 50px;padding: 13px;">注册</a>
            </div>
        </div>
    </form>
</div>

<div class="bottom" style="position:absolute;bottom:0px;margin-top: 20px;background-color: rgba(0,0,0,0.8);width:100%;height: 100px;color: darkgray">
    <div align="center"><p style="font-size: 20px" >皮皮马</p></div>
</div>
  </body>
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript">
      $(document).ready(function () {
          $("#b1").click(function () {
              $.ajax({
                  type : "post",
                  data:{
                      username:$("#username").val(),
                      password:$("#password").val()
                  },
                  url:"/login",
                  success:function (data) {
                      if (data=="true"){
                          window.location.href=("/index.jsp")
                      }else {
                          alert("用户名或密码错误！！！")
                      }
                  },
                  error:function () {
                      alert("未知错误！！！")
                  }

              })
          })


      })
  </script>
</html>
