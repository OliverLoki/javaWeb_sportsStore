<%@ page import="smbms.pojo.Goods" %>
<%@ page import="java.util.List" %>
<%@ page import="smbms.tools.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>购物车结算界面</span>
    </div>
    <%
    float sum = 0;
    for(Goods goods:(List<Goods>)(request.getAttribute(Constants.CARTGOODS))){
        sum+=Float.parseFloat(goods.getGprice());
    }
    %>
    <div class="cartlogbar  clearfix">
        <c:forEach var="goods" items="${cartgoods}">
            <div class="cartlogcontent">
                <div class="contentimg">
                   <img src="${goods.gurl}" id="goods_image">
                </div>
                <div class="contentdesc clearfix">
                    <span id="contentname"> ${goods.gname}
                        <br><span id="amount">数量: &nbsp; 1</span></span>
                    <span id="contentdescribe"> ${goods.gdesc}</span>
                    <span id="contentprice">￥${goods.gprice}</span>

                </div>
            </div>
        </c:forEach>
    </div>

    <div class="all_price">
        <span id="allpriceleft">当前商品总价为&nbsp;:</span>&nbsp;&nbsp;
        <span id="allpriceright"><%=sum%></span>
        <br>
        <input id="allpricebotton" type="button"value="立即结算" onclick="this">
    </div>
</div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
