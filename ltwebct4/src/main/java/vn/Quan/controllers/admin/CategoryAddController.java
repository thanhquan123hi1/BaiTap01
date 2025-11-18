package vn.Quan.controllers.admin;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.Quan.models.CategoryModel;
import vn.Quan.services.impl.CategoryService;

@WebServlet(urlPatterns = {"/admin/categories/add"})
@MultipartConfig   
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

        // lấy file từ input type="file"
        Part filePart = req.getPart("iconFile"); // name="iconFile"
        String fileName = filePart.getSubmittedFileName();

        String uploadPath = req.getServletContext().getRealPath("/uploads/category/");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        String savedFile = null;

        if (fileName != null && !fileName.isEmpty()) {
            savedFile = System.currentTimeMillis() + "_" + fileName;
            filePart.write(uploadPath + savedFile);
        }

        CategoryModel cate = new CategoryModel();
        cate.setCate_name(name);
        cate.setIcons(savedFile);

        cateService.insert(cate);

        resp.sendRedirect(req.getContextPath() + "/admin/categories");
    }
}
