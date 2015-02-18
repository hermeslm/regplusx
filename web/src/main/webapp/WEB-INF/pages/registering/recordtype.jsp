<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="recordTypeList.title"/></title>
    <meta name="menu" content="RecordTypeMenu"/>
</head>
<div class="col-sm-10">
    <h2><fmt:message key='recordTypeList.heading'/></h2>
 
    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/registering/recordtypeform'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a class="btn btn-default" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
 
    <display:table name="recordTypeList" class="table table-condensed table-striped table-hover" requestURI=""
                   id="recordTypeList" export="true" pagesize="25">
        <display:column property="id" sortable="true" href="recordTypeform" media="html"
            paramId="id" paramProperty="id" titleKey="recordType.id"/>
        <display:column property="id" media="csv excel xml pdf" titleKey="recordType.id"/>
        <display:column property="description" sortable="true" titleKey="recordType.description"/>
        <display:column property="value" sortable="true" titleKey="recordType.value"/>
        <display:column property="percent" sortable="true" titleKey="recordType.percent"/>
        <display:column property="book.name" sortable="true" titleKey="recordType.book"/>
        <display:setProperty name="paging.banner.item_name"><fmt:message key="recordTypeList.recordType"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="recordTypeList.recordTypes"/></display:setProperty>
        <display:setProperty name="export.excel.filename"><fmt:message key="recordTypeList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="recordTypeList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="recordTypeList.title"/>.pdf</display:setProperty>
    </display:table>
</div>