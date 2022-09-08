package myprojects.servlets;

import myprojects.sql.SQLDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect(request.getContextPath() + "/home");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String phone = request.getParameter("phone");
        String sessionId = request.getSession().getId();
        long createTime = request.getSession().getCreationTime();

        try {
            if (SQLDispatcher.isUserExists(email)) {
                response.sendRedirect(request.getContextPath() + "/signup?error=1");
            } else {
                SQLDispatcher.registerUser(email, password, firstName, lastname, phone, sessionId, createTime);
                response.sendRedirect(request.getContextPath() + "/home");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
