



/*
	number of fieldsets
 */
var fieldsetCount = $('#formElem').children().length;

/*
	current position of fieldset / navigation link
 */
var current 	= 1;    		

/*
	when clicking on a navigation link 
	the form slides to the corresponding fieldset
 */
$('#navigation a').bind('click',function(e){

	var $this	= $(this);
	var prev	= current;
	$this.closest('ul').find('li').removeClass('selected');
	$this.parent().addClass('selected');
	/*
		we store the position of the link
		in the current variable	
	 */
	current = $this.parent().index() + 1;
	/*
		animate / slide to the next or to the corresponding
		fieldset. The order of the links in the navigation
		is the order of the fieldsets.
		Also, after sliding, we trigger the focus on the first 
		input element of the new fieldset
		If we clicked on the last link (confirmation), then we validate
		all the fieldsets, otherwise we validate the previous one
		before the form slided
	 */
	$('#steps').stop().animate({
		marginLeft: '-' + widths[current-1] + 'px'
	},500,function(){
		if(current == fieldsetCount)
			validateSteps();
		else
			validateStep(prev);
		$('#formElem').children(':nth-child('+ parseInt(current) +')').find(':input:first').focus();	
	});
	e.preventDefault();
});




/*
	validates errors on all the fieldsets
	records if the Form has errors in $('#formElem').data()
 */
function studentFormValidateSteps(){
	var fieldsetCount = $('#formElem').children().length;
	var FormErrors = false;
	for(var i = 0; i < fieldsetCount; ++i){
		var error = validateStep(i);
		if(error == -1)
			FormErrors = true;
	}
	
   if(!$('#isPhysicallyChallenged').is(':checked')){
			hasError = true;
			$('span#errorPc').text('Select Pc.');
	}
   
	$('#formElem').data('errors',FormErrors);	

	if($('#formElem').data('errors')){
		alert('Please correct the errors in the Form');
		return false;
	}	
}

/*
	validates one fieldset
	and returns -1 if errors found, or 1 if not
 */
function validateStep(step){
	var error = 1;
	try {


	//	if(step == fieldsetCount) return;

		
		var hasError = false;
		$('#formElem').children(':nth-child('+ parseInt(step+1) +')').find(':input:not(button)').each(function(){
			var $this 		= $(this);
			var val;
			if($this.is("input[name='name']")){

				if($.trim($this.val()).length == 0){
					hasError = true;
					$this.css('background-color','#FFEDEF');

				}else if(!isAlphabetic($this.val())){
					hasError = true;
					$this.css('background-color','#FFEDEF');
						errorMsgOnInput("errorName","Only Aplhabets.");
				}else{
					$('span#errorName').text('');
				}

			}else if($this.is("input[name='surName']")){
				if($.trim($this.val()).length == 0){
					hasError = true;
					$this.css('background-color','#FFEDEF');

				}else if(!isAlphabetic($this.val())){
					hasError = true;
					$this.css('background-color','#FFEDEF');
						errorMsgOnInput("errorSurName","Only Aplhabets.");
				}else{
					$('span#errorSurName').text('');
				}

			}else if($this.is("input[name='dateOfBirth']")){
				if($.trim($this.val()).length == 0){
					hasError = true;
					$this.css('background-color','#FFEDEF');
				}else{
					$('span#errorDob').text('');
				}

			}else if($this.is("input[name='joiningDate']")){
				if($.trim($this.val()).length == 0){
					hasError = true;
					$this.css('background-color','#FFEDEF');
				}else{
					$('span#errorDoj').text('');
				}

			}else if($this.is("input[name='description']")){
				if($.trim($this.val()).length == 0){
					hasError = true;
					$this.css('background-color','#FFEDEF');
				}else{
					$('span#errorstudentDes').text('');
				}

			}else if($this.is("input[name='fatherName']")){
				if($.trim($this.val()).length == 0){
					hasError = true;
					$this.css('background-color','#FFEDEF');
				}else if(!isAlphabetic($this.val())){
					hasError = true;
					$this.css('background-color','#FFEDEF');
					errorMsgOnInput("errorFname","Only Aplhabets.");
				}else{
					$('span#errorFname').text('');
				}

			}else if($this.is("input[name='fatherDesignation']")){
				if($.trim($this.val()).length == 0){
					hasError = true;
					$this.css('background-color','#FFEDEF');
				}else if(!isAlphabetic($this.val())){
					hasError = true;
					$this.css('background-color','#FFEDEF');
					errorMsgOnInput("errorFDesig","Only Aplhabets.");
				}else{
					$('span#errorFDesig').text('');
				}

			}else if($this.is("input[name='motherName']")){
				if($.trim($this.val()).length == 0){

				}else if(!isAlphabetic($this.val())){
					hasError = true;
					$this.css('background-color','#FFEDEF');
						errorMsgOnInput("errorMname","Only Aplhabets.");
				}else{
					$('span#errorMname').text('');
				}

			}else if($this.is("input[name='motherDesignation']")){
				if($.trim($this.val()).length == 0){
					hasError = true;
					$this.css('background-color','#FFEDEF');
				}else if(!isAlphabetic($this.val())){
					hasError = true;
					$this.css('background-color','#FFEDEF');
						errorMsgOnInput("errorMDesig","Only Aplhabets.");
				}else{
					$('span#errorMDesig').text('');
				}

			}else if($this.is("input[name='gaurdian']")){
				if($.trim($this.val()).length == 0){
					hasError = true;
					$this.css('background-color','#FFEDEF');
					
				}else if(!isAlphabetic($this.val())){
					hasError = true;
					$this.css('background-color','#FFEDEF');
					errorMsgOnInput("errorGaurdian","Only Aplhabets.");
			    }else{
					$('span#errorGaurdian').text('');
				}

			}else if($this.is("textarea")){
				if($.trim($this.val()).length == 0){
					hasError = true;
					$this.css('background-color','#FFEDEF');
				}else{
					$('span#errorHno1').text('');
				}

			}else if($this.is("input[name='district1']")){
				if($.trim($this.val()).length == 0){
					hasError = true;
					$this.css('background-color','#FFEDEF');
				}else{
					$('span#errorDist1').text('');
				}

			}else if($this.is("input[name='pincode1']")){
				if($.trim($this.val()).length == 0){
					hasError = true;
					$this.css('background-color','#FFEDEF');
				}else if(!isNumeric($this.val())){
					hasError = true;
					$this.css('background-color','#FFEDEF');
					errorMsgOnInput("errorPin1","Only Numerics.");
				}else{
					$('span#errorPin1').text('');
				}

			}else if($this.is("input[name='state1']")){
				
				if($.trim($this.val()).length == 0){
					hasError = true;
					$this.css('background-color','#FFEDEF');
				}else{
					$('span#State1').text('');
				}

			}else if($this.is("textarea")){
				if($.trim($this.val()).length == 0){
					hasError = true;
					$this.css('background-color','#FFEDEF');
				}else{
					$('span#errorHno2').text('');
				}

			}else if($this.is("input[name='district2']")){
				if($.trim($this.val()).length == 0){
					hasError = true;
					$this.css('background-color','#FFEDEF');
				}else{
					$('span#errorDist2').text('');
				}

			}else if($this.is("input[name='pincode2']")){
				
				if($.trim($this.val()).length == 0){
					hasError = true;
					$this.css('background-color','#FFEDEF');	
				}else if(!isNumeric($this.val())){
					hasError = true;
					$this.css('background-color','#FFEDEF');
					errorMsgOnInput("errorPin2","Only Numerics.");
				}else{
					$('span#errorPin2').text('');
				}

			}else if($this.is("input[name='state2']")){
				
				if($.trim($this.val()).length == 0){
					hasError = true;
					$this.css('background-color','#FFEDEF');
				}else{
					$('span#errorState2').text('');
				}

			}

				
		});

		if(hasError){
			error = -1;
		}
       
	} catch (e) {
		alert(e);
	}

	return error;
}

function errorMsgOnInput(id,msg){
	$('span#'+id).text(msg); 
}


