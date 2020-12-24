<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="pipihorse.Pojo.User" %>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'change-info.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<jsp:include page="/pages/header.jsp"/>

<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-xs-3">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation" class="active"><a href="/pages/change-info.jsp">资料修改</a></li>
                <li role="presentation"><a href="/pages/mypost.jsp?page=1">我的帖子</a></li>
                <li role="presentation"><a href="/pages/records.jsp">申请记录</a></li>
            </ul>

        </div>

        <div class="col-xs-9">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        个人信息修改
                    </h3>
                </div>
                <div class="panel-body">
                    <%
                        User user = (User) request.getSession().getAttribute("user");
                    %>
<%--                    <form id="form01" enctype="multipart/form-data">--%>
<%--                        <div class="form-group">--%>
<%--                            <img alt="@zhangjianhao" class="avatar left" height="70" src="/imgTest/<%=user.getImage()%>" width="70"/>--%>
<%--                            请上传你的头像<br/>--%>
<%--                        </div>--%>
<%--                        <input type="file" id="inputfile" accept="image/*" name="photoImg"><br/>--%>
<%--                    </form>--%>
                    <form id="form1" action="" enctype="multipart/form-data">
                        <input  name="d1" type="text" value="<%=user.getId()%>" style="display: none"  >
                        <div class="form-group">
                            <img alt="@zhangjianhao" class="avatar left" height="70" src="/imgTest/<%=user.getImage()%>" width="70"/>
                            请上传你的头像<br/>
                        </div>
                        <input type="file" id="inputfile" accept="image/*" name="photoImg"><br/>
                        <div class="form-group">
                            <label for="name">用户名</label>
                            <input id="username" type="text" class="form-control" name="username" id="name"
                                   width="200px" height="80px"
                                   placeholder="请输入名称">
                            <p id="Ufont"></p>
                        </div>

                        <div class="form-group">
                            <label for="name">性 别</label><br/>
                            <%if (user.getSex().equals("男")) {%>
                            男<input type="radio" name="sex" value="男" checked="checked">
                            &nbsp &nbsp女<input type="radio" name="sex" value="女">
                            <%} else if (user.getSex().equals("女")) {%>
                            男<input type="radio" name="sex" value="男">
                            &nbsp &nbsp女<input type="radio" name="sex" value="女" checked="checked">
                            <%} %>
                        </div>


                        <dl class="form-group">
                            <dt><label for="user_profile_blog">邮箱</label></dt>
                            <dd><input id="email" type="email" class="form-control" id="user_profile_blog" name="email"
                                       size="30"/>
                                <p class="help-block"></p>
                            </dd>
                        </dl>
                        <dl class="form-group">
                            <dt><label>密码</label></dt>
                            <dd><input class="form-control" id="password" name="password" size="30" type="password"
                                       width="200px"/></dd>
                        </dl>
                        <dl class="form-group">
                            <dt><label>确认密码</label></dt>
                            <dd><input class="form-control" id="confirm_password" name="confirm_password" size="30"
                                       type="password" width="200px"/></dd>
                        </dl>
                        <input id="submit" type="button" value="提交">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>

<jsp:include page="/pages/bottom.jsp"/>
</body>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        // 用户名检查
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
        //修改提交
        $("#submit").click(function () {
            var form=new FormData($("#form1")[0])
            $.ajax({
                type: "post",
                url:"/update",
                processData:false,
                contentType:false,
                data: form,
                success:function (data) {
                    if (data=="true"){
                        alert("修改成功！！")
                        window.location.href="/index.jsp"
                    }else {
                        alert("修改失败！!")
                    }
                },
                error:function () {
                    alert("未知错误！！")
                }
            })
        })
    })

</script>
<style type="text/css">
    .error {
        color: red;
    }
</style>
</html>
