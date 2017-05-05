<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>二氧化碳管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/air/tbCO2/">二氧化碳列表</a></li>
		<shiro:hasPermission name="air:tbCO2:edit"><li><a href="${ctx}/air/tbCO2/form">二氧化碳添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tbCO2" action="${ctx}/air/tbCO2/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>CO2浓度</th>
				<shiro:hasPermission name="air:tbCO2:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tbCO2">
			<tr>
				<td><a href="${ctx}/air/tbCO2/form?id=${tbCO2.id}">
					${tbCO2.CO2}
				</a></td>
				<shiro:hasPermission name="air:tbCO2:edit"><td>
    				<a href="${ctx}/air/tbCO2/form?id=${tbCO2.id}">修改</a>
					<a href="${ctx}/air/tbCO2/delete?id=${tbCO2.id}" onclick="return confirmx('确认要删除该二氧化碳吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>