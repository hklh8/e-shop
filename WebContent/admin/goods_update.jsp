<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${base}/"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
<link rel="stylesheet" href="css/admin.css">
<script type="text/javascript" src="js/jquery-2.0.3.js"></script>
<script type="text/javascript">
	$(function(){
		$("#categoryId").val("${goods.categoryId}");
	});
</script>
</head>
<body>
	<div class="container">
		<div id="header">
			<jsp:include page="header.jsp"></jsp:include>
		</div>
		<div id="admin_left">
			<ul class="submenu">
				<jsp:include page="left.jsp"></jsp:include>
			</ul>
			<div id="copyright"></div>
		</div>
		
		<div id="admin_right">
			<div class="content_box">
				<div class="content form_content">
					<form action="goods_updateopr" method="post" enctype="multipart/form-data">
						<input type="hidden" name="goods.id" value="${goods.id}">
						<div id="table_box_1">
							<table class="form_table">
								<colgroup>
									<col width="150px">
									<col>
								</colgroup>
								<tbody>
									<tr>
										<th>商品名称：</th>
										<td>
											<input class="normal" name="goods.name" type="text" value="${goods.name}"><label>*</label>
										</td>
									</tr>
									<tr>
										<th>所属分类：</th>
										<td>
											<select name="goods.categoryId" id="categoryId">
												<c:forEach items="${categories}" var="category">
													<option value="${category.id}">${category.name}</option>
												</c:forEach>
											</select>
										</td>
									</tr>
									<tr>
										<th>基本数据：</th>
										<td>
											<div class="con">
												<table class="border_table">
													<thead id="goodsBaseHead">
														<tr>
															<th>商品货号</th>
															<th>库存</th>
															<th>市场价格</th>
															<th>销售价格</th>
														</tr>
													</thead>
													<tbody id="goodsBaseBody">
														<tr class="td_c">
															<td><input class="small" name="goods.goodsNo" type="text" value="${goods.goodsNo}"></td>
															<td><input class="tiny" name="goods.stock" type="text" value="${goods.stock}"></td>
															<td><input class="tiny" name="goods.price1" type="text" value="${goods.price1}"></td>
															<td><input class="tiny" name="goods.price2" type="text" value="${goods.price2}"></td>
														</tr>
													</tbody>
												</table>
											</div>
										</td>
									</tr>
									<tr>
										<th>缩略图：</th>
										<td><input type="hidden" name="goods.thumbnail" value="${goods.thumbnail}"><img src="${goods.thumbnail}" width="100" height="100"><input type="file" name="thumbnail"></td>
									</tr>
									<tr>
										<th>产品描述：</th>
										<td><textarea rows="5" cols="5" name="goods.description">${goods.description}</textarea></td>
									</tr>
								</tbody>
							</table>
						</div>
						<table class="form_table">
							<colgroup>
								<col width="150px">
								<col>
							</colgroup>
							<tbody>
								<tr>
									<td></td>
									<td><button class="submit" type="submit">
										<span>发布商品</span>
									</button></td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>