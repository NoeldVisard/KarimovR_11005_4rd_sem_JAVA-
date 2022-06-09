<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,500,400italic,300italic,300,500italic,700,700italic,900,900italic'
          rel='stylesheet' type='text/css'>
    <link id="theme-style" rel="stylesheet" href="/assets/css/styles.css">
    <title>Resume</title>
</head>
<body>
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
<div class="wrapper">
    <div class="sidebar-wrapper">
        <div class="profile-container" id="profile_container">
            <img class="profile" src="${resume.imagePath!"/assets/img/images/profile.png"}" alt=""/>
            <h1 class="name">${resume.title!""}</h1>
            <h3 class="tagline">${rate!"no rates"}</h3>
            <#if userRate??>
                <h5 id="user_rate">Your rate: ${userRate}</h5>
            <#else>
                <div id="choose_rate">
                    <button onclick="subtractRate()">-</button>
                    <h3 id="your_rate">5</h3>
                    <button onclick="addRate()">+</button>
                    <button onclick="sendRate(${resume.id})">Rate this resume</button>
                </div>
            </#if>
        </div>
        <div class="container container-block">
            <h2 class="container-block-title">Contacts</h2>
            <ul class="list-unstyled list">
                <#list resume.contacts as contact>
                    <li>${contact.title} <a href="#" target="_blank">${contact.contact}</a></li>
                </#list>
            </ul>
        </div>
        <div class="education-container container-block">
            <h2 class="container-block-title">Education</h2>
            <#list resume.educations as education>
                <div class="item">
                    <h4 class="degree">${education.title}</h4>
                    <h5 class="meta">${education.place}</h5>
                    <div class="time">${education.workTimeInterval}</div>
                </div>
            </#list>
        </div>

        <div class="languages-container container-block">
            <h2 class="container-block-title">Languages</h2>
            <ul class="list-unstyled list">
                <#list resume.languages as language>
                    <li>${language.language} <span class="lang-desc">(${language.level})</span></li>
                </#list>
            </ul>
        </div>

        <div class="interests-container container-block">
            <h2 class="container-block-title">Interests</h2>
            <ul class="list-unstyled list">
                <#list resume.interests as interest>
                    <li>${interest.title}</li>
                </#list>
            </ul>
        </div>
    </div>
    <div class="main-wrapper">
        <section class="section summary-section">
            <h2 class="section-title"><i class="fa fa-user"></i>About me</h2>
            <div class="summary">
                <p>${resume.about!""}</p>
            </div>
        </section>
        <section class="section experiences-section">
            <h2 class="section-title"><i class="fa fa-briefcase"></i>Experiences</h2>
            <#list resume.experiences as experience>
                <div class="item">
                    <div class="meta">
                        <div class="upper-row">
                            <h3 class="job-title">${experience.title}</h3>
                            <div class="time">${experience.workTimeInterval}</div>
                        </div>
                        <div class="company">${experience.place}</div>
                    </div>
                    <div class="details">
                        <p>${experience.description!""}</p>
                    </div>
                </div>
            </#list>
        </section>
        <section class="section projects-section">
            <h2 class="section-title"><i class="fa fa-archive"></i>Projects</h2>
            <#list resume.projects as project>
                <div class="item">
                    <span class="project-title">${project.title}</span> - <span
                            class="project-tagline">${project.description}</span>
                </div>
            </#list>
        </section>
        <section class="skills-section section">
            <h2 class="section-title"><i class="fa fa-rocket"></i>Skills</h2>
            <div class="skillset">
                <#list resume.skills as skill>
                    <div class="item">
                        <h3 class="level-title">${skill.title}</h3>
                    </div>
                </#list>
            </div>
        </section>

    </div>
</div>
<footer class="footer">
</footer>

<script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="/assets/js/rate.js"
        type="text/javascript"></script>
</body>
</html>

