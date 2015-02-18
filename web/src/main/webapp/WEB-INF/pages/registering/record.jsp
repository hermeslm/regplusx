<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="recordList.title"/></title>
    <meta name="menu" content="RecordMenu"/>
</head>
<div class="col-sm-10">
    <h2><fmt:message key='recordList.heading'/></h2>
 
    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/registering/recordform'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a class="btn btn-default" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
 
    <display:table name="recordList" class="table table-condensed table-striped table-hover" requestURI=""
                   id="recordList" export="true" pagesize="25">
        <display:column property="id" sortable="true" href="recordform" media="html"
            paramId="id" paramProperty="id" titleKey="record.id"/>
        <display:column property="id" media="csv excel xml pdf" titleKey="record.id"/>
        <display:column property="year" sortable="true" titleKey="record.year"/>
        <display:column property="repertory" sortable="true" titleKey="record.repertory"/>
        <display:column property="record" sortable="true" titleKey="record.record"/>
        <display:column property="recordDate" sortable="true" titleKey="record.recordDate" decorator="org.onedevelopment.webapp.util.DisplaytagColumnDecoratorDate"/>
        <display:column property="afecta1" sortable="true" titleKey="record.afecta1"/>
        <display:column property="afecta2" sortable="true" titleKey="record.afecta2"/>
        <display:column property="notaryOffice" sortable="true" titleKey="record.notaryOffice"/>
<%--         <display:column property="details" sortable="true" titleKey="record.details"/> --%>
        <display:column property="notarizeDate" sortable="true" titleKey="record.notarizeDate" decorator="org.onedevelopment.webapp.util.DisplaytagColumnDecoratorDate"/>
        <display:column property="folio" sortable="true" titleKey="record.folio"/>
<%--         <display:column property="observations" sortable="true" titleKey="record.observations"/> --%>
        <display:column property="book.name" sortable="true" titleKey="record.book"/>
        <display:column property="volume.name" sortable="true" titleKey="record.volume"/>
        <display:column property="state.name" sortable="true" titleKey="record.state"/>
        <display:setProperty name="paging.banner.item_name"><fmt:message key="recordList.record"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="recordList.records"/></display:setProperty>
        <display:setProperty name="export.excel.filename"><fmt:message key="recordList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="recordList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="recordList.title"/>.pdf</display:setProperty>
    </display:table>
</div>