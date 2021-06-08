<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/jsp/common/head.jsp" %>
<div class="goodsbar">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>商品展示界面</span>
    </div>
    <div class="goodstopbar">
        <ul class="goods_nav">
            <li>
                <a class="app" href="${pageContext.request.contextPath }/jsp/listedgoods.do?method=1">球类用品
                    <%--下拉菜单--%>
                    <div class="drop_down_menu">
                        <%--解决由于a标签嵌套导致的样式错乱问题--%>
                        <object><a href="${pageContext.request.contextPath }/jsp/seclisted.do?name=篮球">篮球</a></object>
                        <object><a href="${pageContext.request.contextPath }/jsp/seclisted.do?name=足球">足球</a></object>
                        <object><a href="${pageContext.request.contextPath }/jsp/seclisted.do?name=乒乓球">乒乓球</a></object>
                        <object><a href="${pageContext.request.contextPath }/jsp/seclisted.do?name=斯诺克">斯诺克/中式八球</a></object>
                    </div>
                </a>
            </li>
            <li><a class="app" href="${pageContext.request.contextPath }/jsp/listedgoods.do?method=2">跑步用品</a></li>
            <li><a class="app" href="${pageContext.request.contextPath }/jsp/listedgoods.do?method=3">游泳用品</a></li>
            <li><a class="app" href="${pageContext.request.contextPath }/jsp/listedgoods.do?method=4">健身用品</a></li>
            <li><a class="app" href="${pageContext.request.contextPath }/jsp/listedgoods.do?method=5">电子数码</a></li>
        </ul>
    </div>
    <div class="goods_content">
        <div class="goodsshow clearfix">
            <c:forEach var="goods" items="${goodslist}">
                <div class="show_goods">
                    <div class="show_goods_img">
                        <a href="${pageContext.request.contextPath }/jsp/goodsinfo.do?method=${goods.gid}"><img
                                src="${goods.gurl}" id="goods_image"></a>
                    </div>
                    <div>
                        <span id="goods_name"> ${goods.gname}</span>
                    </div>
                    <div>
                        <span id="price">￥${goods.gprice}</span>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</section>

