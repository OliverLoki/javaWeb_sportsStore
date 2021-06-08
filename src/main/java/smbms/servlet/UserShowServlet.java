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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserShowServlet",urlPatterns = "/jsp/usershow.do")
public class UserShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> alluser = new ArrayList<>();
        UserServices userServices = new UserServicesImpl();
        alluser = userServices.getAllUsers();
        System.out.println(alluser);
        if(alluser!=null){//用户名不为空
            request.setAttribute(Constants.ALLUSERMESSAGE,alluser);
            System.out.println("21231");
             request.getRequestDispatcher("/jsp/usershow.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
