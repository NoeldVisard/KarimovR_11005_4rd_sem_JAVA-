function addContact(resumeId) {
    let title = document.getElementById('new_contact_title').value
    let contact = document.getElementById('new_contact_info').value
    $.ajax({
        url: '/resumes/add_contact',
        method: 'post',
        dataType: 'json',
        data: {
            "resumeId": resumeId,
            "title": title,
            "contact": contact
        },
        success: function (contact) {
            if (contact == null) {
                return;
            }
            const contactElem = document.createElement('li');
            contactElem.innerHTML = contact.title + ' <a href="#" target="_blank">' + contact.contact + '</a>';
            const container = document.querySelector('#contacts_container');
            container.insertBefore(contactElem, container.children[container.children.length - 1]);
        },
        error: function (response) {
        }
    })
}

function addLanguage(resumeId) {
    let language = document.getElementById('new_language').value
    let level = document.getElementById('new_language_level').value
    $.ajax({
        url: '/resumes/add_language',
        method: 'post',
        dataType: 'json',
        data: {
            "resumeId": resumeId,
            "language": language,
            "level": level
        },
        success: function (language) {
            if (language == null) {
                return;
            }
            const elem = document.createElement('li');
            elem.innerHTML = language.language + ' <span class="lang-desc">(' + language.level + ')</span>';
            const container = document.querySelector('#languages_container');
            container.insertBefore(elem, container.children[container.children.length - 1]);
        },
        error: function (response) {
        }
    })
}

function addEducation(resumeId) {
    let title = document.getElementById('new_education_title').value
    let place = document.getElementById('new_education_place').value
    let time = document.getElementById('new_education_time').value
    $.ajax({
        url: '/resumes/add_education',
        method: 'post',
        dataType: 'json',
        data: {
            "resumeId": resumeId,
            "title": title,
            "place": place,
            "time": time
        },
        success: function (education) {
            if (education == null) {
                return;
            }
            const elem = document.createElement('div');
            elem.classList.add("item")
            elem.id = 'education_' + education.id
            elem.innerHTML = '<h4 className="degree">' + education.title + '</h4>' +
                '<h5 className="meta">' + education.place + '</h5>' +
                '<div className="time">' + education.workTimeInterval + '</div>';
            const container = document.querySelector('#educations_container');
            container.insertBefore(elem, container.children[container.children.length - 1]);
        },
        error: function (response) {
        }
    })
}

function addInterest(resumeId) {
    let title = document.getElementById('new_interest').value
    $.ajax({
        url: '/resumes/add_interest',
        method: 'post',
        dataType: 'json',
        data: {
            "resumeId": resumeId,
            "title": title,
        },
        success: function (interest) {
            if (interest == null) {
                return;
            }
            const elem = document.createElement('li');
            elem.innerHTML = interest.title;
            const container = document.querySelector('#interests_container');
            container.insertBefore(elem, container.children[container.children.length - 1]);
        },
        error: function (response) {
        }
    })
}

function addExperience(resumeId) {
    let title = document.getElementById('new_experience_title').value
    let time = document.getElementById('new_experience_time').value
    let place = document.getElementById('new_experience_place').value
    let description = document.getElementById('new_experience_description').value
    $.ajax({
        url: '/resumes/add_experience',
        method: 'post',
        dataType: 'json',
        data: {
            "resumeId": resumeId,
            "title": title,
            "time": time,
            "place": place,
            "description": description
        },
        success: function (experience) {
            if (experience == null) {
                return;
            }
            const elem = document.createElement('div');
            elem.classList.add("item")
            elem.innerHTML = '<div className="meta"><div className="upper-row"><h3 className="job-title">' + experience.title + '</h3>' +
                '<div className="time">' + experience.workTimeInterval + '</div></div><div className="company">' + experience.place + '</div></div>' +
                '<div className="details"><p>' + experience.description + '</p></div>';
            const container = document.querySelector('#experiences_container');
            container.insertBefore(elem, container.children[container.children.length - 1]);
        },
        error: function (response) {
        }
    })
}

function addProject(resumeId) {
    let title = document.getElementById('new_project_title').value
    let description = document.getElementById('new_project_description').value
    $.ajax({
        url: '/resumes/add_project',
        method: 'post',
        dataType: 'json',
        data: {
            "resumeId": resumeId,
            "title": title,
            "description": description
        },
        success: function (project) {
            if (project == null) {
                return;
            }
            const elem = document.createElement('div');
            elem.classList.add("item")
            elem.innerHTML = project.title + ' <span class="project-title">' + project.title + '</span> - <span class="project-tagline">' + project.description;
            const container = document.querySelector('#projects_container');
            container.insertBefore(elem, container.children[container.children.length - 1]);
        },
        error: function (response) {
        }
    })
}

function addSkill(resumeId) {
    let title = document.getElementById('new_skill_title').value
    $.ajax({
        url: '/resumes/add_skill',
        method: 'post',
        dataType: 'json',
        data: {
            "resumeId": resumeId,
            "title": title,
        },
        success: function (skill) {
            if (skill == null) {
                return;
            }
            const elem = document.createElement('div');
            elem.classList.add("item")
            elem.innerHTML =
                '<h3 className="level-title">' + skill.title + '</h3>';
            const container = document.querySelector('#skills_container');
            container.insertBefore(elem, container.children[container.children.length - 1]);
        },
        error: function (response) {
        }
    })
}

function updateAboutMe(id) {
    let aboutMe = document.getElementById('about').value

    $.ajax({
        url: '/resumes/about_me',
        method: 'post',
        dataType: 'json',
        data: {
            "id": id,
            "aboutMe": aboutMe,
        },
        success: function (contact) {
        },
        error: function (response) {
        }
    })
}

function updateTitle(id) {
    let title = document.getElementById('title').value
    $.ajax({
        url: '/resumes/update_title',
        method: 'post',
        dataType: 'json',
        data: {
            "id": id,
            "title": title,
        },
        success: function (contact) {
        },
        error: function (response) {
        }
    })
}
