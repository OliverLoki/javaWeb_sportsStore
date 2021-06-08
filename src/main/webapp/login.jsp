<%@ page import="smbms.tools.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>运动产品订购系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
</head>
<body class="login_bg">
    <section class="loginBox">
        <header class="loginHeader">
            <h1>运动产品订购系统</h1>
        </header>
        <section class="loginCont">
	        <form class="loginForm" action="${pageContext.request.contextPath }/login.do"  name="actionForm" id="actionForm"  method="post" >
				<div class="info">
<%-- 这里只能用键值对的键进行查询   --%>
                 ${error}
                </div>
				<div class="inputbox">
                    <label for="userCode">用户名：</label>
					<input type="text" class="input-text" id="userCode" name="username" placeholder="请输入用户名" required/>
				</div>	
				<div class="inputbox">
                    <label for="userPassword">密码：</label>
                    <input type="password" id="userPassword" name="userpassword" placeholder="请输入密码" required/>
                </div>	
				<div class="subBtn">
                    <input type="submit" value="登录"/>
                    <a href="/register.jsp">注册</a>
                </div>	
			</form>

        </section>
    </section>
</body>
</html>
