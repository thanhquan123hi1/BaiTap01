package vn.Quan.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.Quan.services.IUserService;
import vn.Quan.services.impl.UserService;
import vn.Quan.models.UserModel;

@WebServlet(urlPatterns = {"/forget"})
public class ForgetPasswordController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    IUserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/views/forget.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");

        if (email == null || email.isEmpty()) {
            req.setAttribute("alert", "Email không được rỗng!");
            req.getRequestDispatcher("/views/forget.jsp").forward(req, resp);
            return;
        }

        // Tìm user theo email
        UserModel user = service.findByEmail(email);

        if (user == null) {
            req.setAttribute("alert", "Email không tồn tại!");
            req.getRequestDispatcher("/views/forget.jsp").forward(req, resp);
            return;
        }

        // Gửi mật khẩu (demo): IN PASSWORD RA MÀN HÌNH
        req.setAttribute("alert", "Mật khẩu của bạn là: " + user.getPassword());
        req.getRequestDispatcher("/views/forget.jsp").forward(req, resp);
    }
}
