function add(goodsId,goodsNum){
	var goods={
			"goodsId":goodsId,
			"goodsNum":goodsNum
	};
	var data;
	if($.cookie("shopcar")==null){
		data = [];
		data.push(goods);
	}else{
		data = get();
		addGoods(data, goods);
	}
	$.cookie("shopcar",JSON.stringify(data));
}

function addGoods(goodses,goods){
	for(var i=0;i<goodses.length;i++){
		if(goods.goodsId==goodses[i].goodsId){
			goodses[i].goodsNum=parseInt(goodses[i].goodsNum)+parseInt(goods.goodsNum)
			return;
		}
	}
	goodses.push(goods);
}

function get(){
	var goodses = $.cookie("shopcar");
	if(goodses==null){
		return [];
	}
	return JSON.parse(goodses);
}

function addJSON(target,src){
	for(var p in src){
		target[p]=src[p];
	}
}

function getGoodsNumById(goodses,goodsId){
	for(var i=0;i<goodses.length;i++){
		if(goodsId==goodses[i].goodsId){
			return goodses[i].goodsNum;
		}
	}
}

