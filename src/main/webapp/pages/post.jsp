
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" autoFlush="false" buffer="1000kb"%>
<%@ page import="pipihorse.Pojo.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>帖子浏览</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
     <link href="css/post-detail.css" rel="stylesheet">
     <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
  </head>
  <%
      User user= (User) request.getSession().getAttribute("user");
  %>
  <body>
<div style="height:100%">
   <jsp:include page="/pages/header.jsp"/>
  	 <div class="container" style="margin-top: 50px">
    <div class="row">
       <div class="col-md-1 post-border">
       </div>
        <div class="col-md-2 post-head">
                <!--<img src="img/tm-bg-slide-1.jpg" width="80px" height="80px" class="img-responsive img-circle">-->
            <img  alt="" class="img-responsive img-circle" src="/imgTest/${user1.image}"
                  style="margin:1px 1px;width: 120px;height: 120px;margin: 30px auto;"/>
                <span class="user-info">
                            <span class="badge" style="background: #f1c40f;margin-top: 5px">发帖者</span>
                            :<span class="badge" style="background: #f1c40f;margin-top: 5px">${user1.username}</span>
                        </span><br/>
                        <span class="user-info">
                            <span class="badge" style="background: #2ecc71;margin-top: 5px">性别</span>
                            :<span class="badge" style="background: #2ecc71;margin-top: 5px">${user1.sex}</span>
                        </span><br/>
            <br>
        </div>
        <div class="col-md-8 post-content">
            <div class="post-title">
                <h2 style="margin-left:20px;color:black"></h2>
                <div style="margin-left:20px" >
                    <span class="glyphicon glyphicon-comment">${post.title}</span>&nbsp;&nbsp;&nbsp;|&nbsp;<span>发表于:${post.sendDate}</span>
					<a style="float:right;margin-right: 20px;" href="/editpost.action?postId=">编辑</a>
                </div>
                <strong style=" float:right;margin-right:10px;margin-top: 10px">
                    <span class="badge" style="background: #ff6927;width: 50px;">楼主</span></strong>
            </div>
            <img src="/imgTest/${post.image}" style="width: 150px;height: 150px;" onerror="this.style.display='none'">
            <div style="margin: 20px">
                ${post.content}
                <div style="bottom: 0;right: 0;position: absolute;">
                        <img src="/imgTest/v7.png" style="width: 40px;height: 40px" >
                    <div>${post.replyNum}</div>
                </div>
                <div style="bottom: 0;right:50px;position: absolute;">
                    <input id="d1" type="image" src="/imgTest/v4.gif" style="width: 40px;height: 40px">

                    <div>${post.tread}</div>
                </div>
                <div style="bottom: 0;right:100px;position: absolute; ">

                    <input id="d2" type="image" src="/imgTest/v5.gif" style="width: 40px;height: 40px">

                    <div>${post.praise}</div>
                </div>
            </div>
            <script type="text/javascript" src="/js/jquery.min.js"></script>
            <script type="text/javascript">
                $(document).ready(function () {
                    <% if (user==null){%>
                    $("#d1").click(function () {
                        alert("请先登录！！")
                        window.location.href="/login.jsp"
                    })
                    $("#d2").click(function () {
                        alert("请先登录！！")
                        window.location.href="/login.jsp"
                    })
                    $("#button").click(function () {
                        alert("请先登录！！！")
                        window.location.href="/login.jsp"
                    })
                    <%}else if (user!=null){%>
                    $("#d1").click(function () {
                        $.ajax({
                            type:"get",
                            url:"/zc",
                            data:{
                                "num":2,
                                "userId":<%=user.getId()%>,
                                "postId":${post.id}
                            },
                            success:function (data) {
                                if (data=="true"){
                                    location.reload()
                                }
                            },
                            error:function () {
                                alert("未知错误")
                            }
                        })
                    })
                    $("#d2").click(function () {
                        $.ajax({
                            type:"get",
                            url:"/zc",
                            data:{
                                "num":1,
                                "userId":<%=user.getId()%>,
                                "postId":${post.id}
                            },
                            success:function (data) {
                                if (data=="true"){
                                    alert("成功")
                                    location.reload()
                                }else {
                                    alert("失败")
                                }
                            },
                            error:function () {
                                alert("未知错误")
                            }
                        })
                    })
                    $("#button").click(function () {
                        $.ajax({
                            type:"post",
                            url:"/replyInfo",
                            data:{
                                "userId":<%=user.getId()%>,
                                "content":$("#TextArea1").val(),
                                "postId":${post.id}
                            },
                            success:function (data) {
                                if (data==="true"){
                                    location.reload()
                                    alert("成功！！")
                                }else {
                                    alert("失败！！")
                                }
                            },
                            error:function () {
                                alert("未知错误！！")
                            }

                        })
                    })
                    <%}%>
                })

            </script>
        </div>
         <div class="col-md-1 post-border">
       </div>
    </div>
    </div>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript">
        var content="";
        $(document).ready(function () {
            var user=new Array();
            var reply=new Array();
            $.ajax({
                type:"GET",
                url:"/reply",
                async:false,
                data:{
                    "sendId":${post.id},
                },
                success:function (data) {
                    var list=JSON.parse(data)
                    for (var i=0;i<list.length;i++){
                        $.ajax({
                            type: "GET",
                            url:"/userById",
                            async:false,
                            data:{
                                "userId":list[i].userId
                            },
                            success:function (data) {
                                var d=JSON.parse(data)
                                user=user.concat(d)
                            },
                            error:function () {
                                alert("请求失败!!!")
                            }
                        })
                        reply.push(list[i])

                    }
                },
                error:function () {
                    alert("未知错误！！！")
                }
            })
            for (var i=0;i<user.length;i++){
                content +=
                    "<div class='container'>\n" +
                    "    <div class='row' style='margin-top: 5px'>\n" +
                    "        <div class='col-md-1 reply-border'>\n" +
                    "\n" +
                    "        </div>\n" +
                    "        <div class='col-md-2 reply-head'>\n" +
                    "            <img  class='img-responsive img-circle' src='/imgTest/"+user[i].image+"'\n" +
                    "                  style='margin:1px 1px;width: 120px;height: 120px;margin: 30px auto;'/>\n" +
                    "\n" +
                    "            <span class='user-info'>\n" +
                    "                        <span class=\"badge\" style=\"background: #f1c40f;margin-top: 5px\">姓名</span>\n" +
                    "                        :<span class=\"badge\" style=\"background: #f1c40f;margin-top: 5px\">"+user[i].username+"</span>\n" +
                    "                    </span><br/>\n" +
                    "                    <span class=\"user-info\">\n" +
                    "                        <span class=\"badge\" style=\"background: #2ecc71;margin-top: 5px\">性别</span>\n" +
                    "                        :<span class=\"badge\" style=\"background: #2ecc71;margin-top: 5px\">"+user[i].sex+"</span>\n" +
                    "                    </span><br/>\n" +
                    "            <br>\n" +
                    "        </div>\n" +
                    "        <div class=\"col-md-8 reply-content\">\n" +
                    "\n" +
                    "            <div class=\"reply-time\">\n" +
                    "                <span style=\"color: gray\">回复于:"+reply[i].replyDate+"</span>\n" +
                    "            </div>\n" +
                    "            <div style=\"margin: 20px;\">"+reply[i].replyContent+" </div>\n" +
                    "        </div>\n" +
                    "        <div class=\"col-md-1 reply-border\">\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "     </div>"
            }
            console.log(user)
            console.log(reply)
            $("#content").html(content)

        })
    </script>
    <!-- 回复内容 -->
    <div id="content">
    </div>
  	
  	<div style="height: 200px;margin: 70px auto; width: 800px;">
  	<form action="/reply.action" method="post">
  	<input type="hidden" name="postId" value="">
  	<input type="hidden" name="page" value="">
        <div style="margin: 5px auto;height: 100px; width: 800px">
            <textarea id="TextArea1" cols="20" rows="1" name="content" class="ckeditor" style="width: 870px;height: 140px"></textarea>
        </div>
    <div style="float:right;margin: 60px auto">
        <input id="button" type="button" class="btn btn-primary" style="width: 60px;" value="回复"></input>
    </div>
</form>
</div>
</div>
  </body>
</html>
