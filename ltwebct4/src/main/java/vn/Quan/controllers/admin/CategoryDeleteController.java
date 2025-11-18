package vn.Quan.controllers.admin;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.Quan.models.CategoryModel;
import vn.Quan.services.impl.CategoryService;

@WebServlet(urlPatterns = {"/admin/categories/delete"})
public class CategoryDeleteController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    CategoryService cateService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        // Lấy category cũ trước khi xóa để biết tên file icon
        CategoryModel cate = cateService.findById(id);

        // Đường dẫn thư mục upload
        String uploadPath = req.getServletContext().getRealPath("/uploads/category/");

        // Nếu category có icon -> xóa file icon khỏi server
        if (cate != null && cate.getIcons() != null) {
            File oldFile = new File(uploadPath + cate.getIcons());
            if (oldFile.exists()) {
                oldFile.delete();
            }
        }

        // Xóa trong DB
        cateService.delete(id);

        // Chuyển hướng về danh sách
        resp.sendRedirect(req.getContextPath() + "/admin/categories");
    }
}
