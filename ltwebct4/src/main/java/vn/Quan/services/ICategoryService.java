package vn.Quan.services;

import java.util.List;
import vn.Quan.models.CategoryModel;

public interface ICategoryService {
	
    List<CategoryModel> findALL();
    CategoryModel findById(int id);
    boolean insert(CategoryModel cate);
    boolean update(CategoryModel cate);
    boolean delete(int id);
}
