<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>	
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>运动产品订购系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css" />
    <link rel="stylesheet"rel="stylesheet" href="${pageContext.request.contextPath }/css/cube.css">
</head>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>运动产品订购系统</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b"> ${userSession.uname}</span> , 欢迎你！</p>
            <a href="${pageContext.request.contextPath }/jsp/logout.do">退出</a>
        </div>
    </header>
 <!--主体内容-->
 <section class="publicMian">
     <div class="left">
         <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
         <nav>
             <ul class="list">
                 <li ><a href="${pageContext.request.contextPath }/jsp/goodsshow.do">商品展示</a></li>
              <li><a href="${pageContext.request.contextPath }/jsp/cartshow.do?uid=${userSession.uid}">购物车结算</a></li>
              <li><a href="${pageContext.request.contextPath }/jsp/usershow.do">所有用户信息</a></li>
              <li><a href="${pageContext.request.contextPath }/jsp/pwdmodify.jsp">用户信息修改</a></li>
              <li><a href="${pageContext.request.contextPath }/jsp/logout.do">退出系统</a></li>
             </ul>
         </nav>
     </div>
     <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
     <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>