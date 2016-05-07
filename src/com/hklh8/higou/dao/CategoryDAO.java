package com.hklh8.higou.dao;

import java.util.List;

import com.hklh8.higou.entity.Category;

public interface CategoryDAO {
	public void addCategory(Category category);
	
	public List<Category> getCategories();
	
	public void updateGoodsNum(String id,int goodsNum);
}
