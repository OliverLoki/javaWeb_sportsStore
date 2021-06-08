package smbms.servlet;

import smbms.pojo.User;
import smbms.services.user.UserServices;
import smbms.services.user.UserServicesImpl;
import smbms.tools.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("userpassword");

        //调用login方法
        UserServices userService = new UserServicesImpl();
        User user = userService.login(username, password);
        if (null != user) { //user不为空，判断密码
            if (user.getPwd().equals(password)) {//密码正确
                request.getSession().setAttribute(Constants.USER_SESSION, user);
                request.getRequestDispatcher(request.getContextPath()+"jsp/frame.jsp").forward(request, response);
            } else {//密码不正确
               // System.out.println("密码不正确");
                request.setAttribute(Constants.ERROR, "密码不正确");
                response.sendRedirect("/login.jsp");
            }
        } else {//用户名不正确
           // System.out.println("用户名不正确");
            request.setAttribute(Constants.ERROR, "用户名不正确");
            response.sendRedirect("/login.jsp");
        }
        //TODO 前端获取不到这个值
        //System.out.println(request.getAttribute(Constants.ERROR));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
