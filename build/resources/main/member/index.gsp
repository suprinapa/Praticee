<%--
  Created by IntelliJ IDEA.
  User: supri
  Date: 4/3/2022
  Time: 2:26 PM
--%>
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="Welcome.to.Home.Page" args="['List']"/>

        %{--Actions--}%
        <span class="float-right">


           %{-- Search Panel--}%
%{--            <div class="btn-group">
                <g:form controller="member" action="index">
                    <div class="input-group" id="search-area">
                        <g:select name="colName" class="form-control" from="[id: 'Id', name: 'Name', address: 'Address']" value="${params?.colName}" optionKey="key" optionValue="value"/>
                        <g:textField name="colValue" class="form-control" value="${params?.colValue}"/>
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="submit">Search</button>
                        </span>
                    </div>
                </g:form>
            </div>--}%

            %{--Create and Reload Panel--}%
            <div class="btn-group">
                <g:link controller="member" action="create" class="btn btn-success"><g:message code="create"/></g:link>
                <g:link controller="member" action="index" class="btn btn-primary"><g:message code="reload"/></g:link>
            </div>
        </span>
    </div>

    %{--Table Panel--}%
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <g:sortableColumn property="id" title="${g.message(code: "id")}"/>
                <g:sortableColumn property="name" title="${g.message(code: "name")}"/>
                <g:sortableColumn property="address" title="${g.message(code: "address")}"/>
                <th class="action-row"><g:message code="action"/></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${memberList}" var="info">
                <tr>
                    <td>${info?.id}</td>
                    <td>${info?.name}</td>
                    <td>${info?.address}</td>

                    %{--Table Actions --}%
                    <td>
                        <div class="btn-group">
                            <g:link controller="member" action="update" class="btn btn-secondary" id="${info.id}"><i class="fas fa-edit"></i></g:link>
                            <g:link controller="member" action="delete" id="${info.id}" class="btn btn-secondary delete-confirmation"><i class="fas fa-trash"></i></g:link>
                        </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
        %{--Pagination Area--}%
      %{--  <div class="paginate">
            <g:paginate total="${total ?: 0}" />
        </div>--}%
    </div>
</div>
