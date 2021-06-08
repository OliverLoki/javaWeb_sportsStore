<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/jsp/common/head.jsp" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>商品详情页</span>
    </div>
    <div class="cartlogbar">
        <div class="goodsinfobar">
            <div class="info_img">
                <img src="${goodsinfo.gurl}" id="goods_image"></a>
            </div>
            <div class="rightinfobar">
                <div class="info_name">
                    <h1 style="font-family: 'PingHei','Helvetica Neue','Helvetica','Arial','Verdana','sans-serif';
                        font-size: 38px;">购买 &nbsp<span style="font-family: 'PingHei','Helvetica Neue','Helvetica','Arial','Verdana','sans-serif';
                        font-size: 42px;"> ${goodsinfo.gname}</span></h1>
                </div>
                <br>
                <br>
                <div class="info_desc">
                    <span>${goodsinfo.gdesc}</span>
                </div>
                <br><br><br><br><br><br><br><br>
                <div class="info_price">
                    <span style="font-size: 60px;font-family:'PingHei','Helvetica Neue','Helvetica','Arial','Verdana','sans-serif' ;">RMB</span>
                    &nbsp
                    <span STYLE="color: rebeccapurple;font-size: 60px;font-family:'PingHei','Helvetica Neue','Helvetica','Arial','Verdana','sans-serif' ;">${goodsinfo.gprice}</span>
                </div>

                <div class="info_a">
                    <%--                    <input type="button" onclick="goods_buy_add_sumbit('add',${goodsinfo.gid},${sessionScope.userSession.uid})" value="加入购物车">--%>
                    <a href="#">立即购买</a>
                    <a onclick="goods_buy_add_sumbit('add',${goodsinfo.gid},${sessionScope.userSession.uid})">
                        加入购物车
                    </a>
                        <br><br><br>
                        <a href="${pageContext.request.contextPath }/jsp/goodsshow.do">返回商品展示页</a>
                </div>

            </div>
        </div>
    </div>
</div>
</div>
</section>
<script>
    function goods_buy_add_sumbit(str, gid, uid) {
        var url = "/jsp/insertgoods.do?gid=" + gid + "&uid=" + uid;
        setAjax(url, str)
    }

    function setAjax(url, str) {
        var xmlhttp;
        if (window.XMLHttpRequest) {
            xmlhttp = new XMLHttpRequest();
        } else {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                if (str == "add") {
                    alert("已加入购物车!");
                }
            }
        }
        xmlhttp.open("GET", url, true);
        xmlhttp.send();
    }
</script>


<%@include file="/jsp/common/foot.jsp" %>
