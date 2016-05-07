package com.hklh8.higou.web;

import java.util.List;

import com.hklh8.higou.entity.Category;
import com.hklh8.higou.service.CategoryService;

public class IndexAction {
	
	private CategoryService categoryService;
	private List<Category> categories;
	
	public String execute(){
		categories = categoryService.getCategoriesForIndex();
		return "index";
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
}
