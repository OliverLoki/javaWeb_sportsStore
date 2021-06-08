package smbms.servlet;

import smbms.pojo.Goods;
import smbms.services.goods.GoodsServices;
import smbms.services.goods.GoodsServicesImpl;
import smbms.tools.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListedGoodsServlet", urlPatterns = "/jsp/listedgoods.do")
public class ListedGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        int num =1;
        List<Goods> Goods = new ArrayList<>();
        GoodsServices goodsServices = new GoodsServicesImpl();
        num = Integer.parseInt(method.trim());
        Goods = goodsServices.getGoods(num);
        if (null != Goods){//为空
            request.setAttribute(Constants.GOODSSLISt, Goods);
            request.getRequestDispatcher("/jsp/goodsshow.jsp").forward(request, response);
        } else {
            request.setAttribute(Constants.GOODSSLISt, "当前暂无商品可售");
            request.getRequestDispatcher("/jsp/goodsshow.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
