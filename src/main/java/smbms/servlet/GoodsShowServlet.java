package smbms.servlet;

import jdk.swing.interop.SwingInterOpUtils;
import smbms.pojo.Goods;
import smbms.services.goods.GoodsServices;
import smbms.services.goods.GoodsServicesImpl;
import smbms.services.user.UserServices;
import smbms.services.user.UserServicesImpl;
import smbms.tools.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TODO 商品展示功能
@WebServlet(name = "GoodsShowServlet", urlPatterns = "/jsp/goodsshow.do")
public class GoodsShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Goods> allGoods = new ArrayList<>();
        GoodsServices goodsServices = new GoodsServicesImpl();
        allGoods = goodsServices.getAllGoods();
        if (null != allGoods) {//为空
            request.setAttribute(Constants.GOODSSLISt, allGoods);
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
