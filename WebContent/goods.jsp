<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	function jPage(){
		var jp=document.getElementById("jumpPage").value;
		var pageCount=document.getElementById("pageCount").value;
		if(isNaN(jp)){
			alert("请输入数字！！");
		}
		if(jp>pageCount||jp<1){
			alert("总共"+pageCount+"页，请输入小于"+pageCount+"的值");
		}else{
			pageNows(jp);
		}
	}
	//登录 注册 是否登录  查询  商品详细信息 加入购物车 
	function pageNows(page){
		$.ajax({
			type:"post",
			url:"GoodsView",
			data:"pageNow="+page,
			dataType:"json",
			success:function(pd){
				var goods=pd.list;
				var tr="";
				var info="";
				tr="<tr><th>id</th><th>名称</th><th>价格</th><th>类型</th><th>数量</th><th>操作</th></tr>";
				for(var i=0;i<goods.length;i++){
					tr=tr+"<tr><td>"+goods[i].gid+"</td><td>"
					+goods[i].gname+"</td><td>"+goods[i].gtype+"</td><td>"
					+goods[i].gprice+"</td><td>"+goods[i].gnum+"</td><td>"
					+"</td></tr>";
				}			
				tr=tr+"<a style='text-decoration:none' href='DeleteGood?gid=${good.gid }'>删除"+
				"<a style='text-decoration:none' href='goodsInfoServlet?gid=${good.gid }'>查看<tr id='tf'></tr>";
				$("#tb").html(tr);
				info = info+"<td colspan=6 >当前"+pd.pageNow+"页/共"+pd.pageCount+"页，每页显示"+pd.pageSize+"条记录，共"+pd.rowCount+"条记录";
				if(pd.pageNow>1){
					info = info+"<a href=javascript:pageNows("+pd.pageNow+")>首页</a>&nbsp;&nbsp;"
							+"<a href=javascript:pageNows("+(pd.pageNow-1)+") >上一页</a>&nbsp;&nbsp;";
				}else{
					info = info+"首页&nbsp;&nbsp;上一页&nbsp;&nbsp;";
				}
				if(pd.pageNow<pd.pageCount){
					info = info+"<a href=javascript:pageNows("+(pd.pageNow+1)+")>下一页</a>&nbsp;&nbsp;"
							+"<a href=javascript:pageNows("+pd.pageCount+")>末页</a>&nbsp;&nbsp;";
				}else{
					info=info+"下一页&nbsp;&nbsp;末页&nbsp;&nbsp;";
				}
				info = info +",<input type=text width=2 id=jumpPage value="+pd.pageNow+" size=2>页<input type=button value=跳转  onclick=jPage()/>"
  						+"</td></tr>";
				$("#tf").append(info);
			},
			error:function(){
				alert("系统繁忙，请稍后再试！");
			}
		})
	}
</script>
</head>
<body>
	<table border="1" id="tb">
		<tr>
			<th>id</th>
			<th>名称</th>
			<th>价格</th>
			<th>类型</th>
			<th>数量</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${pd.list }" var="good">
			<tr>
				<td>${good.gid }</td>
				<td>${good.gname }</td>
				<td>${good.gtype }</td>
				<td>${good.gprice }</td>
				<td>${good.gnum }</td>
				<td>
					<a style="text-decoration:none" href="DeleteGood?gid=${good.gid }">删除
					<a style="text-decoration:none" href="goodsInfoServlet?gid=${good.gid }">查看
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6">
			当前${pd.getPageNow() }页/共${pd.getPageCount()} 页，每页 ${pd.pageSize }条，共 ${pd.rowCount }条记录
			<c:choose>
				<c:when test="${pd.getPageNow()>1 }">
					<a href="javascript:pageNows(1)">首页</a>&nbsp;&nbsp;
					<a href="javascript:pageNows(${pd.getPageNow()-1 })">上一页</a>&nbsp;&nbsp;
				</c:when>
				<c:otherwise>
					首页&nbsp;&nbsp;上一页
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${pd.getPageNow()<pd.getPageCount() }">
					<a href="javascript:pageNows(${pd.getPageNow()+1 })">下一页</a>&nbsp;&nbsp;
					<a href="javascript:pageNows(${pd.getPageCount() })">末页</a>&nbsp;&nbsp;
				</c:when>
				<c:otherwise>
					下一页&nbsp;&nbsp;末页
				</c:otherwise>
			</c:choose>
			
		</tr>
		<tr> 
			<input type="text" width="2" id="jumpPage" value="${pd.getPageNow() }" 
			 size=2>页<input type="button" value="跳转" onclick="jPage()"/>
		</tr>
	</table>
</body>
</html>