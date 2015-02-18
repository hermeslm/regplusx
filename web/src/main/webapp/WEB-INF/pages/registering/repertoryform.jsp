<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="repertoryDetail.title"/></title>
    <meta name="menu" content="RepertoryMenu"/>
</head>
 
<div class="col-sm-3">
    <h2><fmt:message key='repertoryDetail.heading'/></h2>
</div>
 
<div class="col-sm-7">
    <form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
    <div id="error-container"></div>
    <form:form commandName="repertory" method="post" action="repertoryform" id="repertoryForm" cssClass="well" onsubmit="return validateRepertory(this)">
    <form:hidden path="id"/>
    <spring:bind path="repertory.id">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
    	<appfuse:label styleClass="control-label" key="repertory.year"/>
        <form:select path="year" items="${yearList}" cssClass="form-control" itemValue="id" itemLabel="name" />
        <form:errors path="year" cssClass="help-inline"/>
         <appfuse:label styleClass="control-label" key="repertory.day"/>
        <form:input path="day" id="name" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="day" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="repertory.repertory"/>
        <form:input path="repertory" id="name" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="repertory" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="repertory.client"/>
        <form:select path="client.id" items="${clientList}" cssClass="form-control" itemValue="id" itemLabel="name" />
        <form:errors path="client.id" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="repertory.reasonAct"/>
        <form:input path="reasonAct" id="agent" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="reasonAct" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="repertory.nameAct"/>
        <form:input path="nameAct" id="nameAct" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="nameAct" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="repertory.record"/>
        <form:select path="record.id" items="${recordList}" cssClass="form-control" itemValue="id" itemLabel="record" />
        <form:errors path="record.id" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="repertory.observations"/>
        <form:input path="observations" id="observations" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="observations" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="repertory.invoice"/>
        <form:input path="invoice" id="invoice" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="invoice" cssClass="help-inline"/>
    </div>
    <div class="form-group form-actions">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty repertory.id}">
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
	$('#openingDate-container').datepicker({format: "<fmt:message key='calendar.format'/>", weekStart: "<fmt:message key='calendar.weekstart'/>", language: '${pageContext.request.locale.language}'});
	
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
   
<v:javascript formName="repertory" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>