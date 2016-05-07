package com.hklh8.higou.web;

import java.util.List;

import com.hklh8.higou.entity.Category;
import com.hklh8.higou.service.CategoryService;

public class CategoryAction {
	private Category category;
	private CategoryService categoryService;
	
	public String add(){
		categoryService.addCategory(category);
		return "oprsuc";
	}
	
	private List<Category> categories;
	public String list(){
		categories = categoryService.getCategories();
		return "list";
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
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
