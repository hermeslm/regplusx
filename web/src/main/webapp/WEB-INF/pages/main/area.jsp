<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="areaList.title"/></title>
    <meta name="menu" content="AreaMenu"/>
</head>
<div class="col-sm-10">
    <h2><fmt:message key='areaList.heading'/></h2>
 
    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/main/areaform'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a class="btn btn-default" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
 
    <display:table name="areaList" class="table table-condensed table-striped table-hover" requestURI=""
                   id="areaList" export="true" pagesize="25">
        <display:column property="id" sortable="true" href="areaform" media="html"
            paramId="id" paramProperty="id" titleKey="area.id"/>
        <display:column property="id" media="csv excel xml pdf" titleKey="area.id"/>
        <display:column property="name" sortable="true" titleKey="area.name"/>
        <display:setProperty name="paging.banner.item_name"><fmt:message key="areaList.area"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="areaList.areas"/></display:setProperty>
        <display:setProperty name="export.excel.filename"><fmt:message key="areaList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="areaList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="areaList.title"/>.pdf</display:setProperty>
    </display:table>
</div>