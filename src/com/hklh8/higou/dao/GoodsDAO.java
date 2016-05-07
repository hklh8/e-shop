package com.hklh8.higou.dao;

import java.util.List;
import java.util.Map;

import com.hklh8.higou.entity.Goods;

public interface GoodsDAO {
	public void addGoods(Goods goods);
	
	public List<Goods> getGoods(Goods goods);
	/**
	 * 用于分页查询
	 * @param params
	 * @return
	 */
	public List<Goods> getGoodsByPage(Map<String, Object> params);
	/**
	 * 查询商品数量
	 * @param goods
	 * @return
	 */
	public int getGoodsNum(Goods goods);
	
	public Goods getGoodsById(String id);
	
	public void updateGoods(Goods goods);
	
	public void delGoods(String id);
	
	public List<Goods> getGoodsByCateId(String cateId,int num);
	
	public List<Goods> getGoodsesByIds(String[] ids);
}
