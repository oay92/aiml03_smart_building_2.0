function submitForm()
{       
	resetErrorMessage()
	var p1 = document.getElementById('password1').value
	var p2 = document.getElementById('password2').value
		
	var error = false
	if (p1 == "")
	{
		document.getElementById('error1').innerHTML = "this field is required"
		error = true
	}		
	if (p2 == "")
	{
		document.getElementById('error2').innerHTML = "this field is required"
		error = true
	}
	if (p1 != p2 && error == false)
	{
		document.getElementById('error1').innerHTML = "passwords do not match"
		document.getElementById('error2').innerHTML = "passwords do not match"
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
		
function hide(id)
{
	document.getElementById(id).style.display ="none"
	window.location.href = "${root}/Index.do?accountLevel=${account.level}"
}