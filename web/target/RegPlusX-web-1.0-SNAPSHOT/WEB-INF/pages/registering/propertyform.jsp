<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="propertyDetail.title"/></title>
    <meta name="menu" content="PropertyMenu"/>
</head>
 
<div class="col-sm-3">
    <h2><fmt:message key='propertyDetail.heading'/></h2>
</div>
 
<div class="col-sm-7">
    <form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
    <div id="error-container"></div>
    <form:form commandName="property" method="post" action="propertyform" id="propertyForm" cssClass="well" onsubmit="return validateProperty(this)">
    <form:hidden path="id"/>
    <spring:bind path="property.id">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="property.year"/>
        <form:select path="year" items="${yearList}" cssClass="form-control" itemValue="id" itemLabel="name" />
        <form:errors path="year" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="property.repertory"/>
        <form:input path="repertory" id="repertory" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="repertory" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="property.record"/>
        <form:select path="record.id" items="${recordList}" cssClass="form-control" itemValue="id" itemLabel="record" />
        <form:errors path="record" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="property.key"/>
        <form:input path="keyValue" id="key" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="keyValue" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="property.propertyNumber"/>
        <form:input path="propertyNumber" id="propertyNumber" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="propertyNumber" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="property.blockNumber"/>
        <form:input path="blockNumber" id="blockNumber" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="blockNumber" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="property.cooperative"/>
        <form:input path="cooperative" id="cooperative" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="cooperative" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="property.surface"/>
        <form:input path="surface" id="surface" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="surface" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="property.parroquia"/>
        <form:select path="parroquia.id" items="${parroquiaList}" cssClass="form-control" itemValue="id" itemLabel="name" />
        <form:errors path="parroquia" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="property.north"/>
        <form:input path="north" id="north" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="north" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="property.south"/>
        <form:input path="south" id="south" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="south" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="property.east"/>
        <form:input path="east" id="east" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="east" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="property.west"/>
        <form:input path="west" id="west" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="west" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="property.state"/>
        <form:select path="state.id" items="${stateList}" cssClass="form-control" itemValue="id" itemLabel="name" />
        <form:errors path="state" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="property.amount"/>
        <form:input path="amount" id="amount" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="amount" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="property.book"/>
        <form:select path="book.id" items="${bookList}" cssClass="form-control" itemValue="id" itemLabel="name" />
        <form:errors path="book" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="property.salesPeople"/>
        <form:input path="salesPeople" id="salesPeople" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="salesPeople" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="property.cancellationDate"/>
		<div id="cancellationDate-container" class="input-group date">
			<form:input path="cancellationDate" id="cancellationDate" type="text" readonly="true" cssClass="form-control"/>
			<span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
		</div>
        <form:errors path="cancellationDate" cssClass="help-inline"/>
    </div>
    <div class="form-group form-actions">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty property.id}">
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
	$('#cancellationDate-container').datepicker({format: "<fmt:message key='calendar.format'/>", weekStart: "<fmt:message key='calendar.weekstart'/>", language: '${pageContext.request.locale.language}'});
	
	-//called when key is pressed in textbox
	$("#repertory").keypress(function (e) {
	   //if the letter is not digit then display error and don't type anything
	   if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
	      //display error message
	      $("#error-container").html('<div class="alert alert-danger alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Error!</strong> Only allowed digits.</div>');       
	      return false;
	  }
	 });
	
	$("#repertory" ).blur(function() {
		//Validate if has not invalid Digits
		$("#error-container").html('');
	});
	
	
});
</script> 
   
<v:javascript formName="property" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>