

//profile
const userInfos = document.querySelectorAll(".userInfo");
const xmarks = document.querySelectorAll(".xmark");

userInfos.forEach((userInfo) => {
	userInfo.addEventListener("mouseenter", function() {
		this.previousElementSibling.classList.remove("xmark-hide");
	});
	userInfo.addEventListener("mouseleave", function(e) {
		if (e.relatedTarget.classList.contains("xmark")) {
			return;
		}
		this.previousElementSibling.classList.add("xmark-hide");
	});
});

xmarks.forEach((xmark) => {
	xmark.addEventListener("click", function() {
		if (confirm("Are you sure you want to delete this information?") == false) {
			return;
		}

		this.parentElement.parentElement.parentElement.remove();
	});
});



//Message
function showModal() {
	var modal = document.getElementById('modalWrapper');
	modal.classList.add('active');
}
function clearMessages() {
	var messagesContainer = document.getElementById('messages');
	messagesContainer.innerHTML = '';
}

function addMessage(event) {
	var message = document.getElementById('messageInput').value;

	var data = {
		message: message
	};

	fetch('/message', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(data)
	})
		.then(response => {
			if (!response.ok) {
				throw new Error('Network response was not ok');
			}
			document.getElementById('messageInput').value = '';
			clearMessages();
			console.log('Message sent successfully!');
		})
		.catch(error => {
			console.error('There was a problem sending the message:', error);
		});
}



function hideModal() {
	var modal = document.getElementById('modalWrapper');
	modal.classList.remove('active');
}
