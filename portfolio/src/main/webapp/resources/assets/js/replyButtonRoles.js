	function transferRId(rId, rGroup) {		
		$("#rIdOnReply").val(rId);
		$("#rGroupOnReply").val(rGroup);
	}
	
	function transferRIdUpd(rId, rGroup) {		
		$("#rIdOnUpdate").val(rId);
		$("#rGroupOnUpdate").val(rGroup);
	}
	
	function transferRIdDel(rId, rGroup) {		
		$("#rIdOnDelete").val(rId);
		$("#rGroupOnDelete").val(rGroup);
	}
	
	$(function() {			// == $(document).ready(function(){});
		try{			
			if(pwdChk == false) {
				alert("비밀번호가 틀립니다.")
			}
			var url = $(location).attr('href');
			var modifiedUrl = url.split('&', 1);
			location.replace(modifiedUrl);					
		} catch(e) {
		}
	});