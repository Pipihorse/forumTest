<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'registjsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	    <link href="css/regist.css" rel="stylesheet">
  </head>
  <body>
 <div class="regist">
    <form id="form1"  action="/register" >
        <table >
            <tr>
                <td align="right">用户名：</td>
                <td>
                    <input id="username" type="text" class="form-control" name="username" style="height: 40px; margin-top: 20px;" placeholder="请输入用户名">
                </td>
                <td><font id="Ufont" ></font></td>
            </tr>

            <tr>
                <td align="right" width="80px">密码：</td>
                <td> <input id="password" type="password" class="form-control" name="password" style="height: 40px;margin-top: 20px;" placeholder="请输入密码"></td>
            </tr>
            <tr>
                <td align="right">确认密码：</td>
                <td> <input id="confirm_password" type="password" class="form-control" name="password" style="height: 40px;margin-top: 20px;" placeholder="请重复密码"></td>
            </tr>
            <tr>
                <td align="right">性别：</td>
                <td>
                            男<input type="radio" name="sex" value="男">
                    &nbsp&nbsp&nbsp&nbsp
                            女<input type="radio" name="sex" value="女">
                </td>
            </tr>
            <tr>
                <td align="right">邮箱：</td>
                <td>
                    <input id="Email" type="email" class="form-control" name="email" style="height: 40px;margin-top: 20px;"
                           placeholder="请输入邮箱">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div style="height: 80px;width: 100%;margin-top: 20px;margin-left: 30px;">
                        <!--<div style="float:left;width: 100%;padding: 20px;">-->
                        <input id="submit" type="button" class="btn btn-primary" value="注册"
                               style="margin:auto;width: 100%;height: 40px;padding: 10px;"></input>
                        <!--</div>-->
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>
 
  <div class="bottom" style="position:absolute;bottom:0px;margin-top: 20px;background-color: rgba(0,0,0,0.8);width:100%;height: 100px;color: darkgray">
      <div align="center"><p style="font-size: 20px" >皮皮马</p></div>
  </div>
  </body>
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript">
  	$(document).ready(function () {
  	    $("#submit").click(function () {
  	        if($("username").val()==''){
  	            alert("用户名不能为空")
            }else  if ($("#password").val()==''){
                alert("密码不能为空")
            }else if($("#password").val()!==$("#confirm_password").val()){
  	            alert("两次密码不一致")
            }else {
                $.ajax({
                    type:"post",
                    url:"/register",
                    data:{
                        "username":$("#username").val(),
                        "password":$("#password").val(),
                        "sex":$("input[type=radio][name=sex]:checked").val(),
                        "Email":$("#Email").val(),
                    },
                    success:function (data) {
                        if (data==="true"){
                            window.location.href="/login.jsp"
                        }else {
                            alert("注册失败！！！")
                        }
                    },
                    error:function () {
                        alert("未知错误！！！")
                    }
                })
            }

        })
        //用户名验证
        $("#username").blur(function () {
            $.ajax({
                type: "post",
                url:"/username",
                data: {
                    "username":$("#username").val()
                },
                success:function (data) {
                    if (data=="true"){
                         $("#Ufont").html("<font style='color: #3c763d'>用户名可用<font>")
                        $("#submit").attr("disabled",false)
                    }else if (data=='false'){
                        $("#Ufont").html("<font style='color: #c7254e'>用户名重复<font>")
                        $("#submit").attr("disabled",true)
                    }
                },
                error:function () {
                    alert("未知错误！！！")
                }
            })
        })
        //密码验证
    })
  </script>
  <style type="text/css">
  .error{
    color:red;
  }
  </style>
</html>
