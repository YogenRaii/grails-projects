<%--
  Created by IntelliJ IDEA.
  User: rajkumar
  Date: 5/19/2016
  Time: 4:36 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>
        ${user.profile ? user.profile.fullName : user.loginId}
    </title>
    <meta name="layout" content="main"/>
    <asset:javascript library="jquery" src="jquery-2.2.0.min.js"/>

    <g:if test="${user.profile?.skin}">
        <asset:stylesheet src="${user.profile.skin}.css"/>
    </g:if>

    <g:javascript>
        function clearPost(e) {
            $('#postContent').val('');
        }
        function showSpinner(visible) {
            if (visible) {
                $('#spinner').show();
            } else {
                $('#spinner').hide();
            }
        }

        function addTinyUrl(data) {
            var tinyUrl = data.urls.small;
            var postBox = $("#postContent");
            postBox.val(postBox.val()+tinyUrl);
            toggleTinyUrl();
            $("#tinyUrl input[name = 'fullUrl']").val('');
        }
    </g:javascript>
</head>

<body>
<h1>Timeline for ${user.profile ? user.profile.fullName : user.loginId}</h1>
<g:if test="${flash.message}">
    <div class="flash">
        ${flash.message}
    </div>
</g:if>
<div id="newPost">
    <h3>What is ${user.profile.fullName} hacking on right now?</h3>

    <p>
    %{--<g:form action="addPost" id="${params.id}">
        <g:textArea name="content" id="postContent" cols="50" rows="3"/><br/>
        <g:submitButton name="post" value="Post"/>
    </g:form>--}%

        <g:form>
            <g:textArea name="content" id="postContent" cols="50" rows="3"/><br/>
            <g:submitToRemote name="post" value="Post"
                              url="[controller: 'post', action: 'addPostAjax']"
                              update="allPosts"
                              onSuccess="clearPost(data)"
                              onLoading="showSpinner(true)"
                              onComplete="showSpinner(false)"/>
        %{--<g:img id="spinner" style="display: none;" uri="/images/spinner.gif"/>--}%
            <a href="#" id="showHideUrl" onclick="toggleTinyUrl();
            return false;">
                Show TinyURL
            </a>
            <asset:image src="spinner.gif" style="display: none;"/>
        </g:form>

    <div id="tinyUrl" style="display: none;">
        <g:formRemote name="tinyUrlForm" url="[action: 'tinyUrl']" onSuccess="addTinyUrl(data)">
            TinyUrl: <g:textField name="fullUrl"/>
            <g:submitButton name="submit" value="Make Tiny"/>
        </g:formRemote>
    </div>

    <script disposition="head">
        function toggleTinyUrl() {
            var toggleText = $('#showHideUrl');
            if($('#tinyUrl').is(':visible')){
                $('#tinyUrl').slideUp(300);
                toggleText.innerText = 'Hide TinyURL';
            }else {
                $('#tinyUrl').slideDown(300);
                toggleText.innerText = 'Show TinyURL';
            }
        }
    </script>
</p>
</div>

<div id="allPosts">

    <g:render template="postEntry" collection="${user.posts}" var="post"/>
    %{--<g:each in="${user.posts}" var="post">
        <div class="postEntry">
            <div class="postText">
                ${post.content}
            </div>
            <div class="postDate">
                ${post.dateCreated}
            </div>
        </div>
    </g:each>--}%
</div>

</body>
</html>