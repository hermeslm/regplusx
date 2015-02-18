<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="volumeList.title"/></title>
    <meta name="menu" content="VolumeMenu"/>
</head>
<div class="col-sm-10">
    <h2><fmt:message key='volumeList.heading'/></h2>
 
    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/main/volumeform'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a class="btn btn-default" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
 
    <display:table name="volumeList" class="table table-condensed table-striped table-hover" requestURI=""
                   id="volumeList" export="true" pagesize="25">
        <display:column property="id" sortable="true" href="volumeform" media="html"
            paramId="id" paramProperty="id" titleKey="volume.id"/>
        <display:column property="id" media="csv excel xml pdf" titleKey="volume.id"/>
        <display:column property="name" sortable="true" titleKey="volume.name"/>
        <display:column property="folioStart" sortable="true" titleKey="volume.folioStart"/>
        <display:column property="folioEnd" sortable="true" titleKey="volume.folioEnd"/>
        <display:setProperty name="paging.banner.item_name"><fmt:message key="volumeList.volume"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="volumeList.volumes"/></display:setProperty>
        <display:setProperty name="export.excel.filename"><fmt:message key="volumeList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="volumeList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="volumeList.title"/>.pdf</display:setProperty>
    </display:table>
</div>