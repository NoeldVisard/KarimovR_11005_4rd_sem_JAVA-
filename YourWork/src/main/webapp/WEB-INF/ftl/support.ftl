<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <link rel="stylesheet" href="/assets/css/layout.css">
    <link rel="stylesheet" href="/assets/css/styles.css">
    <link rel="stylesheet" href="/assets/widgets/yourwork.svg">

    <meta charset="utf-8"/>
    <title>https://yourwork.com </title>
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <!-- удерживает верную разметку и масштаб -->
    <link href="https://fonts.googleapis.com/css?family=Hind:300,400,500,600,700" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/layout.min.css">

</head>
<body id="body" data-spy="scroll" data-target=".header" onload="connect(${user.id})">
<header class="header navbar-fixed-top">
    <nav class="navbar" role="navigation">
        <div class="container">
            <!-- верхняя неизменная панель -->
            <div class="menu-container js_nav-item">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="toggle-icon"></span>
                </button>
                <div class="logo">
                    <a class="logo-wrap" href="#body">
                        <img class="logo-img logo-img-main"
                             src="/assets/widgets/yourwork.svg" alt="yourWork Logo">
                        <img class="logo-img logo-img-active"
                             src="/assets/widgets/yourwork.svg" alt="yourWork Logo">
                    </a>
                </div>
            </div>
            <div class="collapse navbar-collapse nav-collapse">
                <div class="menu-container">
                    <ul class="nav navbar-nav navbar-nav-right">
                        <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover" href="/home">Home</a>
                        </li>
                        <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover" href="/resumes">Resumes</a>
                        </li>
                        <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover" href="/support">Support</a>
                        </li>
                        <#if user??>
                            <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover"
                                                                href="/profile">Profile</a></li>
                        <#else>
                            <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover"
                                                                href="/signIn">Sign
                                    in</a></li>
                            <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover"
                                                                href="/signUp">Sign
                                    up</a></li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</header>
<div id="resumes">
    <div class="container content-lg">
        <div class="row text-center margin-b-40">
            <div class="col-sm-6 col-sm-offset-3">
                <h2>Support</h2>
            </div>

            <div id="chatScrollView" style="overflow:scroll; height:400px;">
                <div id="messages"></div>
            </div>
            <div style="text-align: center">
                <button id="enterChatButton" onclick="loginToChat('${user.firstName}')">Start chat</button>
            </div>
            <label for="message"></label><input name="message" id="message" disabled placeholder="Message" hidden>
            <button onclick="sendMessage('${user.firstName}', $('#message').val())" id="sendMessageButton" hidden>
                Send
            </button>
        </div>
    </div>
</div>
<footer class="footer">
    <div class="content container">
        <div class="row">
            <div class="col-xs-6">
                <img class="footer-logo" src="/assets/widgets/yourwork.svg"
                     alt="yourWork Logo">
            </div>
        </div>
    </div>
</footer>

<!-- JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- CORE PLUGINS -->
<script src="/assets/bootstrap/js/jquery.min.js"
        type="text/javascript"></script>
<script src="/assets/bootstrap/js/bootstrap.min.js"
        type="text/javascript"></script>

<!-- PAGE LEVEL PLUGINS -->
<script src="/assets/bootstrap/js/jquery.smooth-scroll.js"
        type="text/javascript"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBsXUGTFS09pLVdsYEE9YrO2y4IAncAO2U&amp;callback=initMap"
        async defer></script>

<!-- PAGE LEVEL SCRIPTS -->
<script src="/assets/js/layout.min.js" type="text/javascript"></script>
<script src="/assets/js/components/wow.min.js"
        type="text/javascript"></script>
<script src="/assets/js/components/swiper.min.js"
        type="text/javascript"></script>
<script src="/assets/js/components/masonry.min.js"
        type="text/javascript"></script>
<script src="/assets/js/support.js"
        type="text/javascript"></script>

</body>
</html>