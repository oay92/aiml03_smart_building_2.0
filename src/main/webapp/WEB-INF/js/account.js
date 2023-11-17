function submitForm()
{        
	resetErrorMessage()
	
	var element = document.getElementsByName('level');
	var account_level = ""
	for(var i = 0; i < element.length; i++)
	{
		if (element[i].checked) account_level = element[i].value
	}
			
	var user_id = document.getElementById('userID').value
	var user_password = document.getElementById('password').value
			
	var error = false
	if (account_level == "")
	{
		document.getElementById('error1').innerHTML = "this field is required"
		error = true
	}
			
	if (user_id == "")
	{
		document.getElementById('error2').innerHTML = "this field is required"
		error = true
	}
	if (user_password == "")
	{
		document.getElementById('error3').innerHTML = "this field is required"
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
	document.getElementById('error3').innerHTML = ""			
}

function hide(id)
{
	document.getElementById(id).style.display ="none"
}