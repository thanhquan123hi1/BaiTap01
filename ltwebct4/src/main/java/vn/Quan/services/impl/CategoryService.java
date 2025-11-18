package vn.Quan.services.impl;

import java.util.List;

import vn.Quan.dao.ICategoryDao;
import vn.Quan.dao.impl.CategoryDaoImpl;
import vn.Quan.models.CategoryModel;
import vn.Quan.services.ICategoryService;

public class CategoryService implements ICategoryService {

    ICategoryDao cateDao = new CategoryDaoImpl();

    @Override
    public List<CategoryModel> findALL() {
        return cateDao.findAll();
    }

    @Override
    public CategoryModel findById(int id) {
        return cateDao.findById(id);
    }

    @Override
    public boolean insert(CategoryModel cate) {
        return cateDao.insert(cate);
    }

	@Override
	public boolean update(CategoryModel category) {
		
		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(category.getCate_id());
		
		if (cate != null) {
			return cateDao.update(category);
		}
		return false;
	}

    @Override
    public boolean delete(int id) {
		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(id);
		
		if (cate != null) {
			return cateDao.delete(id);
		}
		return false;
    }
}
