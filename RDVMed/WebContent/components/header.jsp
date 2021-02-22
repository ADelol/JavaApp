<header>
	<div class="title-bg">
		<h1>Hospital registration system</h1>
	</div>
	<nav class="nav">
		<a class="nav-link home" href="login">Home</a>
		<%if (user.getType() == 1) { %>
			<a class="nav-link doctorManage" href="doctorManage">DoctorManage</a>
			<a class="nav-link patientManage" href="patientManage">PatientManage</a>
		<%} %>
		<%if (user.getType() == 2) { %>
			<a class="nav-link apmentManage" href="apmentManage">MyAppointment</a>
			<a class="nav-link timeManage" href="timeManage">LeaveManage</a>
		<%} %>
		<%if (user.getType() == 3) { %>
			<a class="nav-link appointment" href="appointment">Appointment</a>
			<a class="nav-link apmentManage" href="apmentManage">MyAppointment</a>
		<%} %>
	</nav>
</header>