<div class="form-group">
    <label><g:message code="name"/> *</label>
    <g:textField name="name" class="form-control" value="${member?.name}" placeholder="Please Enter Name"/>

</div>

<div class="form-group">
    <label><g:message code="address"/></label>
    <g:textField name="address" class="form-control" value="${member?.address}" placeholder="Please Address"/>
</div>
%{--
<g:if test="${!edit}">
    <div class="form-group">
        <label><g:message code="password"/> *</label>
        <g:passwordField name="password" class="form-control" value="${member?.password}" placeholder="Please Enter Password"/>
        <UIHelper:renderErrorMessage fieldName="password" model="${member}" errorMessage="Please Enter a Password."/>
    </div>
</g:if>--}%
