	function nullCheck() {		
		if($('input[name=bWriter]').val().length < 2) {
			alert('작성자를 2자 이상 입력해주세요.');
			$('input[name=bWriter]').focus();
			return false;
		}
		if($('input[name=bPassword]').val().length < 4) {
			alert('비밀번호를 4자 이상 입력해주세요.');
			$('input[name=bPassword]').focus();
			return false;
		}
		if($('input[name=bTitle]').val().length < 2) {
			alert('제목을 2자 이상 입력해주세요.');
			$('input[name=bTitle]').focus();
			return false;
		}
		if($('textarea[name=bContent]').val().length < 2) {
			alert('내용을 2자 이상 입력해주세요.');
			$('textarea[name=bContent]').focus();
			return false;
		}
		if($('input[name=bWriter]').val().length > 15) {
			alert('작성자 명을 15자 이하로 입력해주십시오.');
			$('input[name=bWriter]').focus();
			return false;
		}
		if($('input[name=bPassword]').val().length > 20) {
			alert('비밀번호를 20자 이하로 입력해주십시오.');
			$('input[name=bPassword]').focus();
			return false;
		}
		if($('input[name=bTitle]').val().length > 40) {
			alert('제목을 40자 이하로 입력해주십시오.');
			$('input[name=bTitle]').focus();
			return false;
		}
		if($('textarea[name=bContent]').val().length > 500) {
			alert('내용을 500자 이하로 입력해주십시오.');
			$('textarea[name=bContent]').focus();
			return false;
		}

		var totalFileSize = 0;
		
		for(var i = 0; i < $('input[name=upFile]')[0].files.length ; i++) {
			
			if($('input[name=upFile]')[0].files[i].size > 10485760) {
				alert('10MB가 넘는 파일은 올리실 수 없습니다.');
				$('textarea[name=upFile]').focus();
				totalFileSize = 0;
				return false;
			}

			if($('input[name=upFile]')[0].files[i].name.length > 50) {
				alert('파일 명을 줄여 주십시오.');
				$('textarea[name=upFile]').focus();
				totalFileSize = 0;
				return false;
			}

			totalFileSize += $('input[name=upFile]')[0].files[i].size;
			
			if(totalFileSize > 10485760) {
				alert('총 파일 용량은 10MB를 넘길 수 없습니다.');
				$('textarea[name=upFile]').focus();
				totalFileSize = 0;
				return false;
			}			
			
		}
	}
	
	function modifyNullCheck() {		
		if($('input[id=bPasswordForModify]').val().length < 4) {
			alert('비밀번호를 4자 이상 입력해주세요.');
			$('input[id=bPasswordForModify]').focus();
			return false;
		}
		if($('input[id=bPasswordForModify]').val().length > 20) {
			alert('비밀번호를 20자 이하로 입력해주십시오.');
			$('input[id=bPasswordForModify]').focus();
			return false;
		}		
	}
	
	function deleteNullCheck() {		
		if($('input[id=bPasswordForDelete]').val().length < 4) {
			alert('비밀번호를 4자 이상 입력해주세요.');
			$('input[id=bPasswordForDelete]').focus();
			return false;
		}
		if($('input[id=bPasswordForDelete]').val().length > 20) {
			alert('비밀번호를 20자 이하로 입력해주십시오.');
			$('input[id=bPasswordForDelete]').focus();
			return false;
		}		
	}	
	
	transferRIdOnly = function(rId) {
		$("#bIdForDelete").val(rId);
	}
	
	function loginNullCheck() {		
		if($('#sId').val().length < 1) {
			alert('ID를 입력해주세요.');			
			$('#sId').focus();
			return false;
		}
		if($('#sPw').val().length < 1) {
			alert('비밀번호를 입력해주세요.');
			$('#sPw').focus();
			return false;
		}
	}	
	
	function signUpNullCheck() {		
		if($('#upId').val().length < 4) {
			alert('ID를 4자 이상 입력해주세요.');			
			$('#upId').focus();
			return false;
		}
		if($('#upId').val().length > 20) {
			alert('ID를 20자 이하로 입력해주세요.');			
			$('#upId').focus();
			return false;
		}		
		if($('#upPw').val().length < 4) {
			alert('비밀번호를 4자 이상 입력해주세요.');
			$('#upPw').focus();
			return false;
		}
		if($('#upPw').val().length > 20) {
			alert('비밀번호를 20자 이하로 입력해주세요.');
			$('#upPw').focus();
			return false;
		}
		if($('#upName').val().length < 2) {
			alert('닉네임을 2자 이상 입력해주세요.');
			$('#upName').focus();
			return false;
		}
		if($('#upName').val().length > 20) {
			alert('닉네임을 20자 이하로 입력해주세요.');
			$('#upName').focus();
			return false;
		}
	}	