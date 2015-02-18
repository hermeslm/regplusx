<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="volumeDetail.title"/></title>
    <meta name="menu" content="VolumeMenu"/>
</head>
 
<div class="col-sm-3">
    <h2><fmt:message key='volumeDetail.heading'/></h2>
</div>
 
<div class="col-sm-7">
    <form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
    <form:form commandName="volume" method="post" action="volumeform" id="volumeForm" cssClass="well" onsubmit="return validateVolume(this)">
    <form:hidden path="id"/>
    <spring:bind path="volume.name">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="volume.name"/>
        <form:input path="name" id="name" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="name" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="volume.folioStart"/>
        <form:input path="folioStart" id="name" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="folioStart" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="volume.folioEnd"/>
        <form:input path="folioEnd" id="name" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="folioEnd" cssClass="help-inline"/>
    </div>
    <div class="form-group form-actions">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty volume.id}">
          <button type="submit" class="btn btn-default" name="delete" onclick="bCancel=true;return confirmMessage(msgDelConfirm)">
              <i class="icon-trash"></i> <fmt:message key="button.delete"/>
          </button>
        </c:if>
        <button type="submit" class="btn btn-default" name="cancel" onclick="bCancel=true">
            <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
        </button>
    </div>
    </form:form>
</div>
 
<v:javascript formName="volume" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>