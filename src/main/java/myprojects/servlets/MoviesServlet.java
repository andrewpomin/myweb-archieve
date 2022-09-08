package myprojects.servlets;

import myprojects.sql.SQLDispatcher;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/movies")
public class MoviesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long lastTime = System.currentTimeMillis() - request.getSession().getLastAccessedTime();

        if (SQLDispatcher.isSessionLogin(request.getSession().getId()) && lastTime < 86400000) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/movies.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }

//        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/movies.jsp");
//        requestDispatcher.forward(request, response);
    }
}
