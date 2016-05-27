<%--
  Created by IntelliJ IDEA.
  User: rajkumar
  Date: 5/20/2016
  Time: 5:16 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Upload Image</title>
    <meta name="layout" content="main">
</head>

<body>
<h1>Upload an Image</h1>
<g:uploadForm action="upload">
    User Id: <g:select name="loginId" from="${userList}" optionKey="loginId" optionValue="loginId"/>
    <p/>
    Photo: <input type="file" name="photo">
    <g:submitButton name="upload" value="Upload"/>
</g:uploadForm>
</body>
</html>