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
import java.util.List;

@WebServlet(name = "CartShowServlet",urlPatterns = "/jsp/cartshow.do")
public class CartShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");
        int num = Integer.parseInt(uid);
        GoodsServices goodsServices = new GoodsServicesImpl();
        List<Goods> cartGoods = goodsServices.getCartGoods(num);
        request.setAttribute(Constants.CARTGOODS,cartGoods);
        request.getRequestDispatcher("/jsp/shoppingcart.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
