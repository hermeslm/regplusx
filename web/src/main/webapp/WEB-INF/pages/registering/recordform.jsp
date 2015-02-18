<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="recordDetail.title"/></title>
    <meta name="menu" content="RecordMenu"/>
</head>
 
<div class="col-sm-3">
    <h2><fmt:message key='recordDetail.heading'/></h2>
</div>
 
<div class="col-sm-7">
    <form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
    <form:form commandName="record" method="post" action="recordform" id="recordForm" cssClass="well" onsubmit="return validateRecord(this)">
    <form:hidden path="id"/>
    <spring:bind path="record.year">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="record.year"/>
        <form:select path="year" items="${yearList}" cssClass="form-control" itemValue="id" itemLabel="name" />
        <form:errors path="year" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="record.repertory"/>
        <form:input path="repertory" id="repertory" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="repertory" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="record.record"/>
        <form:input path="record" id="record" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="record" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="record.recordDate"/>
		<div id="recordDate-container" class="input-group date">
			<form:input path="recordDate" id="recordDate" type="text" readonly="true" cssClass="form-control"/>
			<span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
		</div>
        <form:errors path="recordDate" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="record.afecta1"/>
        <form:input path="afecta1" id="afecta1" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="afecta1" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="record.afecta2"/>
        <form:input path="afecta2" id="afecta2" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="afecta2" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="record.notaryOffice"/>
        <form:input path="notaryOffice" id="notaryOffice" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="notaryOffice" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="record.details"/>
        <form:textarea path="details" id="details" rows="3" cssStyle="resize:none;" autofocus="true" cssClass="form-control"/>
        <form:errors path="details" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="record.notarizeDate"/>
        <div id="notarizeDate-container" class="input-group date">
			<form:input path="notarizeDate" id="notarizeDate" type="text" readonly="true" cssClass="form-control"/>
			<span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
		</div>
<%--         <form:input path="notarizeDate" id="notarizeDate" maxlength="50" autofocus="true" cssClass="form-control"/> --%>
        <form:errors path="notarizeDate" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="record.folio"/>
        <form:input path="folio" id="folio" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="folio" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="record.observations"/>
        <form:textarea path="observations" id="observations" rows="3" cssStyle="resize:none;" autofocus="true" cssClass="form-control"/>
        <form:errors path="observations" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="record.book"/>
        <form:select id="bookSelect" path="book.id" items="${bookList}" cssClass="form-control" itemValue="id" itemLabel="name" />
        <form:errors path="book" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="record.volume"/>
        <form:select id="volumeSelect" path="volume.id" items="${volumeList}" cssClass="form-control" itemValue="id" itemLabel="name" />
        <form:errors path="volume" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="record.state"/>
        <form:select id="stateSelect" path="state.id" items="${stateList}" cssClass="form-control" itemValue="id" itemLabel="name" />
        <form:errors path="state" cssClass="help-inline"/>
    </div>
    <div class="form-group form-actions">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty record.id}">
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
	$('#recordDate-container').datepicker({format: "<fmt:message key='calendar.format'/>", weekStart: "<fmt:message key='calendar.weekstart'/>", language: '${pageContext.request.locale.language}'});
	$('#notarizeDate-container').datepicker({format: "<fmt:message key='calendar.format'/>", weekStart: "<fmt:message key='calendar.weekstart'/>", language: '${pageContext.request.locale.language}'});
});
</script> 
   
<v:javascript formName="record" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>