<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="provinceList.title"/></title>
    <meta name="menu" content="ProvinceMenu"/>
</head>
<div class="col-sm-10">
    <h2><fmt:message key='provinceList.heading'/></h2>
 
    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/main/provinceform'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a class="btn btn-default" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
 
    <display:table name="provinceList" class="table table-condensed table-striped table-hover" requestURI=""
                   id="provinceList" export="true" pagesize="25">
        <display:column property="id" sortable="true" href="provinceform" media="html"
            paramId="id" paramProperty="id" titleKey="province.id"/>
        <display:column property="id" media="csv excel xml pdf" titleKey="province.id"/>
        <display:column property="name" sortable="true" titleKey="province.name"/>
        <display:setProperty name="paging.banner.item_name"><fmt:message key="provinceList.province"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="provinceList.provinces"/></display:setProperty>
        <display:setProperty name="export.excel.filename"><fmt:message key="provinceList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="provinceList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="provinceList.title"/>.pdf</display:setProperty>
    </display:table>
</div>