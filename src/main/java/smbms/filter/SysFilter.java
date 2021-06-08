package smbms.filter;

import smbms.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 实现权限拦截，当检测到session为空时，转到错误界面
 */
@WebFilter(filterName = "SysFilter",urlPatterns = "/jsp/*")
public class SysFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       // System.out.println("SysFilter doFilter()===========");
        HttpServletRequest rq = (HttpServletRequest)req;
        HttpServletResponse rp = (HttpServletResponse)resp;
        User userSession = (User)rq.getSession().getAttribute("userSession");
        if(null == userSession){
            rp.sendRedirect(rq.getContextPath()+"/error.jsp");
        }else{
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
