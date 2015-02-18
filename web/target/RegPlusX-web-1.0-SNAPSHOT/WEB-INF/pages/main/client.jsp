<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="clientList.title"/></title>
    <meta name="menu" content="ClientMenu"/>
</head>
<div class="col-sm-10">
    <h2><fmt:message key='clientList.heading'/></h2>
 
    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/main/clientform'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a class="btn btn-default" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
 
    <display:table name="clientList" class="table table-condensed table-striped table-hover" requestURI=""
                   id="clientList" export="true" pagesize="25">
        <display:column property="id" sortable="true" href="clientform" media="html"
            paramId="id" paramProperty="id" titleKey="client.id"/>
        <display:column property="id" media="csv excel xml pdf" titleKey="client.id"/>
        <display:column property="name" sortable="true" titleKey="client.name"/>
        <display:column property="lastName" sortable="true" titleKey="client.lastName"/>
        <display:column property="address" sortable="true" titleKey="client.address"/>
        <display:column property="province.name" sortable="true" titleKey="client.provinceId"/>
        <display:column property="canton.name" sortable="true" titleKey="client.cantonId"/>
        <display:column property="parroquia.name" sortable="true" titleKey="client.parroquiaId"/>
        <display:setProperty name="paging.banner.item_name"><fmt:message key="clientList.clients"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="clientList.clients"/></display:setProperty>
        <display:setProperty name="export.excel.filename"><fmt:message key="clientList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="clientList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="clientList.title"/>.pdf</display:setProperty>
    </display:table>
</div>