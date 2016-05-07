package com.hklh8.higou.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hklh8.higou.dao.CategoryDAO;
import com.hklh8.higou.dao.GoodsDAO;
import com.hklh8.higou.entity.Goods;
import com.hklh8.higou.entity.PageBean;
import com.hklh8.higou.service.GoodsService;
import com.hklh8.higou.util.HigouUtil;

public class GoodsServiceImpl implements GoodsService {

	private GoodsDAO goodsDAO;
	private CategoryDAO categoryDAO;
	@Override
	public void addGoods(Goods goods) {
		goods.setId(HigouUtil.getId());
		goodsDAO.addGoods(goods);
		categoryDAO.updateGoodsNum(goods.getCategoryId(), 1);
	}
	
	public GoodsDAO getGoodsDAO() {
		return goodsDAO;
	}
	public void setGoodsDAO(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Override
	public List<Goods> getGoods(Goods goods) {
		return goodsDAO.getGoods(goods);
	}

	@Override
	public PageBean<Goods> getGoodsByPage(int page, Goods goods) {
		int pageSize = 3;
		int startNum = (page-1)*pageSize;
		PageBean<Goods> pageBean = new PageBean<>();
		Map<String, Object> params = new HashMap<>();
		params.put("page", page);
		params.put("pageSize", pageSize);
		params.put("goods", goods);
		params.put("startNum", startNum);
		
		List<Goods> data = goodsDAO.getGoodsByPage(params);
		
		pageBean.setData(data);
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		pageBean.setActualPageSize(data.size());
		int totalNum = goodsDAO.getGoodsNum(goods);
		pageBean.setTotalNum(totalNum);
		int totalPage = (totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	@Override
	public Goods getGoodsById(String id) {
		return goodsDAO.getGoodsById(id);
	}

	@Override
	public void updateGoods(Goods goods) {
//		Goods oldGoods = goodsDAO.getGoodsById(goods.getId());
//		oldGoods.setName(goods.getName());
//		oldGoods.setGoodsNo(goods.getGoodsNo());
//		oldGoods.setCategoryId(goods.getCategoryId());
//		oldGoods.setStock(goods.getStock());
//		oldGoods.setPrice1(goods.getPrice1());
//		oldGoods.setPrice2(goods.getPrice2());
//		oldGoods.setDescription(goods.getDescription());
//		oldGoods.setThumbnail(goods.getThumbnail());
		goodsDAO.updateGoods(goods);
	}

	@Override
	public void delGoods(String id) {
		goodsDAO.delGoods(id);
	}

	@Override
	public List<Goods> getGoodsByCateId(String cateId) {
		return goodsDAO.getGoodsByCateId(cateId, 6);
	}

	@Override
	public List<Goods> getGoodsesByIds(String... ids) {
		return goodsDAO.getGoodsesByIds(ids);
	}

}
