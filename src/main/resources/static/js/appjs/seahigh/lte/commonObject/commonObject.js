
var prefix = "/lte/commonObject"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
					//	showRefresh : true,
					//	showToggle : true,
					//	showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						//search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset
					           // name:$('#searchName').val(),
					           // username:$('#searchName').val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
								{
									checkbox : true
								},
																{
									field : 'id', 
									title : '' 
								},
																{
									field : 'objectType', 
									title : '对象类型' 
								},
																{
									field : 'objectCode', 
									title : '对象编码' 
								},
																{
									field : 'objectName', 
									title : '对象名称' 
								},
																{
									field : 'objectDefineId', 
									title : '对象定义ID' 
								},
																{
									field : 'objectArea', 
									title : '对象名称' 
								},
																{
									field : 'objectDistrict', 
									title : '对象名称' 
								},
																{
									field : 'f1', 
									title : '通用字段' 
								},
																{
									field : 'f2', 
									title : '通用字段' 
								},
																{
									field : 'f3', 
									title : '通用字段' 
								},
																{
									field : 'f4', 
									title : '通用字段' 
								},
																{
									field : 'f5', 
									title : '通用字段' 
								},
																{
									field : 'f6', 
									title : '通用字段' 
								},
																{
									field : 'f7', 
									title : '通用字段' 
								},
																{
									field : 'f8', 
									title : '通用字段' 
								},
																{
									field : 'f9', 
									title : '通用字段' 
								},
																{
									field : 'f10', 
									title : '通用字段' 
								},
																{
									field : 'f11', 
									title : '通用字段' 
								},
																{
									field : 'f12', 
									title : '通用字段' 
								},
																{
									field : 'f13', 
									title : '通用字段' 
								},
																{
									field : 'f14', 
									title : '通用字段' 
								},
																{
									field : 'f15', 
									title : '通用字段' 
								},
																{
									field : 'f16', 
									title : '通用字段' 
								},
																{
									field : 'f17', 
									title : '通用字段' 
								},
																{
									field : 'f18', 
									title : '通用字段' 
								},
																{
									field : 'f19', 
									title : '通用字段' 
								},
																{
									field : 'f20', 
									title : '通用字段' 
								},
																{
									field : 'f21', 
									title : '通用字段' 
								},
																{
									field : 'f22', 
									title : '通用字段' 
								},
																{
									field : 'f23', 
									title : '通用字段' 
								},
																{
									field : 'f24', 
									title : '通用字段' 
								},
																{
									field : 'f25', 
									title : '通用字段' 
								},
																{
									field : 'f26', 
									title : '通用字段' 
								},
																{
									field : 'f27', 
									title : '通用字段' 
								},
																{
									field : 'f28', 
									title : '通用字段' 
								},
																{
									field : 'f29', 
									title : '通用字段' 
								},
																{
									field : 'f30', 
									title : '通用字段' 
								},
																{
									field : 'f31', 
									title : '通用字段' 
								},
																{
									field : 'f32', 
									title : '通用字段' 
								},
																{
									field : 'f33', 
									title : '通用字段' 
								},
																{
									field : 'f34', 
									title : '通用字段' 
								},
																{
									field : 'f35', 
									title : '通用字段' 
								},
																{
									field : 'f36', 
									title : '通用字段' 
								},
																{
									field : 'f37', 
									title : '通用字段' 
								},
																{
									field : 'f38', 
									title : '通用字段' 
								},
																{
									field : 'f39', 
									title : '通用字段' 
								},
																{
									field : 'f40', 
									title : '通用字段' 
								},
																{
									field : 'f41', 
									title : '通用字段' 
								},
																{
									field : 'f42', 
									title : '通用字段' 
								},
																{
									field : 'f43', 
									title : '通用字段' 
								},
																{
									field : 'f44', 
									title : '通用字段' 
								},
																{
									field : 'f45', 
									title : '通用字段' 
								},
																{
									field : 'f46', 
									title : '通用字段' 
								},
																{
									field : 'f47', 
									title : '通用字段' 
								},
																{
									field : 'f48', 
									title : '通用字段' 
								},
																{
									field : 'f49', 
									title : '通用字段' 
								},
																{
									field : 'f50', 
									title : '通用字段' 
								},
																{
									field : 'f51', 
									title : '通用字段' 
								},
																{
									field : 'f52', 
									title : '通用字段' 
								},
																{
									field : 'f53', 
									title : '通用字段' 
								},
																{
									field : 'f54', 
									title : '通用字段' 
								},
																{
									field : 'f55', 
									title : '通用字段' 
								},
																{
									field : 'f56', 
									title : '通用字段' 
								},
																{
									field : 'f57', 
									title : '通用字段' 
								},
																{
									field : 'f58', 
									title : '通用字段' 
								},
																{
									field : 'f59', 
									title : '通用字段' 
								},
																{
									field : 'f60', 
									title : '通用字段' 
								},
																{
									field : 'f61', 
									title : '通用字段' 
								},
																{
									field : 'f62', 
									title : '通用字段' 
								},
																{
									field : 'f63', 
									title : '通用字段' 
								},
																{
									field : 'f64', 
									title : '通用字段' 
								},
																{
									field : 'f65', 
									title : '通用字段' 
								},
																{
									field : 'f66', 
									title : '通用字段' 
								},
																{
									field : 'f67', 
									title : '通用字段' 
								},
																{
									field : 'f68', 
									title : '通用字段' 
								},
																{
									field : 'f69', 
									title : '通用字段' 
								},
																{
									field : 'f70', 
									title : '通用字段' 
								},
																{
									field : 'f71', 
									title : '通用字段' 
								},
																{
									field : 'f72', 
									title : '通用字段' 
								},
																{
									field : 'f73', 
									title : '通用字段' 
								},
																{
									field : 'f74', 
									title : '通用字段' 
								},
																{
									field : 'f75', 
									title : '通用字段' 
								},
																{
									field : 'f76', 
									title : '通用字段' 
								},
																{
									field : 'f77', 
									title : '通用字段' 
								},
																{
									field : 'f78', 
									title : '通用字段' 
								},
																{
									field : 'f79', 
									title : '通用字段' 
								},
																{
									field : 'f80', 
									title : '通用字段' 
								},
																{
									field : 'f81', 
									title : '通用字段' 
								},
																{
									field : 'f82', 
									title : '通用字段' 
								},
																{
									field : 'f83', 
									title : '通用字段' 
								},
																{
									field : 'f84', 
									title : '通用字段' 
								},
																{
									field : 'f85', 
									title : '通用字段' 
								},
																{
									field : 'f86', 
									title : '通用字段' 
								},
																{
									field : 'f87', 
									title : '通用字段' 
								},
																{
									field : 'f88', 
									title : '通用字段' 
								},
																{
									field : 'f89', 
									title : '通用字段' 
								},
																{
									field : 'f90', 
									title : '通用字段' 
								},
																{
									field : 'f91', 
									title : '通用字段' 
								},
																{
									field : 'f92', 
									title : '通用字段' 
								},
																{
									field : 'f93', 
									title : '通用字段' 
								},
																{
									field : 'f94', 
									title : '通用字段' 
								},
																{
									field : 'f95', 
									title : '通用字段' 
								},
																{
									field : 'f96', 
									title : '通用字段' 
								},
																{
									field : 'f97', 
									title : '通用字段' 
								},
																{
									field : 'f98', 
									title : '通用字段' 
								},
																{
									field : 'f99', 
									title : '通用字段' 
								},
																{
									field : 'f100', 
									title : '通用字段' 
								},
																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ row.id
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ row.id
												+ '\')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
												+ row.id
												+ '\')"><i class="fa fa-key"></i></a> ';
										return e + d ;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add' // iframe的url
	});
}
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}

function resetPwd(id) {
}
function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['id'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});
}