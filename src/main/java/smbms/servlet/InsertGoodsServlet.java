package smbms.servlet;

import smbms.services.goods.GoodsServices;
import smbms.services.goods.GoodsServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertGoodsServlet", urlPatterns = "/jsp/insertgoods.do")
public class InsertGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gid = request.getParameter("gid");
        String uid = request.getParameter("uid");

        int num1 = Integer.parseInt(gid);
        int num2 = Integer.parseInt(uid);

        GoodsServices goodsServices =new GoodsServicesImpl();
        int insertgoods = goodsServices.insertgoods(num1, num2);
        /*
        TODO ：解决添加重复商品，以及使用js实现添加成功
         */

        //System.out.println(insertgoods);
        //response.sendRedirect("/jsp/goodsshow.do");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request, response);
    }
}
