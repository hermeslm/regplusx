<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="home.title"/></title>
    <meta name="menu" content="Home"/>
</head>
<body class="home">

<h2><fmt:message key="home.heading"/></h2>
<p><fmt:message key="home.message"/></p>

<ul class="glassList">
    <li>
        <a href="<c:url value='/userform'/>"><fmt:message key="menu.user"/></a>
    </li>
    <li>
        <a href="<c:url value='/fileupload'/>"><fmt:message key="menu.selectFile"/></a>
    </li>
    <li>
    	<a href="<c:url value="/main/province"/>"><fmt:message key="menu.viewProvince"/></a>
	</li>
	<li>
    	<a href="<c:url value="/main/canton"/>"><fmt:message key="menu.viewCanton"/></a>
	</li>
	<li>
    	<a href="<c:url value="/main/parroquia"/>"><fmt:message key="menu.viewParroquia"/></a>
	</li>
	<li>
    	<a href="<c:url value="/main/client"/>"><fmt:message key="menu.viewClient"/></a>
	</li>
	<li>
    	<a href="<c:url value="/main/area"/>"><fmt:message key="menu.viewArea"/></a>
	</li>
	<li>
    	<a href="<c:url value="/main/booktype"/>"><fmt:message key="menu.viewBookType"/></a>
	</li>
	<li>
    	<a href="<c:url value="/main/book"/>"><fmt:message key="menu.viewBook"/></a>
	</li>
	<li>
    	<a href="<c:url value="/main/volume"/>"><fmt:message key="menu.viewVolume"/></a>
	</li>
	<li>
    	<a href="<c:url value="/registering/recordtype"/>"><fmt:message key="menu.viewRecordType"/></a>
	</li>
	<li>
    	<a href="<c:url value="/registering/record"/>"><fmt:message key="menu.viewRecord"/></a>
	</li>
	<li>
    	<a href="<c:url value="/registering/campany"/>"><fmt:message key="menu.viewCompany"/></a>
	</li>
	<li>
    	<a href="<c:url value="/registering/repertory"/>"><fmt:message key="menu.viewRepertory"/></a>
	</li>
	<li>
    	<a href="<c:url value="/registering/tradeproperty"/>"><fmt:message key="menu.viewTradeProperty"/></a>
	</li>
</ul>
</body>
