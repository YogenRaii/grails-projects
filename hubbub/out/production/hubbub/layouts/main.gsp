<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        Hubbub &raquo; <g:layoutTitle default="Welcome"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    %{--<asset:stylesheet src="application.css"/>--}%
    <asset:stylesheet src="hubbub.css"/>
    <asset:stylesheet src="main.css"/>
    <g:layoutHead/>
    <r:layoutResources />
    <nav:resources />
</head>

<body>
<div>
    <div id="hd">
        <g:link uri="/">
            <asset:image src="headerlogo.png" alt="hubbub logo"/>
        </g:link>
    </div>

    <div id="bd">
        <div class="navbar navbar-fixed-top navbar-inverse">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="brand" href="#">
                        Hubbub
                    </a>
                    <ul class="nav">
                        <ul class="nav nav-tabs">
                        </ul>
                        <li class="active">
                            <a href="#">
                                My Timeline
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Global Timeline
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Search
                            </a>
                        </li>
                        <li class="">
                            <a href="#">
                                Advanced Search
                            </a>
                        </li>
                        <li class="">
                            <a href="#">
                                Register
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <nav:render groups="tabs" />
        <g:layoutBody/>
    </div>

    <div id="ft">
        <div id="footerText">Hubbub - Social Networking On Grails</div>
    </div>

</div>
%{--
<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>--}%

%{--<asset:javascript src="application.js"/>--}%
<r:layoutResources />
</body>
</html>
