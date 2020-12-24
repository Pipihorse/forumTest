<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="pipihorse.Pojo.User" %>
<jsp:include page="/pages/header.jsp"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
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
            //所属板块
                $.ajax({
                    type:"GET",
                    url:"/plate",
                    success:function (date) {
                        var list=JSON.parse(date)
                        var content="";
                        for(var i=0;i<list.length;i++) {
                                content+="<option  style='font-size: 15px' value="+list[i].id+">"+list[i].title+ "</option>\n"
                        }
                        $("#mainforum").html(content)
                        },
                    error:function () {
                        alert("未知错误！！！")
                    }
                })
            //帖子提交
            $("#submit").click(function () {
                var form=new FormData($("#form1")[0]);
                $.ajax({
                    type: "post",
                    processData:false,
                    contentType:false,
                    data:form,
                    url:"/post",
                    success:function () {
                        alert("添加成功！！")
                        window.location.href="/index.jsp"
                    },
                    error:function () {
                        alert("失败！！")
                    }

                })
            })
        })
    </script>
</head>
<%
    User user= (User) request.getSession().getAttribute("user");
%>
<body>
<table class="tb" cellspacing="0" cellpadding="3">
        <form id="form1" enctype="multipart/form-data">
            <input name="userId" type="text" value="<%=user.getId()%>" style="display: none">
            <tr>
                <th>文章标题</th>
                <td>
                    <input required type="text" id="ititle" name="title" style="height: 30px;width: 500px"/>
                    <span>你还可以输入30个字符</span>
                </td>
            </tr>
            <tr>
                <th>文章内容</th>
                <td>
                    <textarea type="text" class="" name="content" id="icontent" style="width: 825px;height: 357px"></textarea>
                    <span style="float: right;">你还可以输入30000个字符</span>
                </td>
            </tr>
            <tr>
                <th>选择版块</th>
                <td>
                    <div id="change" style="float:left">
                        <select id="mainforum" name="mainForum"  style="width: 250px;height: 30px">

                        </select>
                    </div>
                        <span style="float:right;line-height:35px;">请选择所要发帖的版块</span>
                </td>
            </tr>
            <tr>
                <th>图片</th>
                <td>
                    <input type="file" name="image" value="选择图片"/>
                </td>
            </tr>
            <tr>
                <th></th>
                <td align="center">
                    <input id="submit" type="button" value="提交"/>
                </td>
            </tr>
        </form>

</table>
<script type="text/javascript">
    CKEDITOR.replace('ckeditor', {allowedContent: true});

</script>


</body>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#signupForm").validate();
    });
</script>
</html>