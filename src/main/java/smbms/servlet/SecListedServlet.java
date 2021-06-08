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

@WebServlet(name = "SecListedServlet",urlPatterns = "/jsp/seclisted.do")
public class SecListedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO
        String name = request.getParameter("name");

        System.out.println(name);

        List<Goods> allGoods = new ArrayList<>();
        GoodsServices goodsServices = new GoodsServicesImpl();
        allGoods = goodsServices.getGoodsByName(name);

        System.out.println(allGoods);

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
