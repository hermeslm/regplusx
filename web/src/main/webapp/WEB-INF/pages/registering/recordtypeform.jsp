<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="recordTypeDetail.title"/></title>
    <meta name="menu" content="RecordTypeMenu"/>
</head>
 
<div class="col-sm-3">
    <h2><fmt:message key='recordTypeDetail.heading'/></h2>
</div>
 
<div class="col-sm-7">
    <form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
    <form:form commandName="recordType" method="post" action="recordtypeform" id="recordTypeForm" cssClass="well" onsubmit="return validateRecordType(this)">
    <form:hidden path="id"/>
    <spring:bind path="recordType.description">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="recordType.description"/>
        <form:textarea path="description" id="details" rows="3" cssStyle="resize:none;" autofocus="true" cssClass="form-control"/>
        <form:errors path="description" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="recordType.value"/>
        <form:input path="value" id="repertory" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="value" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="recordType.percent"/>
        <form:input path="percent" id="recordType" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="percent" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="recordType.book"/>
        <form:select id="bookSelect" path="book.id" items="${bookList}" cssClass="form-control" itemValue="id" itemLabel="name" />
        <form:errors path="book" cssClass="help-inline"/>
    </div>
    <div class="form-group form-actions">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty recordType.id}">
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
<script type="text/javascript">
$(document).ready(function() {
	$('#recordTypeDate-container').datepicker({format: "<fmt:message key='calendar.format'/>", weekStart: "<fmt:message key='calendar.weekstart'/>", language: '${pageContext.request.locale.language}'});
	$('#notarizeDate-container').datepicker({format: "<fmt:message key='calendar.format'/>", weekStart: "<fmt:message key='calendar.weekstart'/>", language: '${pageContext.request.locale.language}'});
});
</script> 
   
<v:javascript formName="recordType" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>