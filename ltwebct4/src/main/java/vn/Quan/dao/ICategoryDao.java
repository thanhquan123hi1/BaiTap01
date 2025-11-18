package vn.Quan.dao;

import java.util.List;
import vn.Quan.models.CategoryModel;

public interface ICategoryDao {
    List<CategoryModel> findAll();
    CategoryModel findById(int id);
    boolean insert(CategoryModel cate);
    boolean update(CategoryModel cate);
    boolean delete(int id);
}
