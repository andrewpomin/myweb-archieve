package myprojects.filters;

import javax.servlet.*;

import java.io.IOException;

public class SecurityFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) resp;
//        long lastTime = System.currentTimeMillis() - request.getSession().getLastAccessedTime();
//
//        if (!SQLDispatcher.isSessionLogin(request.getSession().getId()) && lastTime > 86400000) {
//            response.sendRedirect(request.getContextPath() + "/login");
//        }
    }
}
