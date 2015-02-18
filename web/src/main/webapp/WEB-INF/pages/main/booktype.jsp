<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="bookTypeList.title"/></title>
    <meta name="menu" content="BookTypeMenu"/>
</head>
<div class="col-sm-10">
    <h2><fmt:message key='bookTypeList.heading'/></h2>
 
    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/main/booktypeform'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a class="btn btn-default" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
 
    <display:table name="bookTypeList" class="table table-condensed table-striped table-hover" requestURI=""
                   id="bookTypeList" export="true" pagesize="25">
        <display:column property="id" sortable="true" href="booktypeform" media="html"
            paramId="id" paramProperty="id" titleKey="bookType.id"/>
        <display:column property="id" media="csv excel xml pdf" titleKey="bookType.id"/>
        <display:column property="name" sortable="true" titleKey="bookType.name"/>
        <display:setProperty name="paging.banner.item_name"><fmt:message key="bookTypeList.bookType"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="bookTypeList.bookTypes"/></display:setProperty>
        <display:setProperty name="export.excel.filename"><fmt:message key="bookTypeList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="bookTypeList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="bookTypeList.title"/>.pdf</display:setProperty>
    </display:table>
</div>