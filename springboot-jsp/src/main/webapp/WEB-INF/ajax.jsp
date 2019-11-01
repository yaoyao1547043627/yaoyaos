<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"  src="/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
//js解释执行的语言 让页面加载完成之后执行
  $(function(){
//$.get(),$.post(),$.getJSON(),$.load()
/**
 * get请求
 参数说明：
 url:异步请求的地址
 data:页面传递给后台服务器的数据 一般以key:value格式传递
 callback：回调函数  请求执行成功之后
 type:服务器返回的数据类型text/json/html
 */
  $.ajax{
   type:"get",
   url:"/ajaxFindUser",
   data:"id=53&name=yangyang",
   sucess:function(result){
   alert("实现ajax请求!!!")
	   }
	 } 
	 alert("ajax开始调用!!!")
   $.post("/ajaxFindUser",{id:100},function(result,user){
	   alert("ajax请求成功")
	   console.log(result);
	  // doFind(result);
	   },"json")
	  });
  function doFind(result){
	  var tr=null;
	  $(result).each(function(index){
         var user = result[index];
          var id=user.id;
          var name=user.name;
          var age=user.age;
          var sex = user.sex;
          tr += "<tr align='center'><td>"+id+"</td><td>"+name+"</td><td>"+
          age+"</td><td>"+sex+"</td></tr>"
		  })
		//在table标签中添加数据
			$("#tttt").append(tr);
 }
</script>
</head>
<body>
<table border="1px" width="65%" align="center" id="tttt">
		<tr>
			<td colspan="6" align="center"><h3>学生信息</h3></td>
		</tr>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th></th>
		</tr>
	</table>
</body>
</html>