package smbms.servlet;

import smbms.tools.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 移除session，并重定向到登录页面
 * TODO：实现过滤器拦截，一旦退出后无法进入主界面
 */
@WebServlet(name = "LogoutServlet",urlPatterns = "/jsp/logout.do")
public class LogoutServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //清除session
        request.getSession().removeAttribute(Constants.USER_SESSION);
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }
}
