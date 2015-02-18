<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="companyDetail.title"/></title>
    <meta name="menu" content="CompanyMenu"/>
</head>
 
<div class="col-sm-3">
    <h2><fmt:message key='companyDetail.heading'/></h2>
</div>
 
<div class="col-sm-7">
    <form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
    <div id="error-container"></div>
    <form:form commandName="company" method="post" action="companyform" id="companyForm" cssClass="well" onsubmit="return validateCompany(this)">
    <form:hidden path="id"/>
    <spring:bind path="company.id">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="company.name"/>
        <form:input path="name" id="name" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="name" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="company.repertory"/>
        <form:input path="repertory" id="repertory" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="repertory" cssClass="help-inline"/>
<%--         <appfuse:label styleClass="control-label" key="company.record"/> --%>
<%--         <form:input path="record" id="record" maxlength="50" autofocus="true" cssClass="form-control"/> --%>
<%--         <form:errors path="record" cssClass="help-inline"/> --%>
        <appfuse:label styleClass="control-label" key="company.year"/>
        <form:select path="year" items="${yearList}" cssClass="form-control" itemValue="id" itemLabel="name" />
        <form:errors path="year" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="company.agent"/>
        <form:input path="agent" id="agent" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="agent" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="company.openingDate"/>
		<div id="openingDate-container" class="input-group date">
			<form:input path="openingDate" id="openingDate" type="text" readonly="true" cssClass="form-control"/>
			<span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
		</div>
        <form:errors path="openingDate" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="company.duration"/>
        <form:input path="duration" id="duration" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="duration" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="company.resolution"/>
        <form:input path="resolution" id="resolution" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="resolution" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="company.ruc"/>
        <form:input path="ruc" id="ruc" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="ruc" cssClass="help-inline"/>
    </div>
    <div class="form-group form-actions">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty company.id}">
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
   
<v:javascript formName="company" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>