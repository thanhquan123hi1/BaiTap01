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
    public List<CategoryModel> findAll() {
        List<CategoryModel> list = new ArrayList<>();
        String sql = "SELECT * FROM categories";

        try (Connection conn = super.getDatabaseConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CategoryModel(
                        rs.getInt("cate_id"),
                        rs.getString("cate_name"),
                        rs.getString("icons")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public CategoryModel findById(int id) {
        String sql = "SELECT * FROM categories WHERE cate_id=?";
        try (Connection conn = super.getDatabaseConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new CategoryModel(
                        rs.getInt("cate_id"),
                        rs.getString("cate_name"),
                        rs.getString("icons")
                );
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public boolean insert(CategoryModel cate) {
        String sql = "INSERT INTO categories(cate_name, icons) VALUES (?,?)";
        try (Connection conn = super.getDatabaseConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cate.getCate_name());
            ps.setString(2, cate.getIcons());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean update(CategoryModel cate) {
        String sql = "UPDATE categories SET cate_name=?, icons=? WHERE cate_id=?";
        try (Connection conn = super.getDatabaseConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cate.getCate_name());
            ps.setString(2, cate.getIcons());
            ps.setInt(3, cate.getCate_id());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM categories WHERE cate_id=?";
        try (Connection conn = super.getDatabaseConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }
}
