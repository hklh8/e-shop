<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
<base href="${base}/" />
<title>后台管理</title>
<meta charset="utf-8" />
<link rel="stylesheet" href="css/admin.css" />
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
			<div class="content_box" style="border:none">
				<div class="content">
					<table width="98%" cellspacing="0" cellpadding="0"
						class="border_table_org" style="float:left">
						<thead>
							<tr>
								<th>后台管理</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>欢迎进入后台管理</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div id="separator"></div>
	</div>
</body>
</html>
