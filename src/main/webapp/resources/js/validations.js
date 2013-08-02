
function isValidEmail(email){
	var regEx = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	
	return regEx.test(email);
}

function isAlphabetic(target){
	var regEx = /^[a-zA-Z]+$/g;
    return regEx.test(target);
}

function isNumeric(target) {
	var regEx = /\d{6}/g;
    return regEx.test(target);
}



