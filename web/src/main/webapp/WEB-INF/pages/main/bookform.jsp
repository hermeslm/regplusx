<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="bookDetail.title"/></title>
    <meta name="menu" content="BookMenu"/>
</head>
 
<div class="col-sm-3">
    <h2><fmt:message key='bookDetail.heading'/></h2>
</div>
 
<div class="col-sm-7">
    <form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
    <form:form commandName="book" method="post" action="bookform" id="bookForm" cssClass="well" onsubmit="return validateBook(this)">
    <form:hidden path="id"/>
    <spring:bind path="book.name">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="book.name"/>
        <form:input path="name" id="name" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="name" cssClass="help-inline"/>
        <appfuse:label styleClass="control-label" key="book.bookTypeId"/>
        <form:select id="bookTypeSelect" path="bookType.id" items="${bookTypeList}" cssClass="form-control" itemValue="id" itemLabel="name" />
        <form:errors path="bookType.id" cssClass="help-inline"/>
    </div>
    <div class="form-group form-actions">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty book.id}">
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
 
<v:javascript formName="book" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>