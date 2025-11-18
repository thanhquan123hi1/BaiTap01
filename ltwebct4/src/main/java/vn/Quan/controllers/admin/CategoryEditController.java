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

@WebServlet(urlPatterns = {"/admin/categories/edit"})
@MultipartConfig
public class CategoryEditController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    CategoryService cateService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("cate", cateService.findById(id));

        req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("cate_id"));
        String name = req.getParameter("cate_name");

        CategoryModel oldCate = cateService.findById(id);

        Part filePart = req.getPart("iconFile");
        String newFileName = filePart.getSubmittedFileName();

        String uploadPath = req.getServletContext().getRealPath("/uploads/category/");

        String finalFileName = oldCate.getIcons();

        if (newFileName != null && !newFileName.isEmpty()) {

            // Xóa ảnh cũ
            File oldFile = new File(uploadPath + oldCate.getIcons());
            if (oldFile.exists()) oldFile.delete();

            // Lưu ảnh mới
            finalFileName = System.currentTimeMillis() + "_" + newFileName;
            filePart.write(uploadPath + finalFileName);
        }

        CategoryModel cate = new CategoryModel(id, name, finalFileName);
        cateService.update(cate);

        resp.sendRedirect(req.getContextPath() + "/admin/categories");
    }
}


