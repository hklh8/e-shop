package com.hklh8.higou.service;

import java.util.List;

import com.hklh8.higou.entity.Category;

public interface CategoryService {
	public void addCategory(Category category);
	
	public List<Category> getCategories();
	
	public List<Category> getCategoriesForIndex();
}
