package com.hklh8.higou.service;

import java.util.List;

import com.hklh8.higou.entity.Goods;
import com.hklh8.higou.entity.PageBean;

public interface GoodsService {
	public void addGoods(Goods goods);
	
	public List<Goods> getGoods(Goods goods);
	
	public PageBean<Goods> getGoodsByPage(int page,Goods goods);
	
	public Goods getGoodsById(String id);
	
	public void updateGoods(Goods goods);
	
	public void delGoods(String id);
	
	public List<Goods> getGoodsByCateId(String cateId);
	
	public List<Goods> getGoodsesByIds(String...ids);
}
