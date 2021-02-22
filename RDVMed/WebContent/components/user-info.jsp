<div class="user-info">
	<div style="margin: 10px 0;">
		${user.getName()} ${user.getLastname()}
		<%if (user.getType() == 1) { %>
			Admin
		<%} %>
		<%if (user.getType() == 2) { %>
			Doctor
		<%} %>
		<%if (user.getType() == 3) { %>
			Patient
		<%} %>
		</a>
	</div>
  	<div class="info-wrap">
	  	<label>Phone: &nbsp;</label>
	  	<div class="value">${user.getPhone()}</div>
	</div>
	<div class="info-wrap">
		<label>Email: &nbsp;</label>
		<div class="value">${user.getEmail()}</div>
	</div>
	<div class="info-wrap">
		<label>Address: &nbsp;</label>
		<div class="value">${user.getAddress()}</div>
	</div>
	<div class="info-wrap">
		<label>Birthday: &nbsp;</label>
		<div class="value">${user.getBirthday()}</div>
	</div>
	<a class="btn btn-primary btn-sm" role="button" href="editUserInfo">Edit</a>
	<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#staticBackdrop">Logout</button>
</div>

<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Tips</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Are you sure you want to log out?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <a class="btn btn-primary" role="button" href="logout">Logout</a>
      </div>
    </div>
  </div>
</div>