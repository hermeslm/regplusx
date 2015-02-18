<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="bookList.title"/></title>
    <meta name="menu" content="BookMenu"/>
</head>
<div class="col-sm-10">
    <h2><fmt:message key='bookList.heading'/></h2>
 
    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/main/bookform'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a class="btn btn-default" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
 
    <display:table name="bookList" class="table table-condensed table-striped table-hover" requestURI=""
                   id="bookList" export="true" pagesize="25">
        <display:column property="id" sortable="true" href="bookform" media="html"
            paramId="id" paramProperty="id" titleKey="book.id"/>
        <display:column property="id" media="csv excel xml pdf" titleKey="book.id"/>
        <display:column property="name" sortable="true" titleKey="book.name"/>
        <display:column property="bookType.name" sortable="true" titleKey="book.bookTypeId"/>
        <display:setProperty name="paging.banner.item_name"><fmt:message key="bookList.book"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="bookList.books"/></display:setProperty>
        <display:setProperty name="export.excel.filename"><fmt:message key="bookList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="bookList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="bookList.title"/>.pdf</display:setProperty>
    </display:table>
</div>