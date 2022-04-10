<%--
  Created by IntelliJ IDEA.
  User: supri
  Date: 4/3/2022
  Time: 2:06 PM
--%>

<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="member" args="['Create']"/>
    </div>
    <div class="card-body">
        <g:form controller="member" action="create">

        %{--Partial Templating--}%
            <g:render template="form"/>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="create" value="${g.message(code: "create")}"/>
                <g:link controller="member" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
            </div>
        </g:form>
    </div>
</div>