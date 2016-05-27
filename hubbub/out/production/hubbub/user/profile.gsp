<%--
  Created by IntelliJ IDEA.
  User: rajkumar
  Date: 5/20/2016
  Time: 5:39 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Profile</title>
    <meta name="layout" content="main">
</head>

<body>
<div class="profilePic">
    <g:if test="${profile.photo}">
        <img style="height: 70px;" src="${createLink(controller: 'image', action: 'renderImage', id: profile.user.loginId)}"/>
    </g:if>
    <p>Profile for <strong>${profile.fullName}</strong></p>
    <p>Bio: ${profile.bio}</p>
</div>

</body>
</html>