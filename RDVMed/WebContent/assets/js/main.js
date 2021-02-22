if (location.href.indexOf('doctorManage') != -1) {
	document.querySelector('header .doctorManage').classList.add('active')
} else if (location.href.indexOf('patientManage') != -1) {
	document.querySelector('header .patientManage').classList.add('active')
} else if (location.href.indexOf('appointment') != -1) {
	document.querySelector('header .appointment').classList.add('active')
} else if (location.href.indexOf('apmentManage') != -1) {
	document.querySelector('header .apmentManage').classList.add('active')
} else if (location.href.indexOf('timeManage') != -1) {
	document.querySelector('header .timeManage').classList.add('active')
} else {
	document.querySelector('header .home').classList.add('active')
}


var addDoctor = document.querySelector('#add-doctor')
if (addDoctor) {
	addDoctor.onclick = function() {
		document.querySelector('.add-doctor-values').style.display = 'table-row'
	}
}

var addPatient = document.querySelector('#add-patient')
if (addPatient) {
	addPatient.onclick = function() {
		document.querySelector('.add-patient-values').style.display = 'table-row'
	}
}

var appmentDateSelect = document.querySelectorAll('.appment-date-select')

for (let i = 0; i < appmentDateSelect.length; i++) {
	onchangeHandle({ target: { selectedIndex: 0 } }, i)
	appmentDateSelect[i].onchange = function (e) {
		onchangeHandle(e, i)
	}
}

function onchangeHandle (e, panelIndex) {
	var selectedIndex = e.target.selectedIndex;
	var ads = $('.appment-day-select-' + panelIndex);
	for (let i = 0; i < ads.length; i++) {
		if (selectedIndex == i) {
			ads[i].style.display = 'block'
		} else {
			ads[i].style.display = 'none'
		}
	}
}


