<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="propertyList.title"/></title>
    <meta name="menu" content="PropertyMenu"/>
</head>
<div class="col-sm-10">
    <h2><fmt:message key='propertyList.heading'/></h2>
 
    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/registering/propertyform'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a class="btn btn-default" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
 
    <display:table name="propertyList" class="table table-condensed table-striped table-hover" requestURI=""
                   id="propertyList" export="true" pagesize="25">
        <display:column property="id" sortable="true" href="propertyform" media="html"
            paramId="id" paramProperty="id" titleKey="property.id"/>
        <display:column property="id" media="csv excel xml pdf" titleKey="property.id"/>
        <display:column property="year" sortable="true" titleKey="property.year"/>
        <display:column property="repertory" sortable="true" titleKey="property.repertory"/>
        <display:column property="record.record" sortable="true" titleKey="property.record"/>
        <display:column property="keyValue" sortable="true" titleKey="property.key"/>
        <display:column property="propertyNumber" sortable="true" titleKey="property.propertyNumber"/>
        <display:column property="blockNumber" sortable="true" titleKey="property.blockNumber"/>
        <display:column property="cooperative" sortable="true" titleKey="property.cooperative"/>
        <display:column property="surface" sortable="true" titleKey="property.surface"/>
        <display:column property="parroquia.name" sortable="true" titleKey="property.parroquia"/>
        <display:column property="north" sortable="true" titleKey="property.north"/>
        <display:column property="south" sortable="true" titleKey="property.south"/>
        <display:column property="east" sortable="true" titleKey="property.east"/>
        <display:column property="west" sortable="true" titleKey="property.west"/>
        <display:column property="state.name" sortable="true" titleKey="property.state"/>
        <display:column property="amount" sortable="true" titleKey="property.amount"/>
        <display:column property="book.name" sortable="true" titleKey="property.book"/>
        <display:column property="salesPeople" sortable="true" titleKey="property.salesPeople"/>
        <display:column property="cancellationDate" sortable="true" titleKey="property.cancellationDate" decorator="org.onedevelopment.webapp.util.DisplaytagColumnDecoratorDate" />
        <display:setProperty name="paging.banner.item_name"><fmt:message key="propertyList.property"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="propertyList.properties"/></display:setProperty>
        <display:setProperty name="export.excel.filename"><fmt:message key="propertyList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="propertyList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="propertyList.title"/>.pdf</display:setProperty>
    </display:table>
</div>