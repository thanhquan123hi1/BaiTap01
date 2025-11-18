package vn.Quan.controllers.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.Quan.models.CategoryModel;
import vn.Quan.services.impl.CategoryService;

@WebServlet(urlPatterns = {"/admin/categories/add"})
public class CategoryAddController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    CategoryService cateService = new CategoryService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("cate_name");
        String icons = req.getParameter("icons");

        CategoryModel cate = new CategoryModel();
        cate.setCate_name(name);
        cate.setIcons(icons);

        cateService.insert(cate);
        resp.sendRedirect(req.getContextPath() + "/admin/categories");
    }
}

