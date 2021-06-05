				
function sendLinkCustom() {

	Kakao.init('9175496125b7a261017afec5592049dd');  
	Kakao.Link.sendCustom({
		templateId: 53652 
	});
}

function reload_ISR() {
	location.href='/interest_survey';	
}
function load_home(){
	location.href='/';
}
