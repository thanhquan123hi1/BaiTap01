package vn.Quan.controllers.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.Quan.models.CategoryModel;
import vn.Quan.services.impl.CategoryService;

@WebServlet(urlPatterns = {"/admin/categories/edit"})
public class CategoryEditController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    CategoryService cateService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        CategoryModel cate = cateService.findById(id);

        req.setAttribute("cate", cate);
        req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("cate_id"));
        String name = req.getParameter("cate_name");
        String icons = req.getParameter("icons");

        CategoryModel cate = new CategoryModel(id, name, icons);

        cateService.update(cate);
        resp.sendRedirect(req.getContextPath() + "/admin/categories");
    }
}

