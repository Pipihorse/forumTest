<%@ page import="pipihorse.Pojo.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/titlebar.css" rel="stylesheet">

    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#a1").click(function () {
                $.ajax({
                    type:"GET",
                    url:"/plate",
                    success:function (date) {
                        var content="";
                        var list=JSON.parse(date)
                                for(var i=0;i<list.length;i++) {
                                    content+="  <li><a href='/forum?forum="+list[i].id+"&&currentPage=1'>" + list[i].title + "</a></li>\n"
                                }
                            $("#u1").html(content)
                    },
                    error:function () {
                        alert("未知错误！！！")
                    }
                })
            })
        })
    </script>
</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">BBS技术论坛</a>
    </div>

    <div>
        <ul class="nav navbar-nav">
            <li><a href="/index.jsp">首页</a></li>
            <li class="dropdown">
                <a id="a1" href="#" class="dropdown-toggle" data-toggle="dropdown">
                    精选板块 <b class="caret"></b>
                </a>
                <ul id="u1" class="dropdown-menu"></ul>

            </li>
            <li><a href="/more?type=2&&currentPage=1">论坛热帖</a></li>
            <li><a href="/more?currentPage=1&&type=1">论坛新帖</a></li>
            <li><a href="/more.action?type=-2&&page=1">精华帖</a></li>
        </ul>
    </div>
    <% User user = (User) session.getAttribute("user");
        if (user == null) {
    %>
    <ul class="nav navbar-nav navbar-right user">
        <li><a href="<%=request.getContextPath()%>/login.jsp">登陆</a></li>
        <li><a href="<%=request.getContextPath()%>/regist.jsp">注册</a></li>
    </ul>
    <p class="navbar-text navbar-right">尊敬的游客您好！</p>
    <%
    } else if (user != null && user.getHasActive()==0) {
    %>
    <ul class="nav navbar-nav navbar-right user">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <%=user.getUsername()%> <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
                <li><a href="/pages/change-info.jsp">设置</a></li>
                <li><a href="/pages/mypost.jsp?page=1">我的帖子</a></li>
                <li><a href="/publish_post.jsp">我要发帖</a></li>
                <li class="divider"></li>
                <li><a href="/logout">退出登陆</a></li>
            </ul>
        </li>
    </ul>
    <img class="navbar-nav navbar-right" src="/imgTest/<%=user.getImage()%>" width="40px" height="40px">
    <%
    } else if (user!=null && user.getHasActive()==1){
    %>
    <ul class="nav navbar-nav navbar-right user">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <%=user.getUsername()%> <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
                <li><a href="/pages/notice.jsp">发布公告</a></li>
                <li><a href="">精华帖请求</a></li>
                <li><a href="">创建板块</a></li>
                <li class="divider"></li>
                <li><a href="/logout">退出登陆</a></li>
            </ul>
        </li>
    </ul>
    <p class="navbar-text navbar-right">尊敬的管理员您好！</p>
    <%} %>
</nav>

</body>
</html>
