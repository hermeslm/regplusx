<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="cantonList.title"/></title>
    <meta name="menu" content="CantonMenu"/>
</head>
<div class="col-sm-10">
    <h2><fmt:message key='cantonList.heading'/></h2>
 
    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/cantonform'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a class="btn btn-default" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
 
    <display:table name="cantonList" class="table table-condensed table-striped table-hover" requestURI=""
                   id="cantonList" export="true" pagesize="25">
        <display:column property="id" sortable="true" href="cantonform" media="html"
            paramId="id" paramProperty="id" titleKey="canton.id"/>
        <display:column property="id" media="csv excel xml pdf" titleKey="canton.id"/>
        <display:column property="name" sortable="true" titleKey="canton.name"/>
        <display:column property="province.name" sortable="true" titleKey="canton.provinceId"/>
        <display:setProperty name="paging.banner.item_name"><fmt:message key="cantonList.cantons"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="cantonList.cantons"/></display:setProperty>
        <display:setProperty name="export.excel.filename"><fmt:message key="cantonList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="cantonList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="cantonList.title"/>.pdf</display:setProperty>
    </display:table>
</div>