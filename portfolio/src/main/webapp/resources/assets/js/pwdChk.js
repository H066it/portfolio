	$(function() {			// == $(document).ready(function(){});
		pwdChk = pwdChk.split('.', 2)[1];
		if(pwdChk != "NaN") {			
			try{			
				if(pwdChk == "false") {
					alert("비밀번호가 틀립니다.")
					
					var url = $(location).attr('href');
					var modifiedUrl = url.split('&', 1);
					
					location.replace(modifiedUrl);		
					
					delete pwdChk;
				}
			} catch(e) {
			}
		}
	});