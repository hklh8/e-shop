<%@ page language="java" pageEncoding="UTF-8"%>
<script>
	function cart(){
		var goodses = get();
		var goodsNum = 0;
		var params = "{\"goodsIds\":\"";
		if (goodses.length != 0) {
			for (var i = 0; i < goodses.length; i++) {
				params += goodses[i].goodsId + ",";
				goodsNum = parseInt(goodsNum) + parseInt(goodses[i].goodsNum);
			}
			params = params.substring(0, params.length - 1);
		}
		params += "\"}";
		
		$("b[name=mycart_count]").html(goodsNum);
	
		$.getJSON("goods_getGoodsesByIds", JSON.parse(params), function(r) {
			//alert(r);
			var json = JSON.parse(r);
			var totalMoney = 0;
			for (var i = 0; i < json.length; i++) {
				addJSON(json[i], {
					"goodsNum" : getGoodsNumById(goodses, json[i].id)
				});
				var html = template("shopcarTemplate", json[i]);
				$("#shopcarDiv").prepend(html);
				totalMoney += json[i].price2 * json[i].goodsNum;
			}
			$("b[name=mycart_sum]").html("￥" + totalMoney);
		});
	}
	
	$(function() {
		cart();
		
		$('.mycart').hover(function() {
			$('#div_mycart').show('slow');
		}, function() {
			$('#div_mycart').hide('slow');
		});
	});
	
</script>
<script id="shopcarTemplate" type="text/plain">
<dd class="site_cart_dd_0">
<div class="pic f_l">
	<img width="55" height="55" src="{{thumbnail}}">
</div>
<h3 class="title f_l">
	<a href="goods_view?goods.id={{id}}">{{name}}</a>
</h3>
<div class="price f_r t_r">
	<b class="block">￥{{price2}} x {{goodsNum}}</b> <input class="del" type="button"
		value="删除" onclick="">
</div>
</dd>
</script>
<div class="navbar">
	<ul>
		<li><a href="">首页</a></li>
		<li><a href="">手机<span> </span></a></li>
	</ul>

	<div class="mycart">
		<dl>
			<dt>
				<a href="cart.jsp">购物车<b name="mycart_count"></b>件
				</a>
			</dt>
			<dd>
				<a href="cart.jsp">去结算</a>
			</dd>
		</dl>

		<!--购物车浮动div 开始-->
		<div class="shopping" id="div_mycart" style="display: none;">
			<dl class="cartlist" id="shopcarDiv">
				


				<dd class="static">
					<span>共<b name="mycart_count"></b>件商品
					</span>金额总计：<b name="mycart_sum">0</b>
				</dd>

				<dd class="static">
					<label class="btn_orange"><input type="button"
						value="去购物车结算" onclick="location.href='cart.jsp'"></label>
				</dd>

			</dl>
		</div>

	</div>
</div>