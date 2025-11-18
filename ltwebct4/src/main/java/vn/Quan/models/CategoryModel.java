package vn.Quan.models;

import java.io.Serializable;

public class CategoryModel implements Serializable{

	private static final long serialVersionUID = 1L;
    private int cate_id;
    private String cate_name;
    private String icons;
    
	public CategoryModel() {
		super();
	}

	public CategoryModel(int cate_id, String cate_name, String icons) {
		super();
		this.cate_id = cate_id;
		this.cate_name = cate_name;
		this.icons = icons;
	}

	public int getCate_id() {
		return cate_id;
	}

	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}

	public String getCate_name() {
		return cate_name;
	}

	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}

	public String getIcons() {
		return icons;
	}

	public void setIcons(String icons) {
		this.icons = icons;
	}

	@Override
	public String toString() {
		return "CategoryModel [cate_id=" + cate_id + ", cate_name=" + cate_name + ", icons=" + icons + "]";
	}
	
}
