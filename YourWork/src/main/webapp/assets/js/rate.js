function sendRate(resumeId) {
    let rate = document.getElementById('your_rate').textContent

    $.ajax({
        url: '/resumes/send_rate',
        method: 'post',
        dataType: 'json',
        data: {
            "resumeId": resumeId,
            "rate": Number(rate),
        },
        success: function (userRate) {
            if (userRate == null) {
                return;
            }
            document.getElementById('choose_rate').hidden = true

            const rateElem = document.createElement('h5');
            rateElem.textContent = 'Your rate: ' + userRate;
            const container = document.querySelector('#profile_container');
            container.append(rateElem);
        },
        error: function (response) {
        }
    })
}

function addRate() {
    let rate = document.getElementById('your_rate').textContent
    if (rate < 5) {
        document.getElementById('your_rate').textContent = Number(rate) + 1
    }
}

function subtractRate() {
    let rate = document.getElementById('your_rate').textContent
    if (rate > 1) {
        document.getElementById('your_rate').textContent = Number(rate) - 1
    }
}
