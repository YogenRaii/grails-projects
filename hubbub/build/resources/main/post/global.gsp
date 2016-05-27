<%--
  Created by IntelliJ IDEA.
  User: rajkumar
  Date: 5/23/2016
  Time: 9:28 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Global Timeline</title>
    <meta name="layout" content="main">
</head>

<body>
<h1>Global Timeline</h1>

<g:if test="${flash.message}">
    <div class="flash">
        ${flash.message}
    </div>
</g:if>
<div id="newPost">
    <p>
        <g:form action="addPost" id="${params.id}">
            <g:textArea name="content" id="postContent" cols="50" rows="3"/><br/>
            <g:submitButton name="post" value="Post"/>
        </g:form>
    </p>
</div>

<div id="allPosts">
    <g:render template="postEntry" collection="${posts}" var="post"/>
</div>
<g:paginate action="global" total="${postCount}" max="25"/>
</body>
</html>