<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="tradePropertyList.title"/></title>
    <meta name="menu" content="TradePropertyMenu"/>
</head>
<div class="col-sm-10">
    <h2><fmt:message key='tradePropertyList.heading'/></h2>
 
    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/registering/tradepropertyform'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a class="btn btn-default" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
 
    <display:table name="tradePropertyList" class="table table-condensed table-striped table-hover" requestURI=""
                   id="tradePropertyList" export="true" pagesize="25">
        <display:column property="id" sortable="true" href="tradePropertyform" media="html"
            paramId="id" paramProperty="id" titleKey="tradeProperty.id"/>
        <display:column property="id" media="csv excel xml pdf" titleKey="tradeProperty.id"/>
        <display:column property="inscriptionDate" sortable="true" titleKey="tradeProperty.inscriptionDate" decorator="org.onedevelopment.webapp.util.DisplaytagColumnDecoratorDate"/>
        <display:column property="inscriptionNumber" sortable="true" titleKey="tradeProperty.inscriptionNumber"/>
        <display:column property="agreementType.name" sortable="true" titleKey="tradeProperty.agreementType"/>
        <display:column property="businessName" sortable="true" titleKey="tradeProperty.businessName"/>
        <display:column property="purchaserType.name" sortable="true" titleKey="tradeProperty.purchaserType"/>
        <display:column property="chassis" sortable="true" titleKey="tradeProperty.chassis"/>
        <display:column property="motor" sortable="true" titleKey="tradeProperty.motor"/>
        <display:column property="brand" sortable="true" titleKey="tradeProperty.brand"/>
        <display:column property="model" sortable="true" titleKey="tradeProperty.model"/>
        <display:column property="manufactureDate" sortable="true" titleKey="tradeProperty.manufactureDate"/>
        <display:column property="registrationNumber" sortable="true" titleKey="tradeProperty.registrationNumber"/>
        <display:column property="location" sortable="true" titleKey="tradeProperty.location"/>
        <display:column property="lastModificationDate" sortable="true" titleKey="tradeProperty.lastModificationDate" decorator="org.onedevelopment.webapp.util.DisplaytagColumnDecoratorDate"/>
        <display:column property="identification" sortable="true" titleKey="tradeProperty.identification"/>
        <display:column property="state.name" sortable="true" titleKey="tradeProperty.state"/>
        <display:column property="judgedLetter" sortable="true" titleKey="tradeProperty.judgedLetter"/>
        <display:column property="agent" sortable="true" titleKey="tradeProperty.agent"/>
        <display:column property="contractDate" sortable="true" titleKey="tradeProperty.contractDate" decorator="org.onedevelopment.webapp.util.DisplaytagColumnDecoratorDate"/>
        <display:column property="cancellationDate" sortable="true" titleKey="tradeProperty.cancellationDate" decorator="org.onedevelopment.webapp.util.DisplaytagColumnDecoratorDate"/>
        <display:setProperty name="paging.banner.item_name"><fmt:message key="tradePropertyList.tradeProperty"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="tradePropertyList.tradeProperties"/></display:setProperty>
        <display:setProperty name="export.excel.filename"><fmt:message key="tradePropertyList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="tradePropertyList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="tradePropertyList.title"/>.pdf</display:setProperty>
    </display:table>
</div>