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
<body id="body" data-spy="scroll" data-target=".header">
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
                        <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover" href="#body">Home</a>
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

<div class="promo-block" style="background-image: url(/assets/img/1920x1080/01.jpg)">
    <div class="container">
        <div class="margin-b-40">
            <h1 class="promo-block-title">Find the boss here</h1>
            <p class="promo-block-text">And your hard work will soon pay off.</p>
        </div>
    </div>
</div>

<div id="resumes">
    <div class="container content-lg">
        <div class="row text-center margin-b-40">
            <div class="col-sm-6 col-sm-offset-3">
                <h2>Popular Resumes</h2>
                <p>Every day your resume is gaining more and more views. This means that the chance to get the desired
                    position is higher and higher! Fill in all the indicated points and be in the TOP</p>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-4 sm-margin-b-50">
                <div class="margin-b-20">
                    <img class="img-responsive wow fadeIn" src="/assets/img/970x647/01.jpg"
                         alt="Latest Products Image"
                         data-wow-duration=".3" data-wow-delay=".1s">
                </div>
                <h4><a href="#">Office</a> <span class="text-uppercase margin-l-20">Management</span></h4>
                <!-- <a class="link" href="#">Read More</a>-->
            </div>
            <div class="col-sm-4 sm-margin-b-50">
                <div class="margin-b-20">
                    <img class="img-responsive wow fadeIn" src="/assets/img/970x647/02.jpg"
                         alt="Latest Products Image"
                         data-wow-duration=".3" data-wow-delay=".2s">
                </div>
                <h4><a href="#">Stuck in place</a> <span class="text-uppercase margin-l-20">Development</span></h4>
                <!--<a class="link" href="#">Read More</a>-->
            </div>
            <div class="col-sm-4 sm-margin-b-50">
                <div class="margin-b-20">
                    <img class="img-responsive wow fadeIn" src="/assets/img/970x647/03.jpg"
                         alt="Popular resumes Image"
                         data-wow-duration=".3" data-wow-delay=".3s">
                </div>
                <h4><a href="#">Freelance</a> <span class="text-uppercase margin-l-20">Design</span></h4>
                <!-- <p></p>-->
                <!--<a class="link" href="#">Read More</a>-->
            </div>
        </div>
    </div>

    <div class="container-full-width">
        <div class="row row-space-2">
            <div class="col-sm-6 sm-margin-b-4">
                <img class="img-responsive" src="/assets/img/970x647/01.jpg" alt="Image">
            </div>
            <div class="col-sm-6">
                <img class="img-responsive" src="/assets/img/970x647/03.jpg" alt="Image">
            </div>
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
            <div class="col-xs-6 text-right">
                <p class="margin-b-0">powered by: <a class="fweight-700"
                                                     href="https://vk.com/alena.naud">Naumova
                        Alyona</a></p>
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
</body>
</html>