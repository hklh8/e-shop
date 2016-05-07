package com.hklh8.higou.service.impl;

import java.util.List;

import com.hklh8.higou.dao.CategoryDAO;
import com.hklh8.higou.dao.GoodsDAO;
import com.hklh8.higou.entity.Category;
import com.hklh8.higou.service.CategoryService;
import com.hklh8.higou.util.HigouUtil;

public class CategoryServiceImpl implements CategoryService {
	
	private CategoryDAO categoryDAO;
	private GoodsDAO goodsDAO;
	@Override
	public void addCategory(Category category) {
		category.setId(HigouUtil.getId());
		categoryDAO.addCategory(category);
	}
	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	@Override
	public List<Category> getCategories() {
		return categoryDAO.getCategories();
	}
	@Override
	public List<Category> getCategoriesForIndex() {
		List<Category> categories = categoryDAO.getCategories();
		for (Category category : categories) {
			category.setGoodses(goodsDAO.getGoodsByCateId(category.getId(), 4));
		}
		return categories;
	}
	public GoodsDAO getGoodsDAO() {
		return goodsDAO;
	}
	public void setGoodsDAO(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}
}
