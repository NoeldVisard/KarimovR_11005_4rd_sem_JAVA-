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
                        <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover"
                                                            href="/resumes">Resumes</a></li>
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
        <div class="profile-container">
            <img src="${resume.imagePath!"/assets/img/images/profile.png"}" alt="User Image">
            <form action="/resumes/add_image/${resume.id}" enctype="multipart/form-data" method="post">
                <input type="file" id="resumeImage" name="resumeImage" title="Change Image">
                <button type="submit">Save</button>
            </form>
            <label for="title"></label><input id="title" type="text" class="tagline" style="color: #0f0f0f"
                                              value="${resume.title!""}">
            <button onclick="updateTitle(${resume.id})">Save</button>
        </div>
        <div class="container container-block">
            <h2 class="container-block-title">Contacts</h2>
            <ul class="list-unstyled list" id="contacts_container">
                <#list resume.contacts as contact>
                    <li id="contact_${contact.id}">${contact.title} <a href="#" target="_blank">${contact.contact}</a>
                    </li>
                </#list>
                <li>
                    <label for="new_contact_title"></label><input type="text" id="new_contact_title"
                                                                  placeholder="title">
                    <label for="new_contact_info"></label><input type="text" id="new_contact_info"
                                                                 placeholder="details">
                    <button onclick="addContact(${resume.id})">Add</button>
                </li>
            </ul>
        </div>
        <div class="education-container container-block" id="educations_container">
            <h2 class="container-block-title">Education</h2>
            <#list resume.educations as education>
                <div class="item" id="education_${education.id}">
                    <h4 class="degree">${education.title}</h4>
                    <h5 class="meta">${education.place}</h5>
                    <div class="time">${education.workTimeInterval}</div>
                </div>
            </#list>
            <li>
                <label for="new_education_title">Title</label><input type="text" id="new_education_title"
                                                                     placeholder="title">
                <label for="new_education_place">Place</label><input type="text" id="new_education_place"
                                                                     placeholder="Place">
                <label for="new_education_time">Time interval</label><input type="text" id="new_education_time"
                                                                            placeholder="Time inverval">
                <button onclick="addEducation(${resume.id})">Add</button>
            </li>
        </div>

        <div class="languages-container container-block">
            <h2 class="container-block-title">Languages</h2>
            <ul class="list-unstyled list" id="languages_container">
                <#list resume.languages as language>
                    <li>${language.language} <span class="lang-desc">(${language.level})</span>
                    </li>
                </#list>
                <li>
                    <label for="new_language">Title</label><input type="text" id="new_language"
                                                                  placeholder="title">
                    <label for="new_language_level">Level</label><input type="text" id="new_language_level"
                                                                        placeholder="level">
                    <button onclick="addLanguage(${resume.id})">Add</button>
                </li>
            </ul>
        </div>

        <div class="interests-container container-block">
            <h2 class="container-block-title">Interests</h2>
            <ul class="list-unstyled list" id="interests_container">
                <#list resume.interests as interest>
                    <li>${interest.title}
                    </li>
                </#list>
                <li>
                    <label for="new_interest">Title</label><input type="text" id="new_interest"
                                                                  placeholder="title">
                    <button onclick="addInterest(${resume.id})">Add</button>
                </li>
            </ul>
        </div>
    </div>
    <div class="main-wrapper">
        <section class="section summary-section">
            <h2 class="section-title"><i class="fa fa-user"></i>About me</h2>
            <div class="summary">
                <label for="about">About me</label><textarea id="about"
                                                             placeholder="About me">${resume.about!""}</textarea>
                <button onclick="updateAboutMe(${resume.id})">Save</button>
            </div>
        </section>
        <section class="section experiences-section" id="experiences_container">
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
            <div>
                <label for="new_experience_title">Title</label><input type="text" id="new_experience_title"
                                                                      placeholder="title">
                <label for="new_experience_time">Work Time</label><input type="text" id="new_experience_time"
                                                                         placeholder="Work Time Interval">
                <label for="new_experience_place">Place</label><input type="text" id="new_experience_place"
                                                                      placeholder="Place">
                <label for="new_experience_description">Description</label><input type="text"
                                                                                  id="new_experience_description"
                                                                                  placeholder="description">
                <button onclick="addExperience(${resume.id})">Add</button>
            </div>
        </section>
        <section class="section projects-section" id="projects_container">
            <h2 class="section-title"><i class="fa fa-archive"></i>Projects</h2>
            <#list resume.projects as project>
                <div class="item">
                    <span class="project-title">${project.title}</span> - <span
                            class="project-tagline">${project.description}</span>
                </div>
            </#list>
            <div>
                <label for="new_project_title">Title</label><input type="text" id="new_project_title"
                                                                   placeholder="title">
                <label for="new_project_description">Description</label><input type="text" id="new_project_description"
                                                                               placeholder="description">
                <button onclick="addProject(${resume.id})">Add</button>
            </div>
        </section>
        <section class="skills-section section">
            <h2 class="section-title"><i class="fa fa-rocket"></i>Skills</h2>
            <div class="skillset" id="skills_container">
                <#list resume.skills as skill>
                    <div class="item">
                        <h3 class="level-title">${skill.title}</h3>
                    </div>
                </#list>
                <div>
                    <label for="new_skill_title">Skill</label><input type="text" id="new_skill_title"
                                                                     placeholder="Skill">
                    <button onclick="addSkill(${resume.id})">Add</button>
                </div>
            </div>
        </section>

    </div>
</div>
<footer class="footer">
</footer>


<script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="/assets/js/resume.js"
        type="text/javascript"></script>
</body>
</html>

