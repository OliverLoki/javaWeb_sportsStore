package smbms.servlet;

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

@WebServlet(name = "GoodsInfoServlet", urlPatterns = "/jsp/goodsinfo.do")
public class GoodsInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        int num= Integer.parseInt(method);

        System.out.println(num);
        GoodsServices goodsServices = new GoodsServicesImpl();
        Goods goods = goodsServices.getGoodsByGid(num);
        //System.out.println(goods);
        request.setAttribute(Constants.GOODSINFO,goods);
        request.getRequestDispatcher("/jsp/buygoods.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
