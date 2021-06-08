<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>用户信息界面</span>
    </div>
    <div class="showAllUsers">
        <table>
            <tr>
                <th>用户id</th>
                <th>登录账号</th>
                <th>登录密码</th>
                <th>用户姓名</th>
            </tr>
            <c:forEach var="user" items="${allUserMessage}">
                <tr>
                    <td>${user.uid}</td>
                    <td>${user.username}</td>
                    <td>${user.pwd}</td>
                    <td>${user.uname}</td>
                </tr>
            </c:forEach>
        </table>



    </div>









</div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
