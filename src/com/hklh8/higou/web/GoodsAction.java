package com.hklh8.higou.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;

import com.hklh8.higou.entity.Category;
import com.hklh8.higou.entity.Goods;
import com.hklh8.higou.entity.PageBean;
import com.hklh8.higou.service.CategoryService;
import com.hklh8.higou.service.GoodsService;
import com.hklh8.higou.util.HigouUtil;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class GoodsAction {

	private CategoryService categoryService;
	private List<Category> categories;
	private String goodsNo;
	private Goods goods;
	private GoodsService goodsService;
	private File thumbnail;
	private String thumbnailFileName;

	public String add() {
		goodsNo = "HG" + HigouUtil.getGoodsNo();
		categories = categoryService.getCategories();
		return "add";
	}

	public String addopr() {

		String dir = ServletActionContext.getServletContext().getRealPath("/goodsimages");
		String suffix = "";
		String fileName = HigouUtil.getId();
		if (thumbnail != null) {
			suffix = thumbnailFileName.substring(thumbnailFileName.lastIndexOf("."));
			File savaFile = new File(new File(dir), fileName + suffix);
			if (!savaFile.getParentFile().exists()) {
				savaFile.getParentFile().mkdir();
			}
			try {
				FileUtil.copyFile(thumbnail, savaFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			goods.setThumbnail("goodsimages/" + fileName + suffix);
		}

		goodsService.addGoods(goods);
		return "oprsuc";
	}

	private List<Goods> goodses;

	public String list() {
		categories = categoryService.getCategories();
		goodses = goodsService.getGoods(goods);
		return "list";
	}

	private PageBean<Goods> pageBean;
	private int page;
	public String listByPage() {
		categories = categoryService.getCategories();
		if (page == 0) {
			page = 1;
		}
		pageBean = goodsService.getGoodsByPage(page, goods);
		return "list";
	}
	
	public String update(){
		categories = categoryService.getCategories();
		goods = goodsService.getGoodsById(goods.getId());
		return "update";
	}
	
	public String updateopr(){
		if (thumbnail != null) {
			String dir = ServletActionContext.getServletContext().getRealPath("/");
			String suffix = thumbnailFileName.substring(thumbnailFileName.lastIndexOf("."));
			String fileName = HigouUtil.getId();
			File savaFile = new File(new File(dir+"/goodsimages"), fileName + suffix);
			if (!savaFile.getParentFile().exists()) {
				savaFile.getParentFile().mkdir();
			}
			try {
				FileUtil.copyFile(thumbnail, savaFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			new File(dir+"/"+goods.getThumbnail()).delete();
			
			goods.setThumbnail("goodsimages/" + fileName + suffix);
		}
		
		goodsService.updateGoods(goods);
		return "updatesuc";
	}
	
	public String del(){
		goodsService.delGoods(goods.getId());
		return "delsuc";
	}
	
	public String listByCate(){
		categories = categoryService.getCategories();
		goodses = goodsService.getGoodsByCateId(goods.getCategoryId());
		return "bycate";
	}
	
	public String view(){
		goods = goodsService.getGoodsById(goods.getId());
		return "view";
	}
	
	private String goodsIds;
	private String result;
	public String getGoodsesByIds(){
		String[] ids = goodsIds.split(",");
		goodses = goodsService.getGoodsesByIds(ids);
		JsonConfig c = new JsonConfig();
		c.setExcludes(new String[]{"category","goodsNo","categoryId","price1","stock","description"});
		JSONArray a = JSONArray.fromObject(goodses,c);
		result = a.toString();
		return "getgoodsesbyids";
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

	public String getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public File getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(File thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getThumbnailFileName() {
		return thumbnailFileName;
	}

	public void setThumbnailFileName(String thumbnailFileName) {
		this.thumbnailFileName = thumbnailFileName;
	}

	public List<Goods> getGoodses() {
		return goodses;
	}

	public void setGoodses(List<Goods> goodses) {
		this.goodses = goodses;
	}

	public PageBean<Goods> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Goods> pageBean) {
		this.pageBean = pageBean;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getGoodsIds() {
		return goodsIds;
	}

	public void setGoodsIds(String goodsIds) {
		this.goodsIds = goodsIds;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
