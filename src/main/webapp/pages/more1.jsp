<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="pipihorse.util.Page" %>
<%@ page import="pipihorse.Pojo.Post" %>
<html>
  <head>
    <title>更多帖子</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link href="css/titlebar.css" rel="stylesheet">
    <link href="css/search-result.css" rel="stylesheet"/>
  </head>
  <style type="text/css">
      .page{
          text-align: center;
      }

      .page a,span{
          text-decoration: none;
          border: solid 1px #000000;
          padding: 5px 7px;
          color:  #767675;
          cursor: pointer;
      }
      .page a:hover,.page span:hover{
          background-color: #74777b;
      }
  </style>
  <script type="text/javascript" src="/js/jquery.min.js"></script>
  <body>
   <jsp:include page="/pages/header.jsp"/>
<%--            <!-- 帖子列表 -->--%>
<%--   <%--%>
<%--       Page pages= (Page) request.getAttribute("pages");--%>
<%--       for (Post p:pages.getPostList()) {--%>
<%--           p.getTitle();--%>
<%--           p.getContent();--%>

<%--   %>--%>
<%--   <div class="list-group search-list" href="/lookpost?id=<%=p.getId()%>">--%>
<%--    <a href="/lookpost?id=<%=p.getId()%>" class="list-group-item active">--%>
<%--        <%=p.getTitle()%>--%>
<%--     </a>--%>
<%--    <a href="" class="list-group-item">--%>
<%--            <h4 class="list-group-item-heading">--%>
<%--                <%=p.getContent()%>--%>
<%--            </h4>--%>
<%--            <p class="text-right post-date">浏览量:&nbsp;<%=p.getViewNum()%>评论量:&nbsp;<%=p.getReplyNum()%>发表日期:<%=p.getSendDate()%></p>--%>

<%--    </a>--%>
<%--</div>--%>
<%--   <% }%>--%>
<%--   分页--%>
   <div id="paging" class="page" align="center">
<%--       <c:if test="${requestScope.pages.endPageIndex>1}">--%>
<%--       <C:if test="${requestScope.pages.currentPage>1}">--%>
<%--       <a href="/more?currentPage=${requestScope.pages.currentPage-1}&&type=${requestScope.type}">上一页</a>--%>
<%--       </C:if>--%>
<%--       <C:if test="${requestScope.pages.currentPage ==1}" >--%>
<%--           <a style="display: none">上一页</a>--%>
<%--       </C:if>--%>
<%--       <c:forEach var="pageIndex" begin="${requestScope.pages.beginPageIndex}" end="${requestScope.pages.endPageIndex}">--%>
<%--           <c:if test="${requestScope.pages.currentPage==pageIndex}">--%>
<%--           <a href="/more?currentPage=${pageIndex}&&type=${requestScope.type}" style="background-color: #74777b;">${pageIndex}</a>--%>
<%--           </c:if>--%>
<%--           <c:if test="${requestScope.pages.currentPage!=pageIndex}">--%>
<%--           <a href="/more?currentPage=${pageIndex}&&type=${requestScope.type}">${pageIndex}</a>--%>
<%--           </c:if>--%>
<%--       </c:forEach>--%>
<%--       <C:if test="${requestScope.pages.currentPage < requestScope.pages.endPageIndex}">--%>
<%--           <a href="/more?currentPage=${requestScope.pages.currentPage+1}&&type=${requestScope.type}">下一页</a>--%>
<%--       </C:if>--%>
<%--       <C:if test="${requestScope.pages.currentPage ==requestScope.pages.endPageIndex}" >--%>
<%--           <a style="display: none">下一页</a>--%>
<%--       </C:if>--%>
<%--       </c:if>--%>
   </div>
   <script type="text/javascript" >
       var context="";
       $(document).ready(function () {
           alert(${requestScope.pages.endPageIndex})
           $.ajax({
               type:"get",
               url:"/more1",
               async:false,
               data: {
                   "currentPage":1
               },
               success:function (date) {
                   alert(date)
                   if (date=="true"){

                       alert(${requestScope.pages.endPageIndex})
                       <c:if test="${requestScope.pages.endPageIndex>1}">

                       <C:if test="${requestScope.pages.currentPage>1}">
                       context += "<a href="/more?currentPage=${requestScope.pages.currentPage-1}&&type=${requestScope.type}">上一页</a>\n"
                       </C:if>
                       <C:if test="${requestScope.pages.currentPage ==1}" >
                       context +="<a style=\"display: none\">上一页</a>\n"
                       </C:if>
                       <c:forEach var="pageIndex" begin="${requestScope.pages.beginPageIndex}" end="${requestScope.pages.endPageIndex}">
                       <c:if test="${requestScope.pages.currentPage==pageIndex}">
                       context +="<a href=\"/more?currentPage=${pageIndex}&&type=${requestScope.type}\" style=\"background-color: #74777b;\">${pageIndex}</a>"
                       </c:if>
                       <c:if test="${requestScope.pages.currentPage!=pageIndex}">
                       context += "<a href=\"/more?currentPage=${pageIndex}&&type=${requestScope.type}\">${pageIndex}</a>\n"
                       </c:if>
                       </c:forEach>
                       <C:if test="${requestScope.pages.currentPage < requestScope.pages.endPageIndex}">
                       context += "<a href=\"/more?currentPage=${requestScope.pages.currentPage+1}&&type=${requestScope.type}\">下一页</a>"
                       </C:if>
                       <C:if test="${requestScope.pages.currentPage ==requestScope.pages.endPageIndex}" >
                       context += "<a style=\"display: none\">下一页</a>"
                       </C:if>
                       </c:if>
                       alert(context)
                       console.log(context)

                   }

               },
               error:function () {

               }
           })
       })
       $("#paging").html(context)
   </script>

   <%--<ul id="u1" class="pagination pagination-lg page-float">--%>
   <%--    <li><a href="/pages/more.jsp">&laquo;</a></li>--%>

<%--    <li class="active"><a href="">i</a></li>--%>
    <%--    <li><a href="">1</a></li>--%>

    <%--     <li class=""><a href="">11</a></li>--%>
<%--      <li><a href="/more.action?type=">&raquo;</a></li>--%>
</ul>
   <br>
  </body>
</html>
