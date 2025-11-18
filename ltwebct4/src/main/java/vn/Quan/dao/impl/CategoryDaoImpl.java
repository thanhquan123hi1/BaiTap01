package vn.Quan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.Quan.configs.DBConnectMySQL;
import vn.Quan.dao.ICategoryDao;
import vn.Quan.models.CategoryModel;

public class CategoryDaoImpl extends DBConnectMySQL implements ICategoryDao {

    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public List<CategoryModel> findALL() {
        String sql = "SELECT * FROM categories";
        List<CategoryModel> list = new ArrayList<>();

        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new CategoryModel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("images")
                ));
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }

        return null;
    }

    @Override
    public CategoryModel findById(int id) {
        String sql = "SELECT * FROM categories WHERE id = ?";
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new CategoryModel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("images")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return null;
    }

    @Override
    public void insert(CategoryModel category) {
        String sql = "INSERT INTO categories(name, images) VALUES (?, ?)";

        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, category.getName());
            ps.setString(2, category.getImages());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    @Override
    public void update(CategoryModel category) {
        String sql = "UPDATE categories SET name = ?, images = ? WHERE id = ?";

        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, category.getName());
            ps.setString(2, category.getImages());
            ps.setInt(3, category.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM categories WHERE id = ?";

        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    @Override
    public List<CategoryModel> findName(String keyword) {
        String sql = "SELECT * FROM categories WHERE name LIKE ?";
        List<CategoryModel> list = new ArrayList<>();

        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new CategoryModel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("images")
                ));
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return null;
    }
}
