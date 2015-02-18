<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="tradePropertyDetail.title"/></title>
    <meta name="menu" content="TradePropertyMenu"/>
</head>
 
<div class="col-sm-3">
    <h2><fmt:message key='tradePropertyDetail.heading'/></h2>
</div>
 
<div class="col-sm-7">
    <form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
    <div id="error-container"></div>
    <form:form commandName="tradeProperty" method="post" action="tradePropertyform" id="tradePropertyForm" cssClass="well" onsubmit="return validateTradeProperty(this)">
    <form:hidden path="id"/>
    <spring:bind path="tradeProperty.id">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
    	<div id="inscriptionDate-container" class="input-group date">
			<form:input path="inscriptionDate" id="inscriptionDate" type="text" readonly="true" cssClass="form-control"/>
			<span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
		</div>
        <appfuse:label styleClass="control-label" key="tradeProperty.inscriptionNumber"/>
        <form:input path="inscriptionNumber" id="inscriptionNumber" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="inscriptionNumber" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="record.agreementType"/>
        <form:select path="agreementType" items="${agreementTypeList}" cssClass="form-control" itemValue="id" itemLabel="name" />
        <form:errors path="agreementType" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="tradeProperty.businessName"/>
        <form:input path="businessName" id="businessName" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="businessName" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="tradeProperty.purchaserType"/>
        <form:select path="purchaserType" items="${purchaserTypeList}" cssClass="form-control" itemValue="id" itemLabel="name" />
        <form:errors path="purchaserType" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="tradeProperty.chassis"/>
        <form:input path="chassis" id="chassis" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="chassis" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="tradeProperty.motor"/>
        <form:input path="motor" id="motor" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="motor" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="tradeProperty.brand"/>
        <form:input path="brand" id="brand" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="brand" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="tradeProperty.model"/>
        <form:input path="model" id="model" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="model" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="tradeProperty.manufactureDate"/>
		<div id="manufactureDate-container" class="input-group date">
			<form:input path="manufactureDate" id="manufactureDate" type="text" readonly="true" cssClass="form-control"/>
			<span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
		</div>
		<form:errors path="manufactureDate" cssClass="help-inline"/>
		<appfuse:label styleClass="control-label" key="tradeProperty.registrationNumber"/>
        <form:input path="registrationNumber" id="registrationNumber" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="registrationNumber" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="tradeProperty.location"/>
        <form:input path="location" id="location" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="location" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="tradeProperty.lastModificationDate"/>
		<div id="lastModificationDate-container" class="input-group date">
			<form:input path="lastModificationDate" id="lastModificationDate" type="text" readonly="true" cssClass="form-control"/>
			<span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
		</div>
		<form:errors path="lastModificationDate" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="tradeProperty.identification"/>
        <form:input path="identification" id="identification" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="identification" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="record.state"/>
        <form:select path="state" items="${stateList}" cssClass="form-control" itemValue="id" itemLabel="name" />
        <form:errors path="state" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="tradeProperty.judgedLetter"/>
        <form:input path="judgedLetter" id="judgedLetter" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="judgedLetter" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="tradeProperty.agent"/>
        <form:input path="agent" id="agent" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="agent" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="tradeProperty.contractDate"/>
		<div id="contractDate-container" class="input-group date">
			<form:input path="contractDate" id="contractDate" type="text" readonly="true" cssClass="form-control"/>
			<span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
		</div>
		<form:errors path="contractDate" cssClass="help-inline"/>
		<appfuse:label styleClass="control-label" key="tradeProperty.cancellationDate"/>
		<div id="cancellationDate-container" class="input-group date">
			<form:input path="cancellationDate" id="cancellationDate" type="text" readonly="true" cssClass="form-control"/>
			<span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
		</div>
		<form:errors path="lastModificationDate" cssClass="help-inline"/>
    </div>
    <div class="form-group form-actions">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty tradeProperty.id}">
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
	$('#inscriptionDate-container').datepicker({format: "<fmt:message key='calendar.format'/>", weekStart: "<fmt:message key='calendar.weekstart'/>", language: '${pageContext.request.locale.language}'});
	$('#lastModificationDate-container').datepicker({format: "<fmt:message key='calendar.format'/>", weekStart: "<fmt:message key='calendar.weekstart'/>", language: '${pageContext.request.locale.language}'});
	$('#contractDate-container').datepicker({format: "<fmt:message key='calendar.format'/>", weekStart: "<fmt:message key='calendar.weekstart'/>", language: '${pageContext.request.locale.language}'});
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
   
<v:javascript formName="tradeProperty" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>