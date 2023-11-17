function submitForm()
{       
	resetErrorMessage()
	 
	var user_id = document.getElementById('userID').value
	var user_password = document.getElementById('password').value
			
	var error = false
			
	if (user_id == "")
	{
		document.getElementById('error1').innerHTML = "this field is required"
		error = true
	}
	if (user_password == "")
	{
		document.getElementById('error2').innerHTML = "this field is required"
		error = true
	}
			
			
	if (!error)
    	document.forms["myForm"].submit();
	else
		return false			
}

function resetErrorMessage()
{
	document.getElementById('error1').innerHTML = ""
	document.getElementById('error2').innerHTML = ""			
}