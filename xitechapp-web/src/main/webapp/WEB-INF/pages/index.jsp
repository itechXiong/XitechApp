<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>权限管理系统</title>

    <link href="${basePath}/resources/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/checkbix/css/checkbix.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/css/login.css" rel="stylesheet"/>
</head>
<body>
<div id="login-window">
    success;
	<shiro:guest>
		hi guest
		
	</shiro:guest>
	<shiro:hasRole name="test"> 
		<div>
		<a href="#">Administer the system</a> ss
		</div>
	</shiro:hasRole>
</div>

<%-- <shiro:hasRole name="test"> 
<div>
<a href="#">Administer the system</a> ss
</div>
</shiro:hasRole> --%>
<a href="#" onclick="getDataFromServer(); return false;">Retrieve test data</a><br/>

<script src="${basePath}/resources/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/resources/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${basePath}/resources/plugins/waves-0.7.5/waves.min.js"></script>
<script src="${basePath}/resources/plugins/checkbix/js/checkbix.min.js"></script>
<%-- <script type='text/javascript' src='${basePath}/dwr/engine.js'></script>
<script type='text/javascript' src='${basePath}/dwr/util.js'></script>
<script type='text/javascript' src='${basePath}/dwr/interface/dwrService.js'></script> --%>
<script>var BASE_PATH = '${basePath}';</script>
<script>var BACK_URL = '${param.backurl}';</script>
<!-- <script>
function getDataFromServer() {
	dwrService.getDwrUser({
  	callback: getDataFromServerCallBack
  });
}

function getDataFromServerCallBack(dataFromServer) {
  //alert(dwr.util.toDescriptiveString(dataFromServer, 3));
  alert(dataFromServer);
  alert(dataFromServer.userName);
  alert(dataFromServer.userPwd);
}
dwrService.getDwrUser(function(data){
	alert(data.userName);
	alert(data.userPwd);
});
</script>
 -->
 


</body>
</html>
