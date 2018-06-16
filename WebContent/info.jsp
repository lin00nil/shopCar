<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>图片详情页</title>
</head>
<body>
图片详情
 <img alt="找不到图片" src="./images/article/${goods.img }" /><br/>
     <div>
    	该商品的名称为${goods.gname },原有价格为：${goods.gprice }，会员价：${goods.gprice*0.5 }<br>
    	<input type="button" id="go" value="加入购物车">
    	</div>
</body>
</html>