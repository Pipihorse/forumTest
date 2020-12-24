<%@ page import="pipihorse.Pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-12-21
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    User user= (User) request.getSession().getAttribute("user");
%>
<head>
    <title>Title</title>
    <style type="text/css">
        .tb {
            margin: 0 auto;
        }


        .tb tr th, .tb tr td {
            BORDER-left: #c2daf2 1px solid;
            BORDER-top: #c2daf2 1px solid;
            font-weight: normal;
            color: #000;
            background-repeat: repeat-x;
            FONT-SIZE: 9pt;
            FONT-FAMILY: Arial, "宋体";
            padding: 10px;
        }

        .tb tr th {
            width: 180px;
            background-color: #eff5fb;
        }

        .tb tr td {
            width: 800px;
            background-color: #f5f5f5;
        }

        .tb tr input {
            width: 500px;
        }

        .tb tr span {
            color: red;
        }

        .tab {
            width: 80px;
            border: 1px solid #ddddde;
            height: 27px;
            background: -webkit-linear-gradient(#e3e3e3, #fff); /* Safari 5.1 - 6.0 */
            background: -o-linear-gradient(#e3e3e3, #fff); /* Opera 11.1 - 12.0 */
            background: -moz-linear-gradient(#e3e3e3, #fff); /* Firefox 3.6 - 15 */
            background: linear-gradient(#e3e3e3, #fff); /* 标准的语法 */
            text-align: center;
            line-height: 27px;

        }

        .tab:hover, .omg {
            background: #f5f5f5;
            border-bottom: 1px solid #fff;
        }

        #small_btn_select {
            width: 120px;

        }

        #big_btn_select {
            width: 270px;
        }

        .btn-select {
            position: relative;
            display: inline-block;

            height: 35px;

            font: 14px/20px "Microsoft YaHei";
            color: #fff;
        }

        .btn-select .cur-select {
            position: absolute;
            display: block;
            width: 100%;
            height: 30px;

            text-align: center;

        }


        .btn-select select {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 30px;
            opacity: 0;
            filter: alpha(opacity:0;
        );
            font: 14px/20px "Microsoft YaHei";
            color: #000;
        }

        .btn-select select option {
            text-indent: 10px;
        }

        .btn-select select option:hover {
            background-color: #f80;
            color: #fff;
        }
    </style>
    <script type="text/javascript" src="component/ckeditor/ckeditor.js"></script>
    <script type="text/javascript" src="js/publish-post.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#submit").click(function () {
                $.ajax({
                    type:"post",
                    url:"",
                    date:{
                        "title":$("#title").val(),
                        "content":$(#content).val(),
                        "userId":<%=user.getId()%>
                    },
                    success:function (date) {
                        if(date=="true"){
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
        })
    </script>
</head>
<jsp:include page="/pages/header.jsp"/>
<body>
<table class="tb" cellspacing="0" cellpadding="3">
    <form id="form1" enctype="multipart/form-data">
        <tr>
            <th>标题</th>
            <td>
                <input required type="text" id="title" name="title" style="height: 30px;width: 500px"/>
            </td>
        </tr>
        <tr>
            <th>公告内容内容</th>
            <td>
                <textarea type="text" class="" name="content" id="content" style="width: 825px;height: 357px"></textarea>
            </td>
        </tr>
        <tr>
            <th></th>
            <td align="center">
                <input id="submit" type="button" value="发布"/>
            </td>
        </tr>
    </form>

</table>

</body>
</html>
