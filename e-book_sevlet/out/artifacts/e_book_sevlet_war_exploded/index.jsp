<%--
  Created by IntelliJ IDEA.
  User: 14254
  Date: 2019/4/7
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Book Store</title>
    <link href="resources/css/style2.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="templatemo_container">
    <div id="templatemo_menu">
        <ul>
            <li><a href="ebook" >书籍浏览</a></li>
            <li><a href="#">购物车</a></li>
            <li><a href="#" class="current">登录</a></li>
            <li><a href="#">注册</a></li>
            <li><a href="#">管理</a></li>
        </ul>
    </div> <!-- end of menu -->

    <article>
        <section class="sign">
            <aside>
                <em>
                    <img src="resources/images/user.png">
                </em>
                <form action="" method="post">
                    <p class="name"><i></i><input type="text" id="userName" class="userName" placeholder="请输入用户名"></p>
                    <p class="password"><i></i><input type="password" id="password" class="pwd" placeholder="请输入密码"></p>
                    <button>登录</button>
                    <p class="regist"><span>没有账号?</span><a href="#">立即注册</a></p>
                    <div class="clear"></div>
                </form>
            </aside>
        </section>
    </article>
    <div class="cleaner_with_height">&nbsp;</div>
</div> <!-- end of container -->
</body>
</html>
