<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="clientDetail.title"/></title>
    <meta name="menu" content="ClientMenu"/>
</head>
 
<div class="col-sm-3">
    <h2><fmt:message key='clientDetail.heading'/></h2>
</div>
 
<div class="col-sm-7">
    <form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
    <form:form commandName="client" method="post" action="clientform" id="clientForm" cssClass="well" onsubmit="return validateClient(this)">
    <form:hidden path="id"/>
    <spring:bind path="client.name">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="client.name"/>
        <form:input path="name" id="name" maxlength="250" autofocus="true" cssClass="form-control"/>
        <form:errors path="name" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="client.lastName"/>
        <form:input path="lastName" id="lastName" maxlength="250" autofocus="true" cssClass="form-control"/>
        <form:errors path="lastName" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="client.address"/>
        <form:input path="address" id="address" maxlength="250" autofocus="true" cssClass="form-control"/>
        <form:errors path="address" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="client.provinceId"/>
        <form:select id="provinceSelect" path="province.id" items="${provinceList}" cssClass="form-control" itemValue="id" itemLabel="name" />
        <form:errors path="province.id" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="client.cantonId"/>
        <form:select id="cantonSelect" path="canton.id" cssClass="form-control" itemValue="id" itemLabel="name" />
        <form:errors path="canton.id" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="client.parroquiaId"/>
        <form:select id="parroquiaSelect" path="parroquia.id" cssClass="form-control" itemValue="id" itemLabel="name" />
        <form:errors path="parroquia.id" cssClass="help-inline"/>
    </div>
    <div class="form-group form-actions">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty client.id}">
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
<c:url var="findCantonURL" value="/main/clientform/cantonsByProvince" />
<c:url var="findParroquiaURL" value="/main/clientform/parroquiasByCanton" />
<script type="text/javascript">
$(document).ready(function() { 
	$('#provinceSelect').change(
		function() {
			$.getJSON('${findCantonURL}', {
				provinceId : $(this).val(),
				ajax : 'true'
			}, function(data) {
				var html = '';
				var len = data.length;
				for ( var i = 0; i < len; i++) {
					html += '<option value="' + data[i][0] + '">'
							+ data[i][1] + '</option>';
				}
				html += '</option>';
 
				$('#cantonSelect').html(html);
			});
		});
	
	$('#cantonSelect').change(
			function() {
				$.getJSON('${findParroquiaURL}', {
					cantonId : $(this).val(),
					ajax : 'true'
				}, function(data) {
					var html = '';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i][0] + '">'
								+ data[i][1] + '</option>';
					}
					html += '</option>';
	 
					$('#parroquiaSelect').html(html);
				});
			});
});
</script>
 
<v:javascript formName="client" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>