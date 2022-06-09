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
                <div>
                    <img src="${user.imageSrc!"/assets/img/images/profile.png"}" alt="User Image">
                    <form action="/profile" enctype="multipart/form-data" method="post">
                        <input type="file" id="userImage" name="userImage" title="Change Image">
                        <button type="submit">Save</button>
                    </form>
                    <h1>${user.firstName!""} ${user.lastName!""}</h1>
                </div>
                <h2>My Resumes</h2>
            </div>
        </div>
        <div class="col-sm-4 sm-margin-b-50" style="background-color: #f6f6f6">
            <h4>New Resume</h4>
            <form action="/resumes" method="post">
                <label for="resumeTitle">Title</label><input id="resumeTitle" name="resumeTitle" type="text"
                                                             placeholder="Title">
                <button class="link" type="submit">Create</button>
            </form>
        </div>
        <#list resumes as resume>
            <div class="col-sm-4 sm-margin-b-50" style="background-color: #f6f6f6">
                <h4>${resume.title!""}</h4>
                <p>About me: ${resume.about!""}</p>

                <form action="/resumes/${resume.id}" method="get">
                    <button class="link" type="submit">Read More</button>
                </form>
                <form action="/resumes/${resume.id}/edit" method="get">
                    <button class="link" type="submit">Edit</button>
                </form>
            </div>
            <br>
        </#list>
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

<script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="/assets/js/layout.min.js" type="text/javascript"></script>
<script src="/assets/js/components/wow.min.js"
        type="text/javascript"></script>
<script src="/assets/js/components/swiper.min.js"
        type="text/javascript"></script>
<script src="/assets/js/components/masonry.min.js"
        type="text/javascript"></script>
</body>
</html>