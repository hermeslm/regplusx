<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="repertoryList.title"/></title>
    <meta name="menu" content="RepertoryMenu"/>
</head>
<div class="col-sm-10">
    <h2><fmt:message key='repertoryList.heading'/></h2>
 
    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/registering/repertoryform'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a class="btn btn-default" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
 
    <display:table name="repertoryList" class="table table-condensed table-striped table-hover" requestURI=""
                   id="repertoryList" export="true" pagesize="25">
        <display:column property="id" sortable="true" href="repertoryform" media="html"
            paramId="id" paramProperty="id" titleKey="repertory.id"/>
        <display:column property="id" media="csv excel xml pdf" titleKey="repertory.id"/>
        <display:column property="year" sortable="true" titleKey="repertory.year"/>
        <display:column property="repertory" sortable="true" titleKey="repertory.repertory"/>
        <display:column property="client.name" sortable="true" titleKey="repertory.client"/>
        <display:column property="reasonAct" sortable="true" titleKey="repertory.reasonAct"/>
        <display:column property="nameAct" sortable="true" titleKey="repertory.nameAct"/>
        <display:column property="record.record" sortable="true" titleKey="repertory.record"/>
        <display:column property="observations" sortable="true" titleKey="repertory.observations"/>
        <display:column property="invoice" sortable="true" titleKey="repertory.invoice"/>
        <display:setProperty name="paging.banner.item_name"><fmt:message key="repertoryList.repertory"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="repertoryList.repertorys"/></display:setProperty>
        <display:setProperty name="export.excel.filename"><fmt:message key="repertoryList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="repertoryList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="repertoryList.title"/>.pdf</display:setProperty>
    </display:table>
</div>