<%--
  Created by IntelliJ IDEA.
  User: rajkumar
  Date: 5/20/2016
  Time: 9:00 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <meta name="layout" content="main">
</head>

<body>
<h1>Login</h1>
<g:form action="signIn">
    <fieldset class="form">
        <div class="fieldcontain">
            <g:if test="${flash.message}">
                <div class="flash">${flash.message}</div>
            </g:if>
        </div>

        <div class="fieldcontain required">
            <label for="loginId">Login ID</label>
            <g:textField name="loginId" value="${user?.loginId}"/>
        </div>

        <div class="fieldcontain required">
            <label for="password">Password</label>
            <g:passwordField name="password" value="${user?.password}"/>
        </div>

        <div class="fieldcontain">
            <label for="signin"></label>
            <g:submitButton name="signin" value="Sign In"/>

        </div>
    </fieldset>
</g:form>
</body>
</html>