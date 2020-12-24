<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="zh" class="no-js">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<title>论坛</title>
<link rel="stylesheet" type="text/css" href="/css/zzsc-demo.css">
    <link href="/css/index.css" rel="stylesheet">
</head>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function () {
		$.ajax({
			type:"GET",
            data:{
			    "currentPage":1
            },
			url:"/newPost",
			success:function (data) {
				var context="";
				var list=JSON.parse(data)
				for(var i=0;i<list.length;i++){
				context+="<a href='/lookpost?id="+list[i].id+"' class='list-group-item'>"+
							"<h4 class='list-group-item-heading'>"+list[i].title+"</h4>"+
                    list[i].content+"<span class='badge'>新</span>"+
							"<p class='text-right' style='float: right;margin-right: 20px'>浏览量:"+list[i].viewNum+"&nbsp;评论量:"+list[i].replyNum+"&nbsp;发表日期:"+list[i].sendDate+"</p> </a>"
				}
				$("#newpost").html(context)
			},
			error:function () {
			    alert("未知错误！！")
			}
		})
	})
</script>
<body>
 <jsp:include page="/pages/header.jsp"/>
<div style="width: 100%;">

		 <div class="container user-info">
    <div class="row">
        <div class="col-xs-12">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="img/2.jpg" alt="...">
                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div class="item">
                        <img src="img/1.jpg" alt="...">
                        <div class="carousel-caption">
                        </div>
                    </div>

                    <div class="item">
                        <img src="img/2.jpg" alt="...">
                        <div class="carousel-caption">
                        </div>
                    </div>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>

<div class="container" style="margin-top: 30px;">
    <div class="row">
        <div class="col-md-9">

            <ul class="list-group">
                <div class="list-group-item active">
                    最新发布
                    <a href="/more?type=1&&currentPage=1" style="float: right;color: white">更多>></a>
                </div>
				<a id="newpost"></a>
            </ul>

        </div>

        <div class="col-md-3">
            <ul class="list-group">
                <div class="list-group-item active">
                    论坛公告
                </div>
                <div class="list-group-item">
                    <h4>元旦放假通知</h4>
                    <p>嘿嘿嘿</p>
                </div>

<%--                         <a href="<%=request.getContextPath()%>/pages/notice.jsp?noticeId=" class="list-group-item">title</a>--%>
            </ul>
<%--               <a href="<%=request.getContextPath()%>/publish_post.jsp" ><button type="button" class="btn btn-primary" style="width: 200px;height:50px;margin-left: 30px">我要发帖</button></a>--%>
        </div>

<%--        <div class="row">--%>
<%--            <div class="col-md-9" style="margin-left: 15px">--%>
<%--                <ul class="list-group">--%>
<%--                    <div class="list-group-item active">--%>
<%--                        精华帖--%>
<%--                        <a href="/more?type=-2&&currentPage=1" style="float: right;color: white">更多>></a>--%>
<%--                    </div>--%>
<%--&lt;%&ndash;                     &lt;%&ndash;%>--%>
<%--&lt;%&ndash;				   &ndash;%&gt;--%>
<%--&lt;%&ndash;				  	List<Post> posts = postBiz.getBestPosts(1,6);&ndash;%&gt;--%>
<%--&lt;%&ndash;				  	for (Post post:posts){&ndash;%&gt;--%>
<%--&lt;%&ndash;				   %>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <a href="<%=request.getContextPath()%>/pages/post.jsp?postId=<%=post.getId()%>&&page=1" class="list-group-item">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <h4 class="list-group-item-heading">[<%=post.getSubForum().getMainForum().getTitle()%>]</h4>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <%=post.getTitle() %><span class="badge">热</span>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <p class="text-right" style="float: right;margin-right: 20px">浏览量:<%=post.getViewNum()%>&nbsp;评论量:<%=post.getReplyNum()%>&nbsp;发表日期:<%=post.getTime()%></p>&ndash;%&gt;--%>
<%--                    </a>--%>
<%--                    --%>
<%--&lt;%&ndash;                     <%} %>&ndash;%&gt;--%>
<%--                </ul>--%>
<%--            </div>--%>

<%--            --%>
<%--    </div>--%>
    </div>
   </div></div></div></div>
</body>
</html>