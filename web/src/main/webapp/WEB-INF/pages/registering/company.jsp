<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="companyList.title"/></title>
    <meta name="menu" content="CompanyMenu"/>
</head>
<div class="col-sm-10">
    <h2><fmt:message key='companyList.heading'/></h2>
 
    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/registering/companyform'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a class="btn btn-default" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
 
    <display:table name="companyList" class="table table-condensed table-striped table-hover" requestURI=""
                   id="companyList" export="true" pagesize="25">
        <display:column property="id" sortable="true" href="companyform" media="html"
            paramId="id" paramProperty="id" titleKey="company.id"/>
        <display:column property="id" media="csv excel xml pdf" titleKey="company.id"/>
        <display:column property="name" sortable="true" titleKey="company.name"/>
        <display:column property="repertory" sortable="true" titleKey="company.repertory"/>
        <display:column property="record" sortable="true" titleKey="company.record"/>
        <display:column property="year" sortable="true" titleKey="company.year"/>
        <display:column property="agent" sortable="true" titleKey="company.agent"/>
        <display:column property="openingDate" sortable="true" titleKey="company.openingDate" decorator="org.onedevelopment.webapp.util.DisplaytagColumnDecoratorDate"/>
        <display:column property="duration" sortable="true" titleKey="company.duration"/>
        <display:column property="ruc" sortable="true" titleKey="company.ruc"/>
        <display:setProperty name="paging.banner.item_name"><fmt:message key="companyList.company"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="companyList.companys"/></display:setProperty>
        <display:setProperty name="export.excel.filename"><fmt:message key="companyList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="companyList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="companyList.title"/>.pdf</display:setProperty>
    </display:table>
</div>